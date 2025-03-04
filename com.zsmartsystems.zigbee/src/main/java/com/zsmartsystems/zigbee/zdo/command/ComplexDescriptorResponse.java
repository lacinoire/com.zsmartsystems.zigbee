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
import com.zsmartsystems.zigbee.zdo.ZdoResponse;
import com.zsmartsystems.zigbee.zdo.ZdoStatus;
import com.zsmartsystems.zigbee.zdo.field.ComplexDescriptor;

/**
 * Complex Descriptor Response value object class.
 * <p>
 * <p>
 * The Complex_Desc_rsp is generated by a remote device in response to a Complex_Desc_req
 * directed to the remote device. This command shall be unicast to the originator of the
 * Complex_Desc_req command.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ComplexDescriptorResponse extends ZdoResponse {
    /**
     * The ZDO cluster ID.
     */
    public static int CLUSTER_ID = 0x8010;

    /**
     * NWK Addr Of Interest command message field.
     */
    private Integer nwkAddrOfInterest;

    /**
     * Length command message field.
     */
    private Integer length;

    /**
     * Complex Descriptor command message field.
     */
    private ComplexDescriptor complexDescriptor;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ComplexDescriptorResponse() {
        clusterId = CLUSTER_ID;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param status {@link ZdoStatus} Status
     * @param nwkAddrOfInterest {@link Integer} NWK Addr Of Interest
     * @param length {@link Integer} Length
     * @param complexDescriptor {@link ComplexDescriptor} Complex Descriptor
     */
    public ComplexDescriptorResponse(
            ZdoStatus status,
            Integer nwkAddrOfInterest,
            Integer length,
            ComplexDescriptor complexDescriptor) {

        clusterId = CLUSTER_ID;

        this.status = status;
        this.nwkAddrOfInterest = nwkAddrOfInterest;
        this.length = length;
        this.complexDescriptor = complexDescriptor;
    }

    /**
     * Gets NWK Addr Of Interest.
     *
     * @return the NWK Addr Of Interest
     */
    public Integer getNwkAddrOfInterest() {
        return nwkAddrOfInterest;
    }

    /**
     * Sets NWK Addr Of Interest.
     *
     * @param nwkAddrOfInterest the NWK Addr Of Interest
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNwkAddrOfInterest(final Integer nwkAddrOfInterest) {
        this.nwkAddrOfInterest = nwkAddrOfInterest;
    }

    /**
     * Gets Length.
     *
     * @return the Length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * Sets Length.
     *
     * @param length the Length
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setLength(final Integer length) {
        this.length = length;
    }

    /**
     * Gets Complex Descriptor.
     *
     * @return the Complex Descriptor
     */
    public ComplexDescriptor getComplexDescriptor() {
        return complexDescriptor;
    }

    /**
     * Sets Complex Descriptor.
     *
     * @param complexDescriptor the Complex Descriptor
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setComplexDescriptor(final ComplexDescriptor complexDescriptor) {
        this.complexDescriptor = complexDescriptor;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
        serializer.serialize(nwkAddrOfInterest, ZclDataType.NWK_ADDRESS);
        serializer.serialize(length, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(complexDescriptor, ZclDataType.COMPLEX_DESCRIPTOR);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
        nwkAddrOfInterest = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
        length = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        complexDescriptor = (ComplexDescriptor) deserializer.deserialize(ZclDataType.COMPLEX_DESCRIPTOR);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(154);
        builder.append("ComplexDescriptorResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", nwkAddrOfInterest=");
        builder.append(String.format("%04X", nwkAddrOfInterest));
        builder.append(", length=");
        builder.append(length);
        builder.append(", complexDescriptor=");
        builder.append(complexDescriptor);
        builder.append(']');
        return builder.toString();
    }

}
