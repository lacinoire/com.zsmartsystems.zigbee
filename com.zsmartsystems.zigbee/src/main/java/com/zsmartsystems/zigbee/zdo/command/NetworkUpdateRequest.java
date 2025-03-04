/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zdo.command;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoRequest;

/**
 * Network Update Request value object class.
 * <p>
 * <p>
 * This command is provided to allow updating of network configuration parameters or to
 * request information from devices on network conditions in the local operating
 * environment. The destination addressing on this primitive shall be unicast or broadcast to
 * all devices for which macRxOnWhenIdle = TRUE.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class NetworkUpdateRequest extends ZdoRequest {
    /**
     * The ZDO cluster ID.
     */
    public static int CLUSTER_ID = 0x0038;

    /**
     * Scan Channels command message field.
     */
    private Integer scanChannels;

    /**
     * Scan Duration command message field.
     */
    private Integer scanDuration;

    /**
     * Scan Count command message field.
     */
    private Integer scanCount;

    /**
     * NWK Update ID command message field.
     */
    private Integer nwkUpdateId;

    /**
     * NWK Manager Addr command message field.
     */
    private Integer nwkManagerAddr;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public NetworkUpdateRequest() {
        clusterId = CLUSTER_ID;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param scanChannels {@link Integer} Scan Channels
     * @param scanDuration {@link Integer} Scan Duration
     * @param scanCount {@link Integer} Scan Count
     * @param nwkUpdateId {@link Integer} NWK Update ID
     * @param nwkManagerAddr {@link Integer} NWK Manager Addr
     */
    public NetworkUpdateRequest(
            Integer scanChannels,
            Integer scanDuration,
            Integer scanCount,
            Integer nwkUpdateId,
            Integer nwkManagerAddr) {

        clusterId = CLUSTER_ID;

        this.scanChannels = scanChannels;
        this.scanDuration = scanDuration;
        this.scanCount = scanCount;
        this.nwkUpdateId = nwkUpdateId;
        this.nwkManagerAddr = nwkManagerAddr;
    }

    /**
     * Gets Scan Channels.
     *
     * @return the Scan Channels
     */
    public Integer getScanChannels() {
        return scanChannels;
    }

    /**
     * Sets Scan Channels.
     *
     * @param scanChannels the Scan Channels
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setScanChannels(final Integer scanChannels) {
        this.scanChannels = scanChannels;
    }

    /**
     * Gets Scan Duration.
     *
     * @return the Scan Duration
     */
    public Integer getScanDuration() {
        return scanDuration;
    }

    /**
     * Sets Scan Duration.
     *
     * @param scanDuration the Scan Duration
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setScanDuration(final Integer scanDuration) {
        this.scanDuration = scanDuration;
    }

    /**
     * Gets Scan Count.
     *
     * @return the Scan Count
     */
    public Integer getScanCount() {
        return scanCount;
    }

    /**
     * Sets Scan Count.
     *
     * @param scanCount the Scan Count
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setScanCount(final Integer scanCount) {
        this.scanCount = scanCount;
    }

    /**
     * Gets NWK Update ID.
     *
     * @return the NWK Update ID
     */
    public Integer getNwkUpdateId() {
        return nwkUpdateId;
    }

    /**
     * Sets NWK Update ID.
     *
     * @param nwkUpdateId the NWK Update ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNwkUpdateId(final Integer nwkUpdateId) {
        this.nwkUpdateId = nwkUpdateId;
    }

    /**
     * Gets NWK Manager Addr.
     *
     * @return the NWK Manager Addr
     */
    public Integer getNwkManagerAddr() {
        return nwkManagerAddr;
    }

    /**
     * Sets NWK Manager Addr.
     *
     * @param nwkManagerAddr the NWK Manager Addr
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNwkManagerAddr(final Integer nwkManagerAddr) {
        this.nwkManagerAddr = nwkManagerAddr;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(scanChannels, ZclDataType.BITMAP_32_BIT);
        serializer.serialize(scanDuration, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(scanCount, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(nwkUpdateId, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(nwkManagerAddr, ZclDataType.NWK_ADDRESS);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        scanChannels = (Integer) deserializer.deserialize(ZclDataType.BITMAP_32_BIT);
        scanDuration = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        scanCount = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        nwkUpdateId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        nwkManagerAddr = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(181);
        builder.append("NetworkUpdateRequest [");
        builder.append(super.toString());
        builder.append(", scanChannels=");
        builder.append(String.format("%08X", scanChannels));
        builder.append(", scanDuration=");
        builder.append(scanDuration);
        builder.append(", scanCount=");
        builder.append(scanCount);
        builder.append(", nwkUpdateId=");
        builder.append(nwkUpdateId);
        builder.append(", nwkManagerAddr=");
        builder.append(nwkManagerAddr);
        builder.append(']');
        return builder.toString();
    }

}
