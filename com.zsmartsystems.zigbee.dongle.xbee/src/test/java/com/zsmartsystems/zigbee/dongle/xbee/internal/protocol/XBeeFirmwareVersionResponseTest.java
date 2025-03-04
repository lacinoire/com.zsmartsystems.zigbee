/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class XBeeFirmwareVersionResponseTest extends XBeeFrameBaseTest {
    @Test
    public void test() {
        XBeeFirmwareVersionResponse event = new XBeeFirmwareVersionResponse();
        event.deserialize(getPacketData("00 07 88 02 56 52 00 21 A7 05"));
        System.out.println(event);
        assertEquals(0x88, event.getFrameType());
        assertEquals(CommandStatus.OK, event.getCommandStatus());
        assertTrue(Arrays.equals(new int[] { 0x21, 0xA7 }, event.getFirmwareVersion()));
    }

}
