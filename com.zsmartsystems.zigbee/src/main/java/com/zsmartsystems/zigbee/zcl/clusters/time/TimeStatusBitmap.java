/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.time;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Time Status value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum TimeStatusBitmap {

    /**
     * Master, 1, 0x0001
     */
    MASTER(0x0001),

    /**
     * Synchronized, 2, 0x0002
     */
    SYNCHRONIZED(0x0002),

    /**
     * Master Zone DST, 4, 0x0004
     */
    MASTER_ZONE_DST(0x0004),

    /**
     * Superseding, 8, 0x0008
     */
    SUPERSEDING(0x0008);

    /**
     * A mapping between the integer code and its corresponding TimeStatusBitmap type to facilitate lookup by value.
     */
    private static Map<Integer, TimeStatusBitmap> idMap;

    static {
        idMap = new HashMap<Integer, TimeStatusBitmap>();
        for (TimeStatusBitmap enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private TimeStatusBitmap(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static TimeStatusBitmap getByValue(final int value) {
        return idMap.get(value);
    }
}
