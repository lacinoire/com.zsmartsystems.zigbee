/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement the Ember Enumeration <b>EmberKeyStatus</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public enum EmberKeyStatus {
    /**
     * Default unknown value
     */
    UNKNOWN(-1),

    /**
     */
    EMBER_KEY_STATUS_NONE(0x0000),

    /**
     */
    EMBER_APP_LINK_KEY_ESTABLISHED(0x0001),

    /**
     */
    EMBER_APP_MASTER_KEY_ESTABLISHED(0x0002),

    /**
     */
    EMBER_TRUST_CENTER_LINK_KEY_ESTABLISHED(0x0003),

    /**
     */
    EMBER_KEY_ESTABLISHMENT_TIMEOUT(0x0004),

    /**
     */
    EMBER_KEY_TABLE_FULL(0x0005),

    /**
     */
    EMBER_TC_RESPONDED_TO_KEY_REQUEST(0x0006),

    /**
     */
    EMBER_TC_APP_KEY_SENT_TO_REQUESTER(0x0007),

    /**
     */
    EMBER_TC_RESPONSE_TO_KEY_REQUEST_FAILED(0x0008),

    /**
     */
    EMBER_TC_REQUEST_KEY_TYPE_NOT_SUPPORTED(0x0009),

    /**
     */
    EMBER_TC_NO_LINK_KEY_FOR_REQUESTER(0x000A),

    /**
     */
    EMBER_TC_REQUESTER_EUI64_UNKNOWN(0x000B),

    /**
     */
    EMBER_TC_RECEIVED_FIRST_APP_KEY_REQUEST(0x000C),

    /**
     */
    EMBER_TC_TIMEOUT_WAITING_FOR_SECOND_APP_KEY_REQUEST(0x000D),

    /**
     */
    EMBER_TC_NON_MATCHING_APP_KEY_REQUEST_RECEIVED(0x000E),

    /**
     */
    EMBER_TC_FAILED_TO_SEND_APP_KEYS(0x000F),

    /**
     */
    EMBER_TC_FAILED_TO_STORE_APP_KEY_REQUEST(0x0010),

    /**
     */
    EMBER_TC_REJECTED_APP_KEY_REQUEST(0x0011),

    /**
     */
    EMBER_TC_FAILED_TO_GENERATE_NEW_KEY(0x0012),

    /**
     */
    EMBER_TC_FAILED_TO_SEND_TC_KEY(0x0013),

    /**
     */
    EMBER_TRUST_CENTER_IS_PRE_R21(0x001E),

    /**
     */
    EMBER_TC_REQUESTER_VERIFY_KEY_TIMEOUT(0x0032),

    /**
     */
    EMBER_TC_REQUESTER_VERIFY_KEY_FAILURE(0x0033),

    /**
     */
    EMBER_TC_REQUESTER_VERIFY_KEY_SUCCESS(0x0034),

    /**
     */
    EMBER_VERIFY_LINK_KEY_FAILURE(0x0064),

    /**
     */
    EMBER_VERIFY_LINK_KEY_SUCCESS(0x0065);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, EmberKeyStatus> codeMapping;

    private int key;

    static {
        codeMapping = new HashMap<Integer, EmberKeyStatus>();
        for (EmberKeyStatus s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    private EmberKeyStatus(int key) {
        this.key = key;
    }

    /**
     * Lookup function based on the EmberStatus type code. Returns null if the
     * code does not exist.
     *
     * @param code the code to lookup
     * @return enumeration value of the alarm type.
     */
    public static EmberKeyStatus getEmberKeyStatus(int code) {
        if (codeMapping.get(code) == null) {
            return UNKNOWN;
        }

        return codeMapping.get(code);
    }

    /**
     * Returns the EZSP protocol defined value for this enumeration.
     *
     * @return the EZSP protocol key
     */
    public int getKey() {
        return key;
    }
}
