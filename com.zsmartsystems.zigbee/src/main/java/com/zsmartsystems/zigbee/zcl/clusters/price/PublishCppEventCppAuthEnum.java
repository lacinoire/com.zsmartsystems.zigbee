/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.price;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Publish Cpp Event Cpp Auth value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum PublishCppEventCppAuthEnum {

    /**
     * Pending, 0, 0x0000
     */
    PENDING(0x0000),

    /**
     * Accepted, 1, 0x0001
     */
    ACCEPTED(0x0001),

    /**
     * Rejected, 2, 0x0002
     */
    REJECTED(0x0002),

    /**
     * Forced, 3, 0x0003
     */
    FORCED(0x0003);

    /**
     * A mapping between the integer code and its corresponding PublishCppEventCppAuthEnum type to facilitate lookup by value.
     */
    private static Map<Integer, PublishCppEventCppAuthEnum> idMap;

    static {
        idMap = new HashMap<Integer, PublishCppEventCppAuthEnum>();
        for (PublishCppEventCppAuthEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private PublishCppEventCppAuthEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static PublishCppEventCppAuthEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
