/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.iasace;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * IAS ACE Arm Mode value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum IasAceArmModeEnum {

    /**
     * Disarm, 0, 0x0000
     */
    DISARM(0x0000),

    /**
     * Arm Day Home Zones Only, 1, 0x0001
     */
    ARM_DAY_HOME_ZONES_ONLY(0x0001),

    /**
     * Arm Night Sleep Zones Only, 2, 0x0002
     */
    ARM_NIGHT_SLEEP_ZONES_ONLY(0x0002),

    /**
     * Arm All Zones, 3, 0x0003
     */
    ARM_ALL_ZONES(0x0003);

    /**
     * A mapping between the integer code and its corresponding IasAceArmModeEnum type to facilitate lookup by value.
     */
    private static Map<Integer, IasAceArmModeEnum> idMap;

    static {
        idMap = new HashMap<Integer, IasAceArmModeEnum>();
        for (IasAceArmModeEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private IasAceArmModeEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static IasAceArmModeEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
