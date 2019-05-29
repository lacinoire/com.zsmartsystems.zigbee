/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.metering;

import java.util.Calendar;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Start Sampling value object class.
 * <p>
 * Cluster: <b>Metering</b>. Command ID 0x07 is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Metering cluster.
 * <p>
 * The sampling mechanism allows a set of samples of the specified type of data to be taken,
 * commencing at the stipulated start time. This mechanism may run concurrently with the
 * capturing of profile data, and may refer the same parameters, albeit possibly at a different
 * sampling rate.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2019-04-14T08:41:54Z")
public class StartSampling extends ZclCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0702;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x07;

    /**
     * Issuer Event ID command message field.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the command was issued. Thus, newer information will have a value in
     * the Issuer Event ID field that is larger than older information. Commands should be
     * ignored if the value of the Issuer Event ID is equal to or less than the previous value; a
     * device may return a ZCL Default Response command in this case.
     */
    private Integer issuerEventId;

    /**
     * Start Sampling Time command message field.
     * <p>
     * A UTC Time field to denote the time at which the sampling should start. A start Date/Time
     * of 0x00000000 shall indicate that the command should be executed immediately. A start
     * Date/Time of 0xFFFFFFFF shall cause an existing StartSampling command with the same
     * Issuer Event ID to be cancelled.
     */
    private Calendar startSamplingTime;

    /**
     * Sample Type command message field.
     * <p>
     * An 8 bit enumeration that identifies the type of data being sampled.
     */
    private Integer sampleType;

    /**
     * Sample Request Interval command message field.
     * <p>
     * An unsigned 16-bit field representing the interval or time in seconds between samples.
     */
    private Integer sampleRequestInterval;

    /**
     * Max Number Of Samples command message field.
     * <p>
     * A 16 bit unsigned integer that represents the number of samples to be taken.
     */
    private Integer maxNumberOfSamples;

    /**
     * Default constructor.
     */
    public StartSampling() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Gets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the command was issued. Thus, newer information will have a value in
     * the Issuer Event ID field that is larger than older information. Commands should be
     * ignored if the value of the Issuer Event ID is equal to or less than the previous value; a
     * device may return a ZCL Default Response command in this case.
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
     * identifying when the command was issued. Thus, newer information will have a value in
     * the Issuer Event ID field that is larger than older information. Commands should be
     * ignored if the value of the Issuer Event ID is equal to or less than the previous value; a
     * device may return a ZCL Default Response command in this case.
     *
     * @param issuerEventId the Issuer Event ID
     */
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Start Sampling Time.
     * <p>
     * A UTC Time field to denote the time at which the sampling should start. A start Date/Time
     * of 0x00000000 shall indicate that the command should be executed immediately. A start
     * Date/Time of 0xFFFFFFFF shall cause an existing StartSampling command with the same
     * Issuer Event ID to be cancelled.
     *
     * @return the Start Sampling Time
     */
    public Calendar getStartSamplingTime() {
        return startSamplingTime;
    }

    /**
     * Sets Start Sampling Time.
     * <p>
     * A UTC Time field to denote the time at which the sampling should start. A start Date/Time
     * of 0x00000000 shall indicate that the command should be executed immediately. A start
     * Date/Time of 0xFFFFFFFF shall cause an existing StartSampling command with the same
     * Issuer Event ID to be cancelled.
     *
     * @param startSamplingTime the Start Sampling Time
     */
    public void setStartSamplingTime(final Calendar startSamplingTime) {
        this.startSamplingTime = startSamplingTime;
    }

    /**
     * Gets Sample Type.
     * <p>
     * An 8 bit enumeration that identifies the type of data being sampled.
     *
     * @return the Sample Type
     */
    public Integer getSampleType() {
        return sampleType;
    }

    /**
     * Sets Sample Type.
     * <p>
     * An 8 bit enumeration that identifies the type of data being sampled.
     *
     * @param sampleType the Sample Type
     */
    public void setSampleType(final Integer sampleType) {
        this.sampleType = sampleType;
    }

    /**
     * Gets Sample Request Interval.
     * <p>
     * An unsigned 16-bit field representing the interval or time in seconds between samples.
     *
     * @return the Sample Request Interval
     */
    public Integer getSampleRequestInterval() {
        return sampleRequestInterval;
    }

    /**
     * Sets Sample Request Interval.
     * <p>
     * An unsigned 16-bit field representing the interval or time in seconds between samples.
     *
     * @param sampleRequestInterval the Sample Request Interval
     */
    public void setSampleRequestInterval(final Integer sampleRequestInterval) {
        this.sampleRequestInterval = sampleRequestInterval;
    }

    /**
     * Gets Max Number Of Samples.
     * <p>
     * A 16 bit unsigned integer that represents the number of samples to be taken.
     *
     * @return the Max Number Of Samples
     */
    public Integer getMaxNumberOfSamples() {
        return maxNumberOfSamples;
    }

    /**
     * Sets Max Number Of Samples.
     * <p>
     * A 16 bit unsigned integer that represents the number of samples to be taken.
     *
     * @param maxNumberOfSamples the Max Number Of Samples
     */
    public void setMaxNumberOfSamples(final Integer maxNumberOfSamples) {
        this.maxNumberOfSamples = maxNumberOfSamples;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(startSamplingTime, ZclDataType.UTCTIME);
        serializer.serialize(sampleType, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(sampleRequestInterval, ZclDataType.UNSIGNED_16_BIT_INTEGER);
        serializer.serialize(maxNumberOfSamples, ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        startSamplingTime = (Calendar) deserializer.deserialize(ZclDataType.UTCTIME);
        sampleType = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        sampleRequestInterval = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
        maxNumberOfSamples = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(195);
        builder.append("StartSampling [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", startSamplingTime=");
        builder.append(startSamplingTime);
        builder.append(", sampleType=");
        builder.append(sampleType);
        builder.append(", sampleRequestInterval=");
        builder.append(sampleRequestInterval);
        builder.append(", maxNumberOfSamples=");
        builder.append(maxNumberOfSamples);
        builder.append(']');
        return builder.toString();
    }

}