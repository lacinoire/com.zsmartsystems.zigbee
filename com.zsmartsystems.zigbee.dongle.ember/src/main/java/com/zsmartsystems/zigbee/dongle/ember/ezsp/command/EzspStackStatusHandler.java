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
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>stackStatusHandler</b>.
 * <p>
 *  A callback invoked when the status of the stack changes. If the status parameter equals
 * EMBER_NETWORK_UP, then the getNetworkParameters command can be called to obtain the new
 * network parameters. If any of the parameters are being stored in nonvolatile memory by the
 * Host, the stored values should be updated.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspStackStatusHandler extends EzspFrameResponse {
    public static int FRAME_ID = 0x19;

    /**
     * Stack status. One of the following: EMBER_NETWORK_UP, EMBER_NETWORK_DOWN,
     * EMBER_JOIN_FAILED, EMBER_MOVE_FAILED
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus status;

    /**
     * Response and Handler constructor
     */
    public EzspStackStatusHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberStatus();
    }

    /**
     * Stack status. One of the following: EMBER_NETWORK_UP, EMBER_NETWORK_DOWN,
     * EMBER_JOIN_FAILED, EMBER_MOVE_FAILED
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current status as {@link EmberStatus}
     */
    public EmberStatus getStatus() {
        return status;
    }

    /**
     * Stack status. One of the following: EMBER_NETWORK_UP, EMBER_NETWORK_DOWN,
     * EMBER_JOIN_FAILED, EMBER_MOVE_FAILED
     *
     * @param status the status to set as {@link EmberStatus}
     */
    public void setStatus(EmberStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EzspStackStatusHandler [status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }
}
