/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;

import com.zsmartsystems.zigbee.dongle.xbee.internal.protocol.CommandStatus;

/**
 * Class to implement the XBee command <b>Energy Scan</b>.
 * <p>
 * AT Command <b>ED</b></p>Start an Energy Detect scan. This command accepts an argument to
 * specify the time in milliseconds to scan IEEE 802.15.4 channels 11 through 26. The device
 * loops through all 16 channels until the time elapses and returns the maximal energy on each
 * channel. In Transparent mode, a comma must follow each value with the list ending with a
 * carriage return. The values returned reflect the detected energy level in units of -dBm.
 * Convert an ED response of 49, 3A, and so on, to decimal to become -73 dBm, -58 dBm, and so on.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeEnergyScanResponse extends XBeeFrame implements XBeeResponse {
    /**
     * Response field
     */
    private Integer frameId;

    /**
     * Response field
     */
    private CommandStatus commandStatus;

    /**
     *
     * @return the frameId as {@link Integer}
     */
    public Integer getFrameId() {
        return frameId;
    }

    /**
     *
     * @return the commandStatus as {@link CommandStatus}
     */
    public CommandStatus getCommandStatus() {
        return commandStatus;
    }


    @Override
    public void deserialize(int[] incomingData) {
        initialiseDeserializer(incomingData);

        // Deserialize the fields for the response

        // Deserialize field "Frame ID"
        frameId = deserializeInt8();
        deserializeAtCommand();

        // Deserialize field "Command Status"
        commandStatus = deserializeCommandStatus();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(382);
        builder.append("XBeeEnergyScanResponse [frameId=");
        builder.append(frameId);
        builder.append(", commandStatus=");
        builder.append(commandStatus);
        builder.append(']');
        return builder.toString();
    }
}
