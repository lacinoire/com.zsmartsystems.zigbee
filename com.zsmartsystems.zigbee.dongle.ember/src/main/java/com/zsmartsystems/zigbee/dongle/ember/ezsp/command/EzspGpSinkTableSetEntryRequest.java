/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberGpSinkTableEntry;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>gpSinkTableSetEntry</b>.
 * <p>
 * Retrieves the sink table entry stored at the passed index.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGpSinkTableSetEntryRequest extends EzspFrameRequest {
    public static final int FRAME_ID = 0xDF;

    /**
     * The index of the requested sink table entry.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int sinkIndex;

    /**
     * An EmberGpSinkTableEntry struct containing a copy of the sink entry to be updated.
     * <p>
     * EZSP type is <i>EmberGpSinkTableEntry</i> - Java type is {@link EmberGpSinkTableEntry}
     */
    private EmberGpSinkTableEntry entry;

    /**
     * Serialiser used to serialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspGpSinkTableSetEntryRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * The index of the requested sink table entry.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current sinkIndex as {@link int}
     */
    public int getSinkIndex() {
        return sinkIndex;
    }

    /**
     * The index of the requested sink table entry.
     *
     * @param sinkIndex the sinkIndex to set as {@link int}
     */
    public void setSinkIndex(int sinkIndex) {
        this.sinkIndex = sinkIndex;
    }

    /**
     * An EmberGpSinkTableEntry struct containing a copy of the sink entry to be updated.
     * <p>
     * EZSP type is <i>EmberGpSinkTableEntry</i> - Java type is {@link EmberGpSinkTableEntry}
     *
     * @return the current entry as {@link EmberGpSinkTableEntry}
     */
    public EmberGpSinkTableEntry getEntry() {
        return entry;
    }

    /**
     * An EmberGpSinkTableEntry struct containing a copy of the sink entry to be updated.
     *
     * @param entry the entry to set as {@link EmberGpSinkTableEntry}
     */
    public void setEntry(EmberGpSinkTableEntry entry) {
        this.entry = entry;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeUInt8(sinkIndex);
        serializer.serializeEmberGpSinkTableEntry(entry);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(108);
        builder.append("EzspGpSinkTableSetEntryRequest [networkId=");
        builder.append(networkId);
        builder.append(", sinkIndex=");
        builder.append(sinkIndex);
        builder.append(", entry=");
        builder.append(entry);
        builder.append(']');
        return builder.toString();
    }
}
