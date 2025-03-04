/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsmartsystems.zigbee.dongle.telegesis.ZigBeeDongleTelegesis;
import com.zsmartsystems.zigbee.transport.ZigBeePort;
import com.zsmartsystems.zigbee.transport.ZigBeePort.FlowControl;
import com.zsmartsystems.zigbee.transport.ZigBeeTransportFirmwareCallback;
import com.zsmartsystems.zigbee.transport.ZigBeeTransportFirmwareStatus;

/**
 * Firmware update handler for the Telegesis dongle
 *
 * @author Chris Jackson
 *
 */
public class TelegesisFirmwareUpdateHandler {
    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(TelegesisFirmwareUpdateHandler.class);

    private final InputStream firmware;
    private final ZigBeePort serialPort;
    private final ZigBeeTransportFirmwareCallback callback;

    private final long TIMEOUT_IN_NANOS = TimeUnit.SECONDS.toNanos(10);
    private final long BL_TIMEOUT_IN_NANOS = TimeUnit.SECONDS.toNanos(3);
    private final int BYTE_READ_TIMEOUT_IN_MS = 250;

    private final int MENU_MAX_RETRIES = 5;
    private final int XMODEM_MAX_RETRIES = 10;
    private final int XMODEL_CRC_POLYNOMIAL = 0x1021;
    private final int BOOTLOAD_BAUD_RATE = 115200;
    private final int DATA_CHUNK_SIZE = 128;

    private final int CRN = '\n';
    private final int SOH = 0x01;
    private final int EOT = 0x04;
    private final int ACK = 0x06;
    private final int NAK = 0x15;
    private final int CAN = 0x18;
    private final int XMODEM_CRC_READY = 0x43; // ASCII 'C'

    /**
     * Flag to stop the current transfer
     */
    private boolean stopBootload = false;

    /**
     * Reference to our master
     */
    private final ZigBeeDongleTelegesis dongle;

    /**
     * Constructor for the firmware handler
     *
     * @param dongle the {@link ZigBeeDongleTelegesis} to receive the completion notification
     * @param firmware {@link InputStream} containing the data
     * @param serialPort {@link ZigBeePort} to communicate on
     * @param callback {@link ZigBeeTransportFirmwareCallback} to provide status updates
     */
    public TelegesisFirmwareUpdateHandler(ZigBeeDongleTelegesis dongle, InputStream firmware, ZigBeePort serialPort,
            ZigBeeTransportFirmwareCallback callback) {
        this.dongle = dongle;
        this.firmware = firmware;
        this.serialPort = serialPort;
        this.callback = callback;
    }

    /**
     * Starts the bootload.
     * The routine will open the serial port at 115200baud. It will send a CR up to 3 times waiting for the bootloader
     * prompt. It will then select the upload option, transfer the file, then run. The serial port will then be closed.
     *
     */
    public void startBootload() {
        Thread firmwareThread = new Thread("TelegesisFirmwareUpdateHandler") {
            @Override
            public void run() {
                try {
                    doUpdate();
                } finally {
                    try {
                        firmware.close();
                    } catch (IOException e) {
                        // ignored
                    }
                }
            }
        };
        firmwareThread.setPriority(Thread.MAX_PRIORITY);
        firmwareThread.start();
    }

    /**
     * Cancel a bootload
     */
    public void cancelUpdate() {
        stopBootload = true;
    }

    /**
     * Waits for {@link #XMODEM_CRC_READY} byte to show up.
     *
     * @return true if {@link #XMODEM_CRC_READY} byte was read before {@link #TIMEOUT_IN_NANOS} was reached, false
     *         otherwise.
     */
    private boolean waitForReady() {
        long start = System.nanoTime();
        while (serialPort.read(BYTE_READ_TIMEOUT_IN_MS) != XMODEM_CRC_READY) {
            if ((System.nanoTime() - start) > TIMEOUT_IN_NANOS) {
                return false;
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }

        return true;
    }

    /**
     * Performs the actual update
     */
    private void doUpdate() {
        logger.debug("Telegesis bootloader: Starting.");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // Eat me!
        }
        if (!serialPort.open(BOOTLOAD_BAUD_RATE, FlowControl.FLOWCONTROL_OUT_NONE)) {
            logger.debug("Telegesis bootloader: Failed to open serial port.");
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
            return;
        }

        logger.debug("Telegesis bootloader: Serial port opened.");

        // Wait for the bootload menu prompt
        if (!getBlPrompt()) {
            logger.debug("Telegesis bootloader: Failed waiting for menu before transfer.");
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
            return;
        }
        logger.debug("Telegesis bootloader: Got bootloader prompt.");

        // Select option 1 to upload the file
        serialPort.write('1');

        // Short delay here to allow all bootloader menu data to be received so there's no confusion with acks.
        if (!waitForReady()) {
            logger.debug("Telegesis bootloader: Failed waiting for ready character before starting transfer!");
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
            return;
        }

        callback.firmwareUpdateCallback(ZigBeeTransportFirmwareStatus.FIRMWARE_TRANSFER_STARTED);
        boolean bootloadOk = transferFile();
        if (bootloadOk) {
            callback.firmwareUpdateCallback(ZigBeeTransportFirmwareStatus.FIRMWARE_TRANSFER_COMPLETE);
            logger.debug("Telegesis bootloader: Transfer successful.");
        } else {
            logger.debug("Telegesis bootloader: Transfer failed.");
        }

        // Short delay here to allow completion. This is mainly required if there was an abort.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Eat me!
        }

