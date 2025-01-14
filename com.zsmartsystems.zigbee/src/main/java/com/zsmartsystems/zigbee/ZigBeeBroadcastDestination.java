/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the broadcast destination addresses defined in the ZigBee protocol.
 * <p>
 * Broadcast transmissions shall not use the MAC sub-layer
 * acknowledgement; instead, a passive acknowledgement mechanism may be used.
 * Passive acknowledgement means that every ZigBee router and ZigBee
 * coordinator keeps track of which of its neighboring devices have successfully
 * relayed the broadcast transmission. The MAC sub-layer acknowledgement is
 * disabled by setting the acknowledged transmission flag of the TxOptions
 * parameter to FALSE. All other flags of the TxOptions parameter shall be set based
 * on the network configuration
 *
 * @author Chris Jackson
 *
 */
public enum ZigBeeBroadcastDestination {
    /**
     * All devices in PAN
     */
    BROADCAST_ALL_DEVICES(0xFFFF),

    /**
     * macRxOnWhenIdle = TRUE
     */
    BROADCAST_RX_ON(0xFFFD),

    /**
     * All routers and coordinator
     */
    BROADCAST_ROUTERS_AND_COORD(0xFFFC),

    /**
     * Low power routers only
     */
    BROADCAST_LOW_POWER_ROUTERS(0xFFFB),

    // Reserved values
    BROADCAST_RESERVED_FFFE(0xFFFE),
    BROADCAST_RESERVED_FFFA(0xFFFA),
    BROADCAST_RESERVED_FFF9(0xFFF9),
    BROADCAST_RESERVED_FFF8(0xFFF8);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, ZigBeeBroadcastDestination> codeMapping;

    private int key;

    private ZigBeeBroadcastDestination(int key) {
        this.key = key;
    }

    private static void initMapping() {
        codeMapping = new HashMap<Integer, ZigBeeBroadcastDestination>();
        for (ZigBeeBroadcastDestination s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    /**
     * Lookup function based on the broadcast address. Returns null if the address does not exist.
     *
     * @param address the address to lookup
     * @return enumeration value of the broadcast address.
     */
    public static ZigBeeBroadcastDestination getBroadcastDestination(int address) {
        if (codeMapping == null) {
            initMapping();
        }

        return codeMapping.get(address);
    }

    /**
     * @return the broadcast address to be sent over the air
     */
    public int getKey() {
        return key;
    }

    /**
     * Tests the supplied address to determine if it is a broadcast address
     *
     * @param address the address to test
     * @return true if the address is in the broadcast address range
     */
    public static boolean isBroadcast(int address) {
        return (address >= BROADCAST_RESERVED_FFF8.getKey() && address <= BROADCAST_ALL_DEVICES.getKey());
    }
}
