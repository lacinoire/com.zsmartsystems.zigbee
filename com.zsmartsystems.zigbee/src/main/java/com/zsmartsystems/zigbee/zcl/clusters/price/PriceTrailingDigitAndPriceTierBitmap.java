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
 * Price Trailing Digit And Price Tier value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum PriceTrailingDigitAndPriceTierBitmap {

    /**
     * Price Tier, 15, 0x000F
     */
    PRICE_TIER(0x000F),

    /**
     * Trailing Digit, 240, 0x00F0
     */
    TRAILING_DIGIT(0x00F0);

    /**
     * A mapping between the integer code and its corresponding PriceTrailingDigitAndPriceTierBitmap type to facilitate lookup by value.
     */
    private static Map<Integer, PriceTrailingDigitAndPriceTierBitmap> idMap;

    static {
        idMap = new HashMap<Integer, PriceTrailingDigitAndPriceTierBitmap>();
        for (PriceTrailingDigitAndPriceTierBitmap enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private PriceTrailingDigitAndPriceTierBitmap(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static PriceTrailingDigitAndPriceTierBitmap getByValue(final int value) {
        return idMap.get(value);
    }
}
