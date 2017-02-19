/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberBindingTableEntry;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>getBinding</b>.
 * <p>
 * Gets an entry in the binding table.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGetBindingResponse extends EzspFrameResponse {
    public static int FRAME_ID = 0x2C;

    /**
     * An EmberStatus value indicating the success or failure of the command.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus status;

    /**
     * The contents of the binding entry.
     * <p>
     * EZSP type is <i>EmberBindingTableEntry</i> - Java type is {@link EmberBindingTableEntry}
     */
    private EmberBindingTableEntry value;

    /**
     * Response and Handler constructor
     */
    public EzspGetBindingResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberStatus();
        value = deserializer.deserializeEmberBindingTableEntry();
    }

    /**
     * An EmberStatus value indicating the success or failure of the command.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current status as {@link EmberStatus}
     */
    public EmberStatus getStatus() {
        return status;
    }

    /**
     * An EmberStatus value indicating the success or failure of the command.
     *
     * @param status the status to set as {@link EmberStatus}
     */
    public void setStatus(EmberStatus status) {
        this.status = status;
    }

    /**
     * The contents of the binding entry.
     * <p>
     * EZSP type is <i>EmberBindingTableEntry</i> - Java type is {@link EmberBindingTableEntry}
     *
     * @return the current value as {@link EmberBindingTableEntry}
     */
    public EmberBindingTableEntry getValue() {
        return value;
    }

    /**
     * The contents of the binding entry.
     *
     * @param value the value to set as {@link EmberBindingTableEntry}
     */
    public void setValue(EmberBindingTableEntry value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EzspGetBindingResponse [status=");
        builder.append(status);
        builder.append(", value=");
        builder.append(value);
        builder.append("]");
        return builder.toString();
    }
}
