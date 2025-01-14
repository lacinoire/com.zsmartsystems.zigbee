/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.serialization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.zsmartsystems.zigbee.ExtendedPanId;
import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.zcl.field.ByteArray;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 *
 * @author Chris Jackson
 *
 */
public class DefaultDeserializerTest {
    @Test
    public void testDeserialize_DATA_8_BIT() {
        int[] valIn = { 0x9 };
        int valOut = 0x9;
        testDeserialize(valIn, valOut, ZclDataType.DATA_8_BIT);
    }

    @Test
    public void testDeserialize_RAW_OCTET() {
        int[] valIn = { 0x00, 0x11, 0x22, 0x44, 0x88, 0xCC, 0xFF };
        ByteArray valOut = new ByteArray(new int[] { 0x00, 0x11, 0x22, 0x44, 0x88, 0xCC, 0xFF });
        testDeserialize(valIn, valOut, ZclDataType.RAW_OCTET);
    }

    @Test
    public void testDeserialize_SIGNED_16_BIT_INTEGER_positive() {
        int[] valIn = { 0x97, 0x03 };
        int valOut = 0x397;
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_16_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_16_BIT_INTEGER_negative() {
        int[] valIn = { 0xFF, 0xFF };
        int valOut = -0x1;
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_16_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_24_BIT_INTEGER_positive_small() {
        int[] valIn = { 0x97, 0x03, 0x00 };
        int valOut = 0x397;
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_24_BIT_INTEGER_positive_largest() {
        int[] valIn = { 0xFF, 0xFF, 0x7F };
        int valOut = 8388607; // 2^23 - 1
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_24_BIT_INTEGER_negative_one() {
        int[] valIn = { 0xFF, 0xFF, 0xFF };
        int valOut = -0x1;
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_24_BIT_INTEGER_negative_small() {
        int[] valIn = { 0xFD, 0xFF, 0xFF };
        int valOut = -0x3;
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_SIGNED_24_BIT_INTEGER_negative_largest() {
        int[] valIn = { 0x00, 0x00, 0x80 };
        int valOut = -8388608; // -2^23
        testDeserialize(valIn, valOut, ZclDataType.SIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_UNSIGNED_16_BIT_INTEGER_small() {
        int[] valIn = { 0x03, 0x00 };
        int valOut = 0x03;
        testDeserialize(valIn, valOut, ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_UNSIGNED_16_BIT_INTEGER_large() {
        int[] valIn = { 0xFF, 0xFF };
        int valOut = 65535;
        testDeserialize(valIn, valOut, ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_UNSIGNED_24_BIT_INTEGER_small() {
        int[] valIn = { 0x03, 0x00, 0x00 };
        int valOut = 0x03;
        testDeserialize(valIn, valOut, ZclDataType.UNSIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_UNSIGNED_24_BIT_INTEGER_large() {
        int[] valIn = { 0xFF, 0xFF, 0xFF };
        int valOut = 16777215;
        testDeserialize(valIn, valOut, ZclDataType.UNSIGNED_24_BIT_INTEGER);
    }

    @Test
    public void testDeserialize_IEEE_ADDRESS() {
        int[] valIn = { 0x56, 0x34, 0x12, 0x90, 0x78, 0x56, 0x34, 0x12 };
        IeeeAddress valOut = new IeeeAddress("1234567890123456");
        testDeserialize(valIn, valOut, ZclDataType.IEEE_ADDRESS);
    }

    @Test
    public void testDeserialize_EXTENDED_PANID() {
        int[] valIn = { 0x56, 0x34, 0x12, 0x90, 0x78, 0x56, 0x34, 0x12 };
        ExtendedPanId valOut = new ExtendedPanId("1234567890123456");
        testDeserialize(valIn, valOut, ZclDataType.EXTENDED_PANID);
    }

    @Test
    public void testDeserialize_ZIGBEE_DATA_TYPE() {
        int[] valIn = { 33 };
        ZclDataType valOut = ZclDataType.getType(valIn[0]);
        testDeserialize(valIn, valOut, ZclDataType.ZIGBEE_DATA_TYPE);
    }

    @Test
    public void testDeserialize_CHARACTER_STRING() {
        testDeserialize(new int[] { 0xFF }, null, ZclDataType.CHARACTER_STRING);
        testDeserialize(new int[] { 0x00 }, "", ZclDataType.CHARACTER_STRING);
        testDeserialize(new int[] { 0x01, 0x49 }, "I", ZclDataType.CHARACTER_STRING);
        testDeserialize(
                new int[] { 0x0D, 0x49, 0x6E, 0x74, 0x65, 0x72, 0x6E, 0x61, 0x74, 0x69, 0x6F, 0x6E, 0x61, 0x6C },
                "International", ZclDataType.CHARACTER_STRING);
        testDeserialize(
                new int[] { 0x0E, 0x49, 0x6E, 0x74, 0x65, 0x72, 0x6E, 0x61, 0x74, 0x69, 0x6F, 0x6E, 0x61, 0x6C, 0x00 },
                "International", ZclDataType.CHARACTER_STRING);
        testDeserialize(new int[] { 0x1F, 0x4D, 0x61, 0x65, 0x73, 0x74, 0x72, 0x6F, 0x53, 0x74, 0x61, 0x74, 0x00, 0x00,
                0x00, 0xBB, 0xEF, 0x00, 0x00, 0x00, 0x00, 0xA7, 0x43, 0x00, 0xA4, 0x29, 0x02, 0x01, 0x3A, 0x02, 0x00,
                0x00 }, "MaestroStat", ZclDataType.CHARACTER_STRING);
    }

    private void testDeserialize(int[] input, Object objectIn, ZclDataType type) {
        DefaultDeserializer deserializer = new DefaultDeserializer(input);
        Object objectOut = deserializer.readZigBeeType(type);
        assertEquals(objectIn, objectOut);
    }
}
