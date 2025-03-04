/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;

import com.zsmartsystems.zigbee.IeeeAddress;

/**
 * Class to implement the Telegesis command <b>Device Joined Network</b>.
 * <p>
 * New node has been given permission to join the PAN. NB joining is not complete until an “FFD”
 * prompt or similar is received
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisDeviceJoinedNetworkEvent extends TelegesisFrame implements TelegesisEvent {
    /**
     * NEWNODE response field
     */
    private Integer networkAddress;

    /**
     * NEWNODE response field
     */
    private IeeeAddress ieeeAddress;

    /**
     * NEWNODE response field
     */
    private Integer parentAddress;

    /**
     *
     * @return the networkAddress as {@link Integer}
     */
    public Integer getNetworkAddress() {
        return networkAddress;
    }

    /**
     *
     * @return the ieeeAddress as {@link IeeeAddress}
     */
    public IeeeAddress getIeeeAddress() {
        return ieeeAddress;
    }

    /**
     *
     * @return the parentAddress as {@link Integer}
     */
    public Integer getParentAddress() {
        return parentAddress;
    }


    @Override
    public void deserialize(int[] data) {
        initialiseDeserializer(data);

        // Deserialize the fields for the "NEWNODE" response
        if (testPrompt(data, "NEWNODE:")) {
            setDeserializer(8);

            // Deserialize field "network address"
            networkAddress = deserializeInt16();
            stepDeserializer();

            // Deserialize field "Ieee Address"
            ieeeAddress = deserializeIeeeAddress();
            stepDeserializer();

            // Deserialize field "parent address"
            parentAddress = deserializeInt16();
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(393);
        builder.append("TelegesisDeviceJoinedNetworkEvent [networkAddress=");
        builder.append(networkAddress);
        builder.append(", ieeeAddress=");
        builder.append(ieeeAddress);
        builder.append(", parentAddress=");
        builder.append(parentAddress);
        builder.append(']');
        return builder.toString();
    }
}
