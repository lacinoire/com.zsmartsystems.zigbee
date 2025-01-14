/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.colorcontrol;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Color Capabilities value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum ColorCapabilitiesEnum {

    /**
     * Hue And Saturation, 1, 0x0001
     */
    HUE_AND_SATURATION(0x0001),

    /**
     * Enhanced Hue, 2, 0x0002
     */
    ENHANCED_HUE(0x0002),

    /**
     * Color Loop, 4, 0x0004
     */
    COLOR_LOOP(0x0004),

    /**
     * XY Attribute, 8, 0x0008
     */
    XY_ATTRIBUTE(0x0008),

    /**
     * Color Temperature, 16, 0x0010
     */
    COLOR_TEMPERATURE(0x0010);

    /**
     * A mapping between the integer code and its corresponding ColorCapabilitiesEnum type to facilitate lookup by value.
     */
    private static Map<Integer, ColorCapabilitiesEnum> idMap;

    static {
        idMap = new HashMap<Integer, ColorCapabilitiesEnum>();
        for (ColorCapabilitiesEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private ColorCapabilitiesEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static ColorCapabilitiesEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
