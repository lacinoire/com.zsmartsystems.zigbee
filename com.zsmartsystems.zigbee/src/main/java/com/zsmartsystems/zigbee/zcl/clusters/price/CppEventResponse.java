/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.price;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Cpp Event Response value object class.
 * <p>
 * Cluster: <b>Price</b>. Command ID 0x0D is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Price cluster.
 * <p>
 * The CPPEventResponse command is sent from a CLIENT (IHD) to the ESI to notify it of a Critical
 * Peak Pricing event authorization.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class CppEventResponse extends ZclPriceCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0700;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x0D;

    /**
     * Issuer Event ID command message field.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the Publish command was issued. Thus, newer information will have a
     * value in the Issuer Event ID field that is larger than older information.
     */
    private Integer issuerEventId;

    /**
     * Cpp Auth command message field.
     * <p>
     * An 8-bit enumeration identifying the status of the CPP event. This field shall contain
     * the ‘Accepted’ or ‘Rejected’ values.
     */
    private Integer cppAuth;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public CppEventResponse() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param issuerEventId {@link Integer} Issuer Event ID
     * @param cppAuth {@link Integer} Cpp Auth
     */
    public CppEventResponse(
            Integer issuerEventId,
            Integer cppAuth) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.issuerEventId = issuerEventId;
        this.cppAuth = cppAuth;
    }

    /**
     * Gets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the Publish command was issued. Thus, newer information will have a
     * value in the Issuer Event ID field that is larger than older information.
     *
     * @return the Issuer Event ID
     */
    public Integer getIssuerEventId() {
        return issuerEventId;
    }

    /**
     * Sets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the Publish command was issued. Thus, newer information will have a
     * value in the Issuer Event ID field that is larger than older information.
     *
     * @param issuerEventId the Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Cpp Auth.
     * <p>
     * An 8-bit enumeration identifying the status of the CPP event. This field shall contain
     * the ‘Accepted’ or ‘Rejected’ values.
     *
     * @return the Cpp Auth
     */
    public Integer getCppAuth() {
        return cppAuth;
    }

    /**
     * Sets Cpp Auth.
     * <p>
     * An 8-bit enumeration identifying the status of the CPP event. This field shall contain
     * the ‘Accepted’ or ‘Rejected’ values.
     *
     * @param cppAuth the Cpp Auth
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setCppAuth(final Integer cppAuth) {
        this.cppAuth = cppAuth;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(cppAuth, ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        cppAuth = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(79);
        builder.append("CppEventResponse [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", cppAuth=");
        builder.append(cppAuth);
        builder.append(']');
        return builder.toString();
    }

}
