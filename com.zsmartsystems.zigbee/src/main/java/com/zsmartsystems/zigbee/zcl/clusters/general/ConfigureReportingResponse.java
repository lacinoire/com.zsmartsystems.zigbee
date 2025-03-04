/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.general;

import java.util.List;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclStatus;
import com.zsmartsystems.zigbee.zcl.field.AttributeStatusRecord;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Configure Reporting Response value object class.
 * <p>
 * Cluster: <b>General</b>. Command ID 0x07 is sent <b>TO</b> the server.
 * This command is a <b>generic</b> command used across the profile.
 * <p>
 * The Configure Reporting Response command is generated in response to a Configure Reporting
 * command.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ConfigureReportingResponse extends ZclGeneralCommand {
    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x07;

    /**
     * Status command message field.
     * <p>
     * Status is only provided if the command was successful, and the attribute status records
     * are not included for successfully written attributes, in order to save bandwidth.
     */
    private ZclStatus status;

    /**
     * Records command message field.
     * <p>
     * Note that attribute status records are not included for successfully configured
     * attributes in order to save bandwidth. In the case of successful configuration of all
     * attributes, only a single attribute status record shall be included in the command,
     * with the status field set to SUCCESS and the direction and attribute identifier fields
     * omitted.
     */
    private List<AttributeStatusRecord> records;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ConfigureReportingResponse() {
        commandId = COMMAND_ID;
        genericCommand = true;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param status {@link ZclStatus} Status
     * @param records {@link List<AttributeStatusRecord>} Records
     */
    public ConfigureReportingResponse(
            ZclStatus status,
            List<AttributeStatusRecord> records) {

        commandId = COMMAND_ID;
        genericCommand = true;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.status = status;
        this.records = records;
    }

    /**
     * Sets the cluster ID for <i>generic</i> commands. {@link ConfigureReportingResponse} is a <i>generic</i> command.
     * <p>
     * For commands that are not <i>generic</i>, this method will do nothing as the cluster ID is fixed.
     * To test if a command is <i>generic</i>, use the {@link #isGenericCommand} method.
     *
     * @param clusterId the cluster ID used for <i>generic</i> commands as an {@link Integer}
     */
    @Override
    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * Gets Status.
     * <p>
     * Status is only provided if the command was successful, and the attribute status records
     * are not included for successfully written attributes, in order to save bandwidth.
     *
     * @return the Status
     */
    public ZclStatus getStatus() {
        return status;
    }

    /**
     * Sets Status.
     * <p>
     * Status is only provided if the command was successful, and the attribute status records
     * are not included for successfully written attributes, in order to save bandwidth.
     *
     * @param status the Status
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setStatus(final ZclStatus status) {
        this.status = status;
    }

    /**
     * Gets Records.
     * <p>
     * Note that attribute status records are not included for successfully configured
     * attributes in order to save bandwidth. In the case of successful configuration of all
     * attributes, only a single attribute status record shall be included in the command,
     * with the status field set to SUCCESS and the direction and attribute identifier fields
     * omitted.
     *
     * @return the Records
     */
    public List<AttributeStatusRecord> getRecords() {
        return records;
    }

    /**
     * Sets Records.
     * <p>
     * Note that attribute status records are not included for successfully configured
     * attributes in order to save bandwidth. In the case of successful configuration of all
     * attributes, only a single attribute status record shall be included in the command,
     * with the status field set to SUCCESS and the direction and attribute identifier fields
     * omitted.
     *
     * @param records the Records
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setRecords(final List<AttributeStatusRecord> records) {
        this.records = records;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        if (status == ZclStatus.SUCCESS) {
            serializer.serialize(status, ZclDataType.ZCL_STATUS);
            return;
        }
        serializer.serialize(records, ZclDataType.N_X_ATTRIBUTE_STATUS_RECORD);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        if (deserializer.getRemainingLength() == 1) {
            status = (ZclStatus) deserializer.deserialize(ZclDataType.ZCL_STATUS);
            return;
        }
        records = (List<AttributeStatusRecord>) deserializer.deserialize(ZclDataType.N_X_ATTRIBUTE_STATUS_RECORD);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(82);
        builder.append("ConfigureReportingResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", records=");
        builder.append(records);
        builder.append(']');
        return builder.toString();
    }

}
