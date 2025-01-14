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
 * Extended Number Of Price Tiers value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum ExtendedNumberOfPriceTiersEnum {

    /**
     * Refer To Number Of Price Tiers Field, 0, 0x0000
     */
    REFER_TO_NUMBER_OF_PRICE_TIERS_FIELD(0x0000),

    /**
     * Number Of Price Tiers 16, 1, 0x0001
     */
    NUMBER_OF_PRICE_TIERS_16(0x0001),

    /**
     * Number Of Price Tiers 17, 2, 0x0002
     */
    NUMBER_OF_PRICE_TIERS_17(0x0002),

    /**
     * Number Of Price Tiers 18, 3, 0x0003
     */
    NUMBER_OF_PRICE_TIERS_18(0x0003),

    /**
     * Number Of Price Tiers 19, 4, 0x0004
     */
    NUMBER_OF_PRICE_TIERS_19(0x0004),

    /**
     * Number Of Price Tiers 20, 5, 0x0005
     */
    NUMBER_OF_PRICE_TIERS_20(0x0005),

    /**
     * Number Of Price Tiers 21, 6, 0x0006
     */
    NUMBER_OF_PRICE_TIERS_21(0x0006),

    /**
     * Number Of Price Tiers 22, 7, 0x0007
     */
    NUMBER_OF_PRICE_TIERS_22(0x0007),

    /**
     * Number Of Price Tiers 23, 8, 0x0008
     */
    NUMBER_OF_PRICE_TIERS_23(0x0008),

    /**
     * Number Of Price Tiers 24, 9, 0x0009
     */
    NUMBER_OF_PRICE_TIERS_24(0x0009),

    /**
     * Number Of Price Tiers 25, 10, 0x000A
     */
    NUMBER_OF_PRICE_TIERS_25(0x000A),

    /**
     * Number Of Price Tiers 26, 11, 0x000B
     */
    NUMBER_OF_PRICE_TIERS_26(0x000B),

    /**
     * Number Of Price Tiers 27, 12, 0x000C
     */
    NUMBER_OF_PRICE_TIERS_27(0x000C),

    /**
     * Number Of Price Tiers 28, 13, 0x000D
     */
    NUMBER_OF_PRICE_TIERS_28(0x000D),

    /**
     * Number Of Price Tiers 29, 14, 0x000E
     */
    NUMBER_OF_PRICE_TIERS_29(0x000E),

    /**
     * Number Of Price Tiers 30, 15, 0x000F
     */
    NUMBER_OF_PRICE_TIERS_30(0x000F),

    /**
     * Number Of Price Tiers 31, 16, 0x0010
     */
    NUMBER_OF_PRICE_TIERS_31(0x0010),

    /**
     * Number Of Price Tiers 32, 17, 0x0011
     */
    NUMBER_OF_PRICE_TIERS_32(0x0011),

    /**
     * Number Of Price Tiers 33, 18, 0x0012
     */
    NUMBER_OF_PRICE_TIERS_33(0x0012),

    /**
     * Number Of Price Tiers 34, 19, 0x0013
     */
    NUMBER_OF_PRICE_TIERS_34(0x0013),

    /**
     * Number Of Price Tiers 35, 20, 0x0014
     */
    NUMBER_OF_PRICE_TIERS_35(0x0014),

    /**
     * Number Of Price Tiers 36, 21, 0x0015
     */
    NUMBER_OF_PRICE_TIERS_36(0x0015),

    /**
     * Number Of Price Tiers 37, 22, 0x0016
     */
    NUMBER_OF_PRICE_TIERS_37(0x0016),

    /**
     * Number Of Price Tiers 38, 23, 0x0017
     */
    NUMBER_OF_PRICE_TIERS_38(0x0017),

    /**
     * Number Of Price Tiers 39, 24, 0x0018
     */
    NUMBER_OF_PRICE_TIERS_39(0x0018),

    /**
     * Number Of Price Tiers 40, 25, 0x0019
     */
    NUMBER_OF_PRICE_TIERS_40(0x0019),

    /**
     * Number Of Price Tiers 41, 26, 0x001A
     */
    NUMBER_OF_PRICE_TIERS_41(0x001A),

    /**
     * Number Of Price Tiers 42, 27, 0x001B
     */
    NUMBER_OF_PRICE_TIERS_42(0x001B),

    /**
     * Number Of Price Tiers 43, 28, 0x001C
     */
    NUMBER_OF_PRICE_TIERS_43(0x001C),

    /**
     * Number Of Price Tiers 44, 29, 0x001D
     */
    NUMBER_OF_PRICE_TIERS_44(0x001D),

    /**
     * Number Of Price Tiers 45, 30, 0x001E
     */
    NUMBER_OF_PRICE_TIERS_45(0x001E),

    /**
     * Number Of Price Tiers 46, 31, 0x001F
     */
    NUMBER_OF_PRICE_TIERS_46(0x001F),

    /**
     * Number Of Price Tiers 47, 32, 0x0020
     */
    NUMBER_OF_PRICE_TIERS_47(0x0020),

    /**
     * Number Of Price Tiers 48, 33, 0x0021
     */
    NUMBER_OF_PRICE_TIERS_48(0x0021);

    /**
     * A mapping between the integer code and its corresponding ExtendedNumberOfPriceTiersEnum type to facilitate lookup by value.
     */
    private static Map<Integer, ExtendedNumberOfPriceTiersEnum> idMap;

    static {
        idMap = new HashMap<Integer, ExtendedNumberOfPriceTiersEnum>();
        for (ExtendedNumberOfPriceTiersEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private ExtendedNumberOfPriceTiersEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static ExtendedNumberOfPriceTiersEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
