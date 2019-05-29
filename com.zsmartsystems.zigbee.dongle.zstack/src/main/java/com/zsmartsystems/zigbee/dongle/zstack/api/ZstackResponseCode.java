/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.zstack.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement the Z-Stack Enumeration <b>ZstackResponseCode</b>.
 * <p>
 * Global response codes
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson
 */
public enum ZstackResponseCode {
    /**
     * Default unknown value
     */
    UNKNOWN(-1),

    /**
     *
     */
    SUCCESS(0x0000),

    /**
     *
     */
    FAILURE(0x0001),

    /**
     *
     */
    AF_INVALID_PARAMETER(0x0002),

    /**
     * Security manager key table full
     */
    AF_MEM_FAIL(0x0010),

    /**
     * Security manager key table full
     */
    KEY_TABLE_FULL(0x0011),

    /**
     * The operation could not be completed because no memory resources were available
     */
    MAC_NO_RESOURCES(0x001A),

    /**
     * Invalid Request
     */
    INVALID_REQUEST(0x00C2),

    /**
     * Not Permitted
     */
    NOT_PERMITTED(0x00C3),

    /**
     * Unknown Device
     */
    UNKNOWN_DEVICE(0x00C8),

    /**
     *
     */
    AF_NO_ROUTE(0x00CD),

    /**
     * The scan request failed because a scan is already in progress
     */
    MAC_SCAN_IN_PROGRESS(0x00FC);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, ZstackResponseCode> codeMapping;

    private int key;

    static {
        codeMapping = new HashMap<Integer, ZstackResponseCode>();
        for (ZstackResponseCode s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    private ZstackResponseCode(int key) {
        this.key = key;
    }

    /**
     * Lookup function based on the type code. Returns null if the code does not exist.
     *
     * @param code the code to lookup
     * @return enumeration value of the alarm type.
     */
    public static ZstackResponseCode valueOf(int code) {
        if (codeMapping.get(code) == null) {
            return UNKNOWN;
        }

        return codeMapping.get(code);
    }

    /**
     * Returns the Z-Stack protocol defined value for this enumeration.
     *
     * @return the Z-Stack protocol key
     */
    public int getKey() {
        return key;
    }
}