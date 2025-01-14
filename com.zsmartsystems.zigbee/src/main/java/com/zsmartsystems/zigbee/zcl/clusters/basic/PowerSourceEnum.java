/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.basic;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Power Source value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum PowerSourceEnum {

    /**
     * Unknown, 0, 0x0000
     */
    UNKNOWN(0x0000),

    /**
     * Mains Single Phase, 1, 0x0001
     */
    MAINS_SINGLE_PHASE(0x0001),

    /**
     * Mains Three Phase, 2, 0x0002
     */
    MAINS_THREE_PHASE(0x0002),

    /**
     * Battery, 3, 0x0003
     */
    BATTERY(0x0003),

    /**
     * DC Source, 4, 0x0004
     */
    DC_SOURCE(0x0004),

    /**
     * Emergency Mains Constant, 5, 0x0005
     */
    EMERGENCY_MAINS_CONSTANT(0x0005),

    /**
     * Emergency Mains Changeover, 6, 0x0006
     */
    EMERGENCY_MAINS_CHANGEOVER(0x0006);

    /**
     * A mapping between the integer code and its corresponding PowerSourceEnum type to facilitate lookup by value.
     */
    private static Map<Integer, PowerSourceEnum> idMap;

    static {
        idMap = new HashMap<Integer, PowerSourceEnum>();
        for (PowerSourceEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private PowerSourceEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static PowerSourceEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
