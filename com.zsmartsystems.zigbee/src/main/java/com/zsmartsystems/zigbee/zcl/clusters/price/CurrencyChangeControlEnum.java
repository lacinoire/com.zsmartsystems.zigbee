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
 * Currency Change Control value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum CurrencyChangeControlEnum {

    /**
     * Clear Billing Info, 1, 0x0001
     */
    CLEAR_BILLING_INFO(0x0001),

    /**
     * Convert Billing Info Using New Currency, 2, 0x0002
     */
    CONVERT_BILLING_INFO_USING_NEW_CURRENCY(0x0002),

    /**
     * Clear Old Consumption Data, 4, 0x0004
     */
    CLEAR_OLD_CONSUMPTION_DATA(0x0004),

    /**
     * Convert Old Consumption Data Using New Currency, 8, 0x0008
     */
    CONVERT_OLD_CONSUMPTION_DATA_USING_NEW_CURRENCY(0x0008);

    /**
     * A mapping between the integer code and its corresponding CurrencyChangeControlEnum type to facilitate lookup by value.
     */
    private static Map<Integer, CurrencyChangeControlEnum> idMap;

    static {
        idMap = new HashMap<Integer, CurrencyChangeControlEnum>();
        for (CurrencyChangeControlEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private CurrencyChangeControlEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static CurrencyChangeControlEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
