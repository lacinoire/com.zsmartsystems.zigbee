/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.prepayment;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Debt Amount Type value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum DebtAmountTypeEnum {

    /**
     * Type 1 Absolute, 0, 0x0000
     */
    TYPE_1_ABSOLUTE(0x0000),

    /**
     * Type 1 Incremental, 1, 0x0001
     */
    TYPE_1_INCREMENTAL(0x0001),

    /**
     * Type 2 Absolute, 2, 0x0002
     */
    TYPE_2_ABSOLUTE(0x0002),

    /**
     * Type 2 Incremental, 3, 0x0003
     */
    TYPE_2_INCREMENTAL(0x0003),

    /**
     * Type 3 Absolute, 4, 0x0004
     */
    TYPE_3_ABSOLUTE(0x0004),

    /**
     * Type 3 Incremental, 5, 0x0005
     */
    TYPE_3_INCREMENTAL(0x0005);

    /**
     * A mapping between the integer code and its corresponding DebtAmountTypeEnum type to facilitate lookup by value.
     */
    private static Map<Integer, DebtAmountTypeEnum> idMap;

    static {
        idMap = new HashMap<Integer, DebtAmountTypeEnum>();
        for (DebtAmountTypeEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private DebtAmountTypeEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static DebtAmountTypeEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
