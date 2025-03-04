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
 * Debt Recovery Method value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum DebtRecoveryMethodEnum {

    /**
     * Time Based, 0, 0x0000
     */
    TIME_BASED(0x0000),

    /**
     * Percentage Based, 1, 0x0001
     */
    PERCENTAGE_BASED(0x0001),

    /**
     * Catch Up Based, 2, 0x0002
     */
    CATCH_UP_BASED(0x0002);

    /**
     * A mapping between the integer code and its corresponding DebtRecoveryMethodEnum type to facilitate lookup by value.
     */
    private static Map<Integer, DebtRecoveryMethodEnum> idMap;

    static {
        idMap = new HashMap<Integer, DebtRecoveryMethodEnum>();
        for (DebtRecoveryMethodEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private DebtRecoveryMethodEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static DebtRecoveryMethodEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
