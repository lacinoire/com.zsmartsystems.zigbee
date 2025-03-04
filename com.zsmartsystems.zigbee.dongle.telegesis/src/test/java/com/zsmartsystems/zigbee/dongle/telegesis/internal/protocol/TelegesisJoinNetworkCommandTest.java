/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class TelegesisJoinNetworkCommandTest extends TelegesisFrameBaseTest {
    @Test
    public void test() {
        TelegesisJoinNetworkCommand command = new TelegesisJoinNetworkCommand();
        System.out.println(command);
        assertEquals("AT+JN\r\n", intArrayToString(command.serialize()));

        assertTrue(command.deserialize(stringToIntArray("OK\n")));
        System.out.println(command);
        assertEquals(TelegesisStatusCode.SUCCESS, command.getStatus());
    }

}
