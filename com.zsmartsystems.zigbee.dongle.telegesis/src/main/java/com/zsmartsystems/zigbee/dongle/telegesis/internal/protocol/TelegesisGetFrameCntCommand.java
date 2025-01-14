/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;


/**
 * Class to implement the Telegesis command <b>Get Frame Cnt</b>.
 * <p>
 * Gets the security frame counter
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisGetFrameCntCommand extends TelegesisFrame implements TelegesisCommand {
    /**
     * Response field
     */
    private Long frameCnt;

    /**
     *
     * @return the frameCnt as {@link Long}
     */
    public Long getFrameCnt() {
        return frameCnt;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand("AT+FRAMECNT?");

        return getPayload();
    }

    @Override
    public boolean deserialize(int[] data) {
        // Handle standard status responses (ie. OK / ERROR)
        if (handleIncomingStatus(data)) {
            return true;
        }

        initialiseDeserializer(data);

        // Deserialize the fields for the response

        // Deserialize field "frame cnt"
        frameCnt = deserializeInt32();

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(207);
        builder.append("TelegesisGetFrameCntCommand [frameCnt=");
        builder.append(String.format("%08X", frameCnt));
        if (status != null) {
            builder.append(", status=");
            builder.append(status);
        }
        builder.append(']');
        return builder.toString();
    }
}
