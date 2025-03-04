/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement the Ember Enumeration <b>EmberAddressConstants</b>.
 * <p>
 * Constants used in Ember API address and table management
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public enum EmberAddressConstants {
    /**
     * Default unknown value
     */
    UNKNOWN(-1),

    /**
     * A distinguished network ID that will never be assigned to any node.
     */
    EMBER_TABLE_ENTRY_UNUSED_NODE_ID(0xFFFF),

    /**
     * A distinguished network ID that will never be assigned to any node. This value is returned
     * when getting the remote node ID from the binding table and the given binding table index
     * refers to a multicast binding entry.
     */
    EMBER_MULTICAST_NODE_ID(0xFFFE),

    /**
     * A distinguished network ID that will never be assigned to any node. This value is used when
     * getting the remote node ID from the address or binding tables. It indicates that the address
     * or binding table entry is currently in use but the node ID corresponding to the EUI64 in the
     * table is currently unknown.
     */
    EMBER_UNKNOWN_NODE_ID(0xFFFD),

    /**
     * A distinguished network ID that will never be assigned to any node. This value is used when
     * getting the remote node ID from the address or binding tables. It indicates that the address
     * or binding table entry is currently in use and network address discovery is underway.
     */
    EMBER_DISCOVERY_ACTIVE_NODE_ID(0xFFFC);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, EmberAddressConstants> codeMapping;

    private int key;

    static {
        codeMapping = new HashMap<Integer, EmberAddressConstants>();
        for (EmberAddressConstants s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    private EmberAddressConstants(int key) {
        this.key = key;
    }

    /**
     * Lookup function based on the EmberStatus type code. Returns null if the
     * code does not exist.
     *
     * @param code the code to lookup
     * @return enumeration value of the alarm type.
     */
    public static EmberAddressConstants getEmberAddressConstants(int code) {
        if (codeMapping.get(code) == null) {
            return UNKNOWN;
        }

        return codeMapping.get(code);
    }

    /**
     * Returns the EZSP protocol defined value for this enumeration.
     *
     * @return the EZSP protocol key
     */
    public int getKey() {
        return key;
    }
}
