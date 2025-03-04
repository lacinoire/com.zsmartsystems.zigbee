/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;

/**
 * Class to implement the Ember EZSP command <b>gpProxyTableProcessGpPairing</b>.
 * <p>
 * Update the GP Proxy table based on a GP pairing.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGpProxyTableProcessGpPairingResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0xC9;

    /**
     * Whether a GP Pairing has been created or not.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean gpPairingAdded;

    /**
     * Response and Handler constructor
     */
    public EzspGpProxyTableProcessGpPairingResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        gpPairingAdded = deserializer.deserializeBool();
    }

    /**
     * Whether a GP Pairing has been created or not.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current gpPairingAdded as {@link boolean}
     */
    public boolean getGpPairingAdded() {
        return gpPairingAdded;
    }

    /**
     * Whether a GP Pairing has been created or not.
     *
     * @param gpPairingAdded the gpPairingAdded to set as {@link boolean}
     */
    public void setGpPairingAdded(boolean gpPairingAdded) {
        this.gpPairingAdded = gpPairingAdded;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(93);
        builder.append("EzspGpProxyTableProcessGpPairingResponse [networkId=");
        builder.append(networkId);
        builder.append(", gpPairingAdded=");
        builder.append(gpPairingAdded);
        builder.append(']');
        return builder.toString();
    }
}
