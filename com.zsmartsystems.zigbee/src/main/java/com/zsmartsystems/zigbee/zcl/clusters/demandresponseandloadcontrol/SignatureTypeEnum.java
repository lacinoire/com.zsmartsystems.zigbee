/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.demandresponseandloadcontrol;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Signature Type value enumeration.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2021-01-15T11:25:03Z")
public enum SignatureTypeEnum {

    /**
     * ECDSA, 1, 0x0001
     */
    ECDSA(0x0001);

    /**
     * A mapping between the integer code and its corresponding SignatureTypeEnum type to facilitate lookup by value.
     */
    private static Map<Integer, SignatureTypeEnum> idMap;

    static {
        idMap = new HashMap<Integer, SignatureTypeEnum>();
        for (SignatureTypeEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    private SignatureTypeEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static SignatureTypeEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
