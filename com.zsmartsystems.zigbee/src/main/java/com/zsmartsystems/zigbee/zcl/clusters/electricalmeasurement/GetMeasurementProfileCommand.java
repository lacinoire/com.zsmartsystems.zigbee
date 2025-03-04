/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.electricalmeasurement;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Get Measurement Profile Command value object class.
 * <p>
 * Cluster: <b>Electrical Measurement</b>. Command ID 0x01 is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Electrical Measurement cluster.
 * <p>
 * Retrieves an electricity measurement profile from the electricity measurement server for
 * a specific attribute ID requested.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class GetMeasurementProfileCommand extends ZclElectricalMeasurementCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0B04;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x01;

    /**
     * Attribute ID command message field.
     */
    private Integer attributeId;

    /**
     * Start Time command message field.
     */
    private Integer startTime;

    /**
     * Number Of Intervals command message field.
     */
    private Integer numberOfIntervals;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public GetMeasurementProfileCommand() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param attributeId {@link Integer} Attribute ID
     * @param startTime {@link Integer} Start Time
     * @param numberOfIntervals {@link Integer} Number Of Intervals
     */
    public GetMeasurementProfileCommand(
            Integer attributeId,
            Integer startTime,
            Integer numberOfIntervals) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.attributeId = attributeId;
        this.startTime = startTime;
        this.numberOfIntervals = numberOfIntervals;
    }

    /**
     * Gets Attribute ID.
     *
     * @return the Attribute ID
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * Sets Attribute ID.
     *
     * @param attributeId the Attribute ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setAttributeId(final Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * Gets Start Time.
     *
     * @return the Start Time
     */
    public Integer getStartTime() {
        return startTime;
    }

    /**
     * Sets Start Time.
     *
     * @param startTime the Start Time
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setStartTime(final Integer startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets Number Of Intervals.
     *
     * @return the Number Of Intervals
     */
    public Integer getNumberOfIntervals() {
        return numberOfIntervals;
    }

    /**
     * Sets Number Of Intervals.
     *
     * @param numberOfIntervals the Number Of Intervals
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNumberOfIntervals(final Integer numberOfIntervals) {
        this.numberOfIntervals = numberOfIntervals;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(attributeId, ZclDataType.UNSIGNED_16_BIT_INTEGER);
        serializer.serialize(startTime, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(numberOfIntervals, ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        attributeId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
        startTime = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        numberOfIntervals = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128);
        builder.append("GetMeasurementProfileCommand [");
        builder.append(super.toString());
        builder.append(", attributeId=");
        builder.append(attributeId);
        builder.append(", startTime=");
        builder.append(startTime);
        builder.append(", numberOfIntervals=");
        builder.append(numberOfIntervals);
        builder.append(']');
        return builder.toString();
    }

}
