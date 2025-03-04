/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.cc2531.frame;

import java.util.Arrays;

import com.zsmartsystems.zigbee.aps.ZigBeeApsFrame;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolPacket;

/**
 *
 * @author Chris Jackson
 *
 */
public class ZdoCallbackIncoming extends TiDongleReceivePacket {

    public static ZigBeeApsFrame create(ZToolPacket packet) {
        ZigBeeApsFrame apsFrame = new ZigBeeApsFrame();
        apsFrame.setCluster(packet.getPacket()[7] + (packet.getPacket()[8] << 8));
        apsFrame.setDestinationAddress(packet.getPacket()[11] + (packet.getPacket()[12] << 8));
        apsFrame.setDestinationEndpoint(0);
        apsFrame.setSourceAddress(packet.getPacket()[4] + (packet.getPacket()[5] << 8));
        apsFrame.setSourceEndpoint(0);
        apsFrame.setProfile(0);
        apsFrame.setPayload(Arrays.copyOfRange(packet.getPacket(), 12, packet.getPacket().length - 1));

        return apsFrame;
    }
}
