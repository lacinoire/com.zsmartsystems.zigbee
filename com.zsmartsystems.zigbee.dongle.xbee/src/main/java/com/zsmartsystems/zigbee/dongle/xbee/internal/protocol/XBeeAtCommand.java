/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;


/**
 * Class to implement the XBee command <b>AT</b>.
 * <p>
 * Use this frame to query or set device parameters on the local device. This API command applies
 * changes after running the command. You can query parameter values by sending the 0x08 AT
 * Command frame with no parameter value field (the two-byte AT command is immediately
 * followed by the frame checksum).
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeAtCommand extends XBeeFrame implements XBeeCommand {
    /**
     * The frame Id
     */
    private Integer frameId;

    /**
     * Command name: two ASCII characters that identify the AT command.
     */
    private String atCommand;

    /**
     * If present, indicates the requested parameter value to set the given register. If no
     * characters are present, it queries the register.
     */
    private int[] parameterValue;

    /**
     * The frame Id
     *
     * @param frameId the frameId to set as {@link Integer}
     */
    public void setFrameId(Integer frameId) {
        this.frameId = frameId;
    }

    /**
     * Command name: two ASCII characters that identify the AT command.
     *
     * @param atCommand the atCommand to set as {@link String}
     */
    public void setAtCommand(String atCommand) {
        this.atCommand = atCommand;
    }

    /**
     * If present, indicates the requested parameter value to set the given register. If no
     * characters are present, it queries the register.
     *
     * @param parameterValue the parameterValue to set as {@link int[]}
     */
    public void setParameterValue(int[] parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand(0x08);
        serializeInt8(frameId);
        serializeAtCommand(atCommand);
        serializeData(parameterValue);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(373);
        // First present the command parameters...
        // Then the responses later if they are available
        builder.append("XBeeAtCommand [frameId=");
        builder.append(frameId);
        builder.append(", atCommand=");
        builder.append(atCommand);
        builder.append(", parameterValue=");
        if (parameterValue == null) {
            builder.append("null");
        } else {
            for (int cnt = 0; cnt < parameterValue.length; cnt++) {
                if (cnt > 0) {
                    builder.append(' ');
                }
                builder.append(String.format("%02X", parameterValue[cnt]));
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
