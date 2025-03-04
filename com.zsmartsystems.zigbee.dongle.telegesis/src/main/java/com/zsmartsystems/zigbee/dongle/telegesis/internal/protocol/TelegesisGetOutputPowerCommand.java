/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;


/**
 * Class to implement the Telegesis command <b>Get Output Power</b>.
 * <p>
 * Gets the device’s transmit power level in dBm.
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisGetOutputPowerCommand extends TelegesisFrame implements TelegesisCommand {
    /**
     * Response field
     */
    private Integer powerLevel;

    /**
     *
     * @return the powerLevel as {@link Integer}
     */
    public Integer getPowerLevel() {
        return powerLevel;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand("ATS01?");

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

        // Deserialize field "power level"
        powerLevel = deserializeSInt8();

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(210);
        builder.append("TelegesisGetOutputPowerCommand [powerLevel=");
        builder.append(powerLevel);
        if (status != null) {
            builder.append(", status=");
            builder.append(status);
        }
        builder.append(']');
        return builder.toString();
    }
}
