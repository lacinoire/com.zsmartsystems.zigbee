/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;


/**
 * Class to implement the Telegesis command <b>Nack Message</b>.
 * <p>
 * Acknowledgement for message XX was not received
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisNackMessageEvent extends TelegesisFrame implements TelegesisEvent {
    /**
     * NACK response field
     */
    private Integer messageId;

    /**
     *
     * @return the messageId as {@link Integer}
     */
    public Integer getMessageId() {
        return messageId;
    }


    @Override
    public void deserialize(int[] data) {
        initialiseDeserializer(data);

        // Deserialize the fields for the "NACK" response
        if (testPrompt(data, "NACK:")) {
            setDeserializer(5);

            // Deserialize field "message ID"
            messageId = deserializeInt8();
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(205);
        builder.append("TelegesisNackMessageEvent [messageId=");
        builder.append(messageId);
        builder.append(']');
        return builder.toString();
    }
}
