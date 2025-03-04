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
 * Class to implement the XBee command <b>API Mode</b>.
 * <p>
 * AT Command <b>AO</b></p>Configure the options for API. The current options select the type
 * of receive API frame to send out the UART for received RF data packets. 0 Default API Rx
 * Indicator enabled 1 Default API Explicit Rx Indicator - 0x91, this is for Explicit
 * Addressing data frames. 3 Enable ZDO passthrough of ZDO requests to the serial port that are
 * not supported by the stack, as well as Simple_Desc_req, Active_EP_req, and
 * Match_Desc_req.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeApiModeResponse extends XBeeFrame implements XBeeResponse {
    /**
     * Response field
     */
    private Integer frameId;

    /**
     * Response field
     */
    private CommandStatus commandStatus;

    /**
     * Response field
     */
    private Integer mode;

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

    /**
     *
     * @return the mode as {@link Integer}
     */
    public Integer getMode() {
        return mode;
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
        if (commandStatus != CommandStatus.OK || isComplete()) {
            return;
        }

        // Deserialize field "Mode"
        mode = deserializeInt8();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(469);
        builder.append("XBeeApiModeResponse [frameId=");
        builder.append(frameId);
        builder.append(", commandStatus=");
        builder.append(commandStatus);
        if (commandStatus == CommandStatus.OK) {
            builder.append(", mode=");
            builder.append(mode);
        }
        builder.append(']');
        return builder.toString();
    }
}