        // Transfer was completed, or aborted. Either way all we can do is run the firmware and it should return
        // to the main prompt

        logger.debug("Telegesis bootloader: Waiting for menu.");

        // Wait for the bootload menu prompt
        if (!getBlPrompt()) {
            logger.debug("Telegesis bootloader: Failed waiting for menu after transfer.");
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
            return;
        }

        // Select 2 to run
        logger.debug("Telegesis bootloader: Running firmware.");
        serialPort.write('2');

        // Short delay here to allow all bootloader to run.
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Eat me!
        }

        logger.debug("Telegesis bootloader: Done.");

        // We're done - either we completed, or it was cancelled
        if (!bootloadOk) {
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
        } else if (stopBootload) {
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_CANCELLED);
        } else {
            transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_COMPLETE);
        }
    }

    /**
     * Waits for the Telegesis bootloader "BL >" response
     *
     * @return true if the prompt is found
     */
    private boolean getBlPrompt() {
        int[] matcher = new int[] { 'B', 'L', ' ', '>' };
        int matcherCount = 0;

        int retryCount = 0;
        while (retryCount < MENU_MAX_RETRIES) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // Eat me!
            }
            serialPort.purgeRxBuffer();

            // Send CR to wake up the bootloader
            serialPort.write(CRN);

            long start = System.nanoTime();
            while ((System.nanoTime() - start) < BL_TIMEOUT_IN_NANOS) {
                int val = serialPort.read(BYTE_READ_TIMEOUT_IN_MS);
                if (val == -1) {
                    continue;
                }

                if (logger.isTraceEnabled()) {
                    logger.trace("Ember bootloader: get prompt read {}", String.format("%02X %c", val, val));
                }
                if (val != matcher[matcherCount]) {
                    matcherCount = 0;
                    continue;
                }

                matcherCount++;
                if (matcherCount == matcher.length) {
                    return true;
                }
            }

            retryCount++;
        }

        logger.debug("Telegesis bootloader: Unable to get bootloader prompt.");
        transferComplete(ZigBeeTransportFirmwareStatus.FIRMWARE_UPDATE_FAILED);
        return false;
    }

    private ByteBuffer readChunk(InputStream is) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(DATA_CHUNK_SIZE);
        int data;
        // read until we either got DATA_CHUNK_SIZE bytes or the stream has reached its end
        while (byteBuffer.hasRemaining() && (data = is.read()) != -1) {
            byteBuffer.put((byte) data);
        }
        return byteBuffer;
    }

    /**
     * Sends End Of Transfer frame and waits for ACK response, retries up to {@link #XMODEM_MAX_RETRIES} times.
     */
    private void sendEOT() {
        int retries = 0;
        do {
            serialPort.write(EOT);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // ignored
            }
        } while (getTransferResponse() != ACK && retries++ < XMODEM_MAX_RETRIES);
    }

    private String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    private String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i])).append(" ");
        }
        return hexStringBuffer.toString();
    }

    /**
     * Transfers the file using the XModem protocol
     *
     * @return true if the transfer completed successfully
     */
    private boolean transferFile() {
        int retries;
        int response;
        int frame = 1;
        boolean done;
        boolean cancelTransfer = false;

        // Clear all input in the input stream before starting the transfer
        try {
            logger.debug("Telegesis bootloader: Clearing input stream...");
            serialPort.purgeRxBuffer();

            logger.debug("Telegesis bootloader: Starting transfer.");
            while (!stopBootload && !cancelTransfer) {
                retries = 0;
                // Output DATA_CHUNK_SIZE bytes
                ByteBuffer data = readChunk(firmware);
                done = data.position() < DATA_CHUNK_SIZE;

                do {
                    logger.debug("Telegesis bootloader: Transfer frame {}, attempt {}.", frame, retries);

                    // Send SOH
                    if (logger.isTraceEnabled()) {
                        logger.trace("Telegesis bootloader: Write SOH");
                    }
                    serialPort.write(SOH);

                    if (logger.isTraceEnabled()) {
                        logger.trace("Telegesis bootloader: Write frame count");
                    }
                    // Send frame count
                    serialPort.write(frame);
                    serialPort.write(255 - frame);

                    // Allow 10 retries
                    if (retries++ > XMODEM_MAX_RETRIES) {
                        sendEOT();
                        return false;
                    }

                    if (logger.isTraceEnabled()) {
                        logger.trace("Telegesis bootloader: Chunk data hasArray: {}", data.hasArray());
                        logger.trace("Telegesis bootloader: Chunk data len: {}", data.array().length);
                        logger.trace("Telegesis bootloader: Chunk data: {}, done: {}", encodeHexString(data.array()), done);
                    }

                    int crc = 0;
                    int countWriteCalls = 0;
                    for (int value : data.array()) {
                        serialPort.write(value);
                        countWriteCalls++;
                        for (int i = 0; i < 8; i++) {
                            boolean bit = ((value >> (7 - i) & 1) == 1);
                            boolean c15 = ((crc >> 15 & 1) == 1);
                            crc <<= 1;
                            // If coefficient of bit and remainder polynomial = 1 xor crc with polynomial
                            if (c15 ^ bit) {
                                crc ^= XMODEL_CRC_POLYNOMIAL;
                            }
                        }
                    }
                    crc &= 0xffff;

                    if (logger.isTraceEnabled()) {
                        logger.trace("Telegesis bootloader: Number of serialPort.write invocations: {}",
                                countWriteCalls);
                        logger.trace("Telegesis bootloader: CRC for chunk: {}", crc);
                        logger.trace("Telegesis bootloader: Write CRC");
                    }
                    serialPort.write((crc >> 8) & 0xff);
                    serialPort.write(crc & 0xff);

                    // Wait for the acknowledgment
                    do {
                        response = getTransferResponse();
                    } while (response == XMODEM_CRC_READY);

                    if (logger.isTraceEnabled()) {
                        logger.debug("Telegesis bootloader: Response {}.", response);
                    }

                    if (response == CAN) {
                        logger.debug("Telegesis bootloader: Received CAN.");
                        retries = XMODEM_MAX_RETRIES;
                        cancelTransfer = true;
                        break;
                    }
                } while (response != ACK);

                if (done) {
                    logger.debug("Telegesis bootloader: Transfer complete.");
                    sendEOT();
                    return true;
                }

                frame = (frame + 1) & 0xff;
            }
        } catch (IOException e) {
            logger.debug("Telegesis bootloader: Transfer failed due IO error.");
        }

        serialPort.write(EOT);
        return false;
    }

    /**
     * Waits for a single byte response as part of the XModem protocol
     *
     * @return the value of the received data, or NAK on timeout
     */
    private int getTransferResponse() {
        long start = System.nanoTime();
        while (!stopBootload) {
            int val = serialPort.read(BYTE_READ_TIMEOUT_IN_MS);
            if (val == -1) {
                if ((System.nanoTime() - start) > TIMEOUT_IN_NANOS) {
                    if (logger.isTraceEnabled()) {
                        logger.trace("Telegesis bootloader: getTransferResponse timeout returning NAK.");
                    }

                    return NAK;
                }
                continue;
            } else {
                if (logger.isTraceEnabled()) {
                    logger.trace("Telegesis bootloader: getTransferResponse read value {}", val);
                }

                return val;
            }
        }

        if (logger.isTraceEnabled()) {
            logger.trace("Telegesis bootloader: NAK default case returning NAK");
        }

        return NAK;
    }

    /**
     * Clean up and notify everyone that we're done.
     *
     * @param status the final {@link ZigBeeTransportFirmwareStatus} at completion
     */
    private void transferComplete(ZigBeeTransportFirmwareStatus status) {
        serialPort.close();

        callback.firmwareUpdateCallback(status);
        dongle.bootloadComplete();
    }
}
