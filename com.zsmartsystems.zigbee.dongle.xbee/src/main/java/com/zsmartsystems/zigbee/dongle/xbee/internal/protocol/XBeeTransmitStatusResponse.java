/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;

import com.zsmartsystems.zigbee.dongle.xbee.internal.protocol.DeliveryStatus;
import com.zsmartsystems.zigbee.dongle.xbee.internal.protocol.DiscoveryStatus;

/**
 * Class to implement the XBee command <b>Transmit Status</b>.
 * <p>
 * When a Transmit Request (0x10, 0x11) completes, the device sends a Transmit Status message
 * out of the serial interface. This message indicates if the Transmit Request was successful
 * or if it failed.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeTransmitStatusResponse extends XBeeFrame implements XBeeResponse {
    /**
     * Response field
     * The frame Id
     */
    private Integer frameId;

    /**
     * Response field
     * The 16-bit Network Address where the packet was delivered (if successful). If not
     * successful, this address is 0xFFFD (destination address 6 unknown).
     */
    private Integer networkAddress;

    /**
     * Response field
     * The number of application transmission retries that occur.
     */
    private Integer transmitRetryCount;

    /**
     * Response field
     */
    private DeliveryStatus deliveryStatus;

    /**
     * Response field
     */
    private DiscoveryStatus discoveryStatus;

    /**
     * The frame Id
     *
     * @return the frameId as {@link Integer}
     */
    public Integer getFrameId() {
        return frameId;
    }

    /**
     * The 16-bit Network Address where the packet was delivered (if successful). If not
     * successful, this address is 0xFFFD (destination address 6 unknown).
     *
     * @return the networkAddress as {@link Integer}
     */
    public Integer getNetworkAddress() {
        return networkAddress;
    }

    /**
     * The number of application transmission retries that occur.
     *
     * @return the transmitRetryCount as {@link Integer}
     */
    public Integer getTransmitRetryCount() {
        return transmitRetryCount;
    }

    /**
     *
     * @return the deliveryStatus as {@link DeliveryStatus}
     */
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     *
     * @return the discoveryStatus as {@link DiscoveryStatus}
     */
    public DiscoveryStatus getDiscoveryStatus() {
        return discoveryStatus;
    }


    @Override
    public void deserialize(int[] incomingData) {
        initialiseDeserializer(incomingData);

        // Deserialize the fields for the response

        // Deserialize field "Frame Id"
        frameId = deserializeInt8();

        // Deserialize field "Network Address"
        networkAddress = deserializeInt16();

        // Deserialize field "Transmit retry count"
        transmitRetryCount = deserializeInt8();

        // Deserialize field "Delivery status"
        deliveryStatus = deserializeDeliveryStatus();

        // Deserialize field "Discovery status"
        discoveryStatus = deserializeDiscoveryStatus();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(566);
        builder.append("XBeeTransmitStatusResponse [frameId=");
        builder.append(frameId);
        builder.append(", networkAddress=");
        builder.append(networkAddress);
        builder.append(", transmitRetryCount=");
        builder.append(transmitRetryCount);
        builder.append(", deliveryStatus=");
        builder.append(deliveryStatus);
        builder.append(", discoveryStatus=");
        builder.append(discoveryStatus);
        builder.append(']');
        return builder.toString();
    }
}
