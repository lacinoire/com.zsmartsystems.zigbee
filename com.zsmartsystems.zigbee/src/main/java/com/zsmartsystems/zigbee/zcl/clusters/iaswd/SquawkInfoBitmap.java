/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.iaswd;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Squawk Info value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum SquawkInfoBitmap {

    /**
     * Level, 3, 0x0003
     */
    LEVEL(0x0003),

    /**
     * Strobe, 8, 0x0008
     */
    STROBE(0x0008),

    /**
     * Mode, 240, 0x00F0
     */
    MODE(0x00F0);

    /**
     * A mapping between the integer code and its corresponding SquawkInfoBitmap type to facilitate lookup by value.
     */
    private static Map<Integer, SquawkInfoBitmap> idMap;

    static {
        idMap = new HashMap<Integer, SquawkInfoBitmap>();
        for (SquawkInfoBitmap enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private SquawkInfoBitmap(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static SquawkInfoBitmap getByValue(final int value) {
        return idMap.get(value);
    }
}
