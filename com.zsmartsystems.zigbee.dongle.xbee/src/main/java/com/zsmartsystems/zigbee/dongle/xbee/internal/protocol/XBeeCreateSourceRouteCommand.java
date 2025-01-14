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
 * Class to implement the XBee command <b>Create Source Route</b>.
 * <p>
 * This frame creates a source route in the device. A source route specifies the complete route a
 * packet traverses to get from source to destination. For best results, use source routing
 * with many-to-one routing. There is no response frame for this frame type. Take care when
 * generating source routes. An incorrectly formatted frame will be silently rejected by the
 * radio or cause unexpected results.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeCreateSourceRouteCommand extends XBeeFrame implements XBeeCommand {
    /**
     * The frame Id
     */
    private Integer frameId;

    /**
     * 64-bit destination address. MSB first, LSB last. Set to the 64-bit address of the
     * destination device. Reserved 64-bit address for the coordinator = 0x0000000000000000
     * Broadcast = 0x000000000000FFFF.
     */
    private IeeeAddress ieeeAddress;

    /**
     * 16-bit destination network address. Set to the 16-bit address of the destination device, if
     * known. If the address is unknown or if sending a broadcast, set to 0xFFFE.
     */
    private Integer networkAddress;

    /**
     */
    private int[] addressList;

    /**
     * The frame Id
     *
     * @param frameId the frameId to set as {@link Integer}
     */
    public void setFrameId(Integer frameId) {
        this.frameId = frameId;
    }

    /**
     * 64-bit destination address. MSB first, LSB last. Set to the 64-bit address of the
     * destination device. Reserved 64-bit address for the coordinator = 0x0000000000000000
     * Broadcast = 0x000000000000FFFF.
     *
     * @param ieeeAddress the ieeeAddress to set as {@link IeeeAddress}
     */
    public void setIeeeAddress(IeeeAddress ieeeAddress) {
        this.ieeeAddress = ieeeAddress;
    }

    /**
     * 16-bit destination network address. Set to the 16-bit address of the destination device, if
     * known. If the address is unknown or if sending a broadcast, set to 0xFFFE.
     *
     * @param networkAddress the networkAddress to set as {@link Integer}
     */
    public void setNetworkAddress(Integer networkAddress) {
        this.networkAddress = networkAddress;
    }

    /**
     *
     * @param addressList the addressList to set as {@link int[]}
     */
    public void setAddressList(int[] addressList) {
        this.addressList = addressList;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand(0x21);
        serializeInt8(frameId);
        serializeIeeeAddress(ieeeAddress);
        serializeInt16(networkAddress);
        serializeInt8(0);
        serializeInt8(addressList.length);
        serializeInt16Array(addressList);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(658);
        // First present the command parameters...
        // Then the responses later if they are available
        builder.append("XBeeCreateSourceRouteCommand [frameId=");
        builder.append(frameId);
        builder.append(", ieeeAddress=");
        builder.append(ieeeAddress);
        builder.append(", networkAddress=");
        builder.append(networkAddress);
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
