/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.zsmartsystems.zigbee.ExtendedPanId;

/**
 *
 * @author Chris Jackson
 *
 */
public class TelegesisGetEpanIdCommandTest extends TelegesisFrameBaseTest {

    @Test
    public void testOk() {
        TelegesisGetEpanIdCommand command = new TelegesisGetEpanIdCommand();
        System.out.println(command);
        assertEquals("ATS03?\r\n", intArrayToString(command.serialize()));

        assertFalse(command.deserialize(stringToIntArray("1234567890ABCDEF\r")));
        System.out.println(command);
        assertTrue(command.deserialize(stringToIntArray("OK\r")));
        System.out.println(command);

        assertEquals(new ExtendedPanId("1234567890ABCDEF"), command.getEpanId());
        assertEquals(TelegesisStatusCode.SUCCESS, command.getStatus());
    }
}
