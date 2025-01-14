/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.xbee.internal.protocol.ReceiveOptions;

/**
 * Class to implement the XBee command <b>Route Record</b>.
 * <p>
 * The route record indicator is received whenever a device sends a ZigBee route record
 * command. The device uses the route record indicator with many-to-one routing to create
 * source routes for devices in a network.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeRouteRecordEvent extends XBeeFrame implements XBeeEvent {
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
     * Response field
     */
    private ReceiveOptions receiveOptions;

    /**
     * Response field
     * The number of addresses in the source route (excluding source and destination).
     */
    private int[] addressList;

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

    /**
     *
     * @return the receiveOptions as {@link ReceiveOptions}
     */
    public ReceiveOptions getReceiveOptions() {
        return receiveOptions;
    }

    /**
     * The number of addresses in the source route (excluding source and destination).
     *
     * @return the addressList as {@link int[]}
     */
    public int[] getAddressList() {
        return addressList;
    }


    @Override
    public void deserialize(int[] incomingData) {
        initialiseDeserializer(incomingData);

        // Deserialize the fields for the response

        // Deserialize field "Ieee Address"
        ieeeAddress = deserializeIeeeAddress();

        // Deserialize field "Network Address"
        networkAddress = deserializeInt16();

        // Deserialize field "Receive Options"
        receiveOptions = deserializeReceiveOptions();

        // Deserialize field "Number of addresses"
        int numberOfAddresses = deserializeInt8();

        // Deserialize field "Address List"
        addressList = deserializeInt16Array(numberOfAddresses);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(560);
        builder.append("XBeeRouteRecordEvent [ieeeAddress=");
        builder.append(ieeeAddress);
        builder.append(", networkAddress=");
        builder.append(networkAddress);
        builder.append(", receiveOptions=");
        builder.append(receiveOptions);
        builder.append(", addressList=");
        if (addressList == null) {
            builder.append("null");
        } else {
            for (int cnt = 0; cnt < addressList.length; cnt++) {
                if (cnt > 0) {
                    builder.append(' ');
                }
                builder.append(String.format("%04X", addressList[cnt]));
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
