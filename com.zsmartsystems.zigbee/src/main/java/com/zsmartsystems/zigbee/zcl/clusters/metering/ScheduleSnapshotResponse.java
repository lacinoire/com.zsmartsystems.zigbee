/**
 * Copyright (c) 2016-2020 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.metering;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.clusters.metering.SnapshotResponsePayload;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Schedule Snapshot Response value object class.
 * <p>
 * Cluster: <b>Metering</b>. Command ID 0x04 is sent <b>FROM</b> the server.
 * This command is a <b>specific</b> command used for the Metering cluster.
 * <p>
 * This command is generated in response to a ScheduleSnapshot command, and is sent to confirm
 * whether the requested snapshot schedule has been set up.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ScheduleSnapshotResponse extends ZclMeteringCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0702;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x04;

    /**
     * Issuer Event ID command message field.
     * <p>
     * Unique identifier generated by the commodity provider. The value contained in this
     * field indicates the value allocated to the ScheduleSnapshot command for which this
     * response is generated.
     */
    private Integer issuerEventId;

    /**
     * Snapshot Response Payload command message field.
     * <p>
     * The ScheduleSnapshotResponse payload may contain several instances of the
     * sub-payload. Each instance is an acknowledgment from the device for a scheduled
     * snapshot and the ability for the device to support that type of snapshot.
     */
    private SnapshotResponsePayload snapshotResponsePayload;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ScheduleSnapshotResponse() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param issuerEventId {@link Integer} Issuer Event ID
     * @param snapshotResponsePayload {@link SnapshotResponsePayload} Snapshot Response Payload
     */
    public ScheduleSnapshotResponse(
            Integer issuerEventId,
            SnapshotResponsePayload snapshotResponsePayload) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;

        this.issuerEventId = issuerEventId;
        this.snapshotResponsePayload = snapshotResponsePayload;
    }

    /**
     * Gets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. The value contained in this
     * field indicates the value allocated to the ScheduleSnapshot command for which this
     * response is generated.
     *
     * @return the Issuer Event ID
     */
    public Integer getIssuerEventId() {
        return issuerEventId;
    }

    /**
     * Sets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. The value contained in this
     * field indicates the value allocated to the ScheduleSnapshot command for which this
     * response is generated.
     *
     * @param issuerEventId the Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Snapshot Response Payload.
     * <p>
     * The ScheduleSnapshotResponse payload may contain several instances of the
     * sub-payload. Each instance is an acknowledgment from the device for a scheduled
     * snapshot and the ability for the device to support that type of snapshot.
     *
     * @return the Snapshot Response Payload
     */
    public SnapshotResponsePayload getSnapshotResponsePayload() {
        return snapshotResponsePayload;
    }

    /**
     * Sets Snapshot Response Payload.
     * <p>
     * The ScheduleSnapshotResponse payload may contain several instances of the
     * sub-payload. Each instance is an acknowledgment from the device for a scheduled
     * snapshot and the ability for the device to support that type of snapshot.
     *
     * @param snapshotResponsePayload the Snapshot Response Payload
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setSnapshotResponsePayload(final SnapshotResponsePayload snapshotResponsePayload) {
        this.snapshotResponsePayload = snapshotResponsePayload;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        snapshotResponsePayload.serialize(serializer);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        snapshotResponsePayload = new SnapshotResponsePayload();
        snapshotResponsePayload.deserialize(deserializer);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(103);
        builder.append("ScheduleSnapshotResponse [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", snapshotResponsePayload=");
        builder.append(snapshotResponsePayload);
        builder.append(']');
        return builder.toString();
    }

}
