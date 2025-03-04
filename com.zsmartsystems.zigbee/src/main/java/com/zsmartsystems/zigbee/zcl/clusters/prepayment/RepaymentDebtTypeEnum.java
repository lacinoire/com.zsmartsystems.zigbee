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
 * Repayment Debt Type value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum RepaymentDebtTypeEnum {

    /**
     * Debt 1, 0, 0x0000
     */
    DEBT_1(0x0000),

    /**
     * Debt 2, 1, 0x0001
     */
    DEBT_2(0x0001),

    /**
     * Debt 3, 2, 0x0002
     */
    DEBT_3(0x0002),

    /**
     * All Debts, 255, 0x00FF
     */
    ALL_DEBTS(0x00FF);

    /**
     * A mapping between the integer code and its corresponding RepaymentDebtTypeEnum type to facilitate lookup by value.
     */
    private static Map<Integer, RepaymentDebtTypeEnum> idMap;

    static {
        idMap = new HashMap<Integer, RepaymentDebtTypeEnum>();
        for (RepaymentDebtTypeEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private RepaymentDebtTypeEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static RepaymentDebtTypeEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
