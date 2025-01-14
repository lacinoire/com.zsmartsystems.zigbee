/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberKeyStruct;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>getKeyTableEntry</b>.
 * <p>
 * Retrieves the key table entry at the specified index.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGetKeyTableEntryResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0x71;

    /**
     * EMBER_TABLE_ENTRY_ERASED if the index is an erased key entry. EMBER_INDEX_OUT_OF_RANGE
     * if the passed index is not valid. EMBER_SUCCESS on success.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus status;

    /**
     * The results retrieved by the stack.
     * <p>
     * EZSP type is <i>EmberKeyStruct</i> - Java type is {@link EmberKeyStruct}
     */
    private EmberKeyStruct keyStruct;

    /**
     * Response and Handler constructor
     */
    public EzspGetKeyTableEntryResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberStatus();
        keyStruct = deserializer.deserializeEmberKeyStruct();
    }

    /**
     * EMBER_TABLE_ENTRY_ERASED if the index is an erased key entry. EMBER_INDEX_OUT_OF_RANGE
     * if the passed index is not valid. EMBER_SUCCESS on success.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current status as {@link EmberStatus}
     */
    public EmberStatus getStatus() {
        return status;
    }

    /**
     * EMBER_TABLE_ENTRY_ERASED if the index is an erased key entry. EMBER_INDEX_OUT_OF_RANGE
     * if the passed index is not valid. EMBER_SUCCESS on success.
     *
     * @param status the status to set as {@link EmberStatus}
     */
    public void setStatus(EmberStatus status) {
        this.status = status;
    }

    /**
     * The results retrieved by the stack.
     * <p>
     * EZSP type is <i>EmberKeyStruct</i> - Java type is {@link EmberKeyStruct}
     *
     * @return the current keyStruct as {@link EmberKeyStruct}
     */
    public EmberKeyStruct getKeyStruct() {
        return keyStruct;
    }

    /**
     * The results retrieved by the stack.
     *
     * @param keyStruct the keyStruct to set as {@link EmberKeyStruct}
     */
    public void setKeyStruct(EmberKeyStruct keyStruct) {
        this.keyStruct = keyStruct;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(106);
        builder.append("EzspGetKeyTableEntryResponse [networkId=");
        builder.append(networkId);
        builder.append(", status=");
        builder.append(status);
        builder.append(", keyStruct=");
        builder.append(keyStruct);
        builder.append(']');
        return builder.toString();
    }
}
