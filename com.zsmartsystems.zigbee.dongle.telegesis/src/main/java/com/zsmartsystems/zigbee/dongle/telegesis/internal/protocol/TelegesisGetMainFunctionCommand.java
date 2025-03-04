/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;


/**
 * Class to implement the Telegesis command <b>Get Main Function</b>.
 * <p>
 * Gets the Extended Main configuration
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisGetMainFunctionCommand extends TelegesisFrame implements TelegesisCommand {
    /**
     * Response field
     */
    private Integer configuration;

    /**
     *
     * @return the configuration as {@link Integer}
     */
    public Integer getConfiguration() {
        return configuration;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand("ATS0A?");

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

        // Deserialize field "configuration"
        configuration = deserializeInt16();

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(211);
        builder.append("TelegesisGetMainFunctionCommand [configuration=");
        builder.append(String.format("%04X", configuration));
        if (status != null) {
            builder.append(", status=");
            builder.append(status);
        }
        builder.append(']');
        return builder.toString();
    }
}
