package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameTest;

/**
 *
 * @author Chris Jackson
 *
 */
public class EzspAddEndpointRequestTest extends EzspFrameTest {
    @Test
    public void testVersion() {
        int[] clusters = new int[] { 0, 1, 6 };
        EzspAddEndpointRequest request = new EzspAddEndpointRequest();
        request.setAppFlags(0);
        request.setDeviceId(0);
        request.setEndpoint(1);
        request.setInputClusterList(clusters);
        request.setOutputClusterList(clusters);
        request.setProfileId(0x104);
        request.setSequenceNumber(2);

        assertTrue(Arrays.equals(getPacketData("02 00 02 01 04 01 00 00 00 03 03 00 00 01 00 06 00 00 00 01 00 06 00"),
                request.serialize()));
    }
}
