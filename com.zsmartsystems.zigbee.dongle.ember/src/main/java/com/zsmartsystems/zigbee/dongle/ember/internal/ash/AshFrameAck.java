/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ash;

/**
 * ASH Frame Error
 *
 * @author Chris Jackson
 *
 */
public class AshFrameAck extends AshFrame {
    /**
     * Constructor to create an ASH ACK frame.
     *
     * @param ackNum the frame number to acknowledge
     */
    public AshFrameAck(int ackNum) {
        this.frameType = FrameType.ACK;
        this.ackNum = ackNum;
    }

    /**
     * Constructor taking an incoming data buffer
     * 
     * @param frameBuffer the incoming data buffer
     */
    public AshFrameAck(int[] frameBuffer) {
        this.frameType = FrameType.ACK;
        processHeader(frameBuffer);
    }

    @Override
    public String toString() {
        return "AshFrameAck [ackNum=" + ackNum + ", notRdy=" + nRdy + "]";
    }
}
