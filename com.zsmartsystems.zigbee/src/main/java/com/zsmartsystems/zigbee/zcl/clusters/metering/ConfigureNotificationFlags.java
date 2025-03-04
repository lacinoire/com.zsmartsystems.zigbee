/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.metering;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.clusters.metering.NotificationCommandSubPayload;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Configure Notification Flags value object class.
 * <p>
 * Cluster: <b>Metering</b>. Command ID 0x0A is sent <b>FROM</b> the server.
 * This command is a <b>specific</b> command used for the Metering cluster.
 * <p>
 * The ConfigureNotificationFlags command is used to set the commands relating to the bit
 * value for each NotificationFlags attribute that the scheme is proposing to use.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ConfigureNotificationFlags extends ZclMeteringCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0702;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x0A;

    /**
     * Issuer Event ID command message field.
     * <p>
     * Unique identifier generated by the device being mirrored. When new information is
     * provided that replaces older information, this field allows devices to determine
     * which information is newer. It is recommended that the value contained in this field is a
     * UTC based time stamp (UTCTime data type) identifying when the command was issued. Thus,
     * newer information will have a value in the Issuer Event ID field that is larger than older
     * information.
     */
    private Integer issuerEventId;

    /**
     * Notification Scheme command message field.
     * <p>
     * An unsigned 8-bit integer that allows for the pre-loading of the Notification Flags bit
     * mapping to ZCL or Smart Energy Standard commands.
     */
    private Integer notificationScheme;

    /**
     * Notification Flag Attribute ID command message field.
     * <p>
     * An unsigned 16-bit integer that denotes the attribute ID of the Notification flag (2-8)
     * that will be configured for this Notification scheme.
     */
    private Integer notificationFlagAttributeId;

    /**
     * Sub Payload command message field.
     */
    private NotificationCommandSubPayload subPayload;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ConfigureNotificationFlags() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param issuerEventId {@link Integer} Issuer Event ID
     * @param notificationScheme {@link Integer} Notification Scheme
     * @param notificationFlagAttributeId {@link Integer} Notification Flag Attribute ID
     * @param subPayload {@link NotificationCommandSubPayload} Sub Payload
     */
    public ConfigureNotificationFlags(
            Integer issuerEventId,
            Integer notificationScheme,
            Integer notificationFlagAttributeId,
            NotificationCommandSubPayload subPayload) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;

        this.issuerEventId = issuerEventId;
        this.notificationScheme = notificationScheme;
        this.notificationFlagAttributeId = notificationFlagAttributeId;
        this.subPayload = subPayload;
    }

    /**
     * Gets Issuer Event ID.
     * <p>
     * Unique identifier generated by the device being mirrored. When new information is
     * provided that replaces older information, this field allows devices to determine
     * which information is newer. It is recommended that the value contained in this field is a
     * UTC based time stamp (UTCTime data type) identifying when the command was issued. Thus,
     * newer information will have a value in the Issuer Event ID field that is larger than older
     * information.
     *
     * @return the Issuer Event ID
     */
    public Integer getIssuerEventId() {
        return issuerEventId;
    }

    /**
     * Sets Issuer Event ID.
     * <p>
     * Unique identifier generated by the device being mirrored. When new information is
     * provided that replaces older information, this field allows devices to determine
     * which information is newer. It is recommended that the value contained in this field is a
     * UTC based time stamp (UTCTime data type) identifying when the command was issued. Thus,
     * newer information will have a value in the Issuer Event ID field that is larger than older
     * information.
     *
     * @param issuerEventId the Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Notification Scheme.
     * <p>
     * An unsigned 8-bit integer that allows for the pre-loading of the Notification Flags bit
     * mapping to ZCL or Smart Energy Standard commands.
     *
     * @return the Notification Scheme
     */
    public Integer getNotificationScheme() {
        return notificationScheme;
    }

    /**
     * Sets Notification Scheme.
     * <p>
     * An unsigned 8-bit integer that allows for the pre-loading of the Notification Flags bit
     * mapping to ZCL or Smart Energy Standard commands.
     *
     * @param notificationScheme the Notification Scheme
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNotificationScheme(final Integer notificationScheme) {
        this.notificationScheme = notificationScheme;
    }

    /**
     * Gets Notification Flag Attribute ID.
     * <p>
     * An unsigned 16-bit integer that denotes the attribute ID of the Notification flag (2-8)
     * that will be configured for this Notification scheme.
     *
     * @return the Notification Flag Attribute ID
     */
    public Integer getNotificationFlagAttributeId() {
        return notificationFlagAttributeId;
    }

    /**
     * Sets Notification Flag Attribute ID.
     * <p>
     * An unsigned 16-bit integer that denotes the attribute ID of the Notification flag (2-8)
     * that will be configured for this Notification scheme.
     *
     * @param notificationFlagAttributeId the Notification Flag Attribute ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNotificationFlagAttributeId(final Integer notificationFlagAttributeId) {
        this.notificationFlagAttributeId = notificationFlagAttributeId;
    }

    /**
     * Gets Sub Payload.
     *
     * @return the Sub Payload
     */
    public NotificationCommandSubPayload getSubPayload() {
        return subPayload;
    }

    /**
     * Sets Sub Payload.
     *
     * @param subPayload the Sub Payload
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setSubPayload(final NotificationCommandSubPayload subPayload) {
        this.subPayload = subPayload;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(notificationScheme, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(notificationFlagAttributeId, ZclDataType.UNSIGNED_16_BIT_INTEGER);
        subPayload.serialize(serializer);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        notificationScheme = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        notificationFlagAttributeId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
        subPayload = new NotificationCommandSubPayload();
        subPayload.deserialize(deserializer);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(177);
        builder.append("ConfigureNotificationFlags [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", notificationScheme=");
        builder.append(notificationScheme);
        builder.append(", notificationFlagAttributeId=");
        builder.append(notificationFlagAttributeId);
        builder.append(", subPayload=");
        builder.append(subPayload);
        builder.append(']');
        return builder.toString();
    }

}
