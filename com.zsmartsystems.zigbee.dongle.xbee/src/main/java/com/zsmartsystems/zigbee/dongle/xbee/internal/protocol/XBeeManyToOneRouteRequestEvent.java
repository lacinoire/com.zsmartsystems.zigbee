/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;

import com.zsmartsystems.zigbee.IeeeAddress;

/**
 * Class to implement the XBee command <b>Many-to-One Route Request</b>.
 * <p>
 * The many-to-one route request indicator frame is sent out the serial port when a many-to-one
 * route request is received.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeManyToOneRouteRequestEvent extends XBeeFrame implements XBeeEvent {
    /**
     * Response field
     * MSB first, LSB last. The 64-bit address of the device that initiated the route record.
     */
    private IeeeAddress ieeeAddress;

    /**
     * Response field
     * The sender's 16-bit address.
     */
    private Integer networkAddress;

    /**
     * MSB first, LSB last. The 64-bit address of the device that initiated the route record.
     *
     * @return the ieeeAddress as {@link IeeeAddress}
     */
    public IeeeAddress getIeeeAddress() {
        return ieeeAddress;
    }

    /**
     * The sender's 16-bit address.
     *
     * @return the networkAddress as {@link Integer}
     */
    public Integer getNetworkAddress() {
        return networkAddress;
    }


    @Override
    public void deserialize(int[] incomingData) {
        initialiseDeserializer(incomingData);

        // Deserialize the fields for the response

        // Deserialize field "Ieee Address"
        ieeeAddress = deserializeIeeeAddress();

        // Deserialize field "Network Address"
        networkAddress = deserializeInt16();
        deserializeInt8();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(390);
        builder.append("XBeeManyToOneRouteRequestEvent [ieeeAddress=");
        builder.append(ieeeAddress);
        builder.append(", networkAddress=");
        builder.append(networkAddress);
        builder.append(']');
        return builder.toString();
    }
}
