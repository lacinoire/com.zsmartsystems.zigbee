/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.price;

import java.util.Calendar;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Publish Calorific Value Command value object class.
 * <p>
 * Cluster: <b>Price</b>. Command ID 0x03 is sent <b>FROM</b> the server.
 * This command is a <b>specific</b> command used for the Price cluster.
 * <p>
 * The PublishCalorificValue command is sent in response to a GetCalorificValue command or if
 * a new calorific value is available. Clients shall be capable of storing at least two
 * instances of the Calorific Value, the currently active one and the next one.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class PublishCalorificValueCommand extends ZclPriceCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0700;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x03;

    /**
     * Issuer Event ID command message field.
     */
    private Integer issuerEventId;

    /**
     * Start Time command message field.
     */
    private Calendar startTime;

    /**
     * Calorific Value command message field.
     */
    private Integer calorificValue;

    /**
     * Calorific Value Unit command message field.
     */
    private Integer calorificValueUnit;

    /**
     * Calorific Value Trailing Digit command message field.
     */
    private Integer calorificValueTrailingDigit;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public PublishCalorificValueCommand() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param issuerEventId {@link Integer} Issuer Event ID
     * @param startTime {@link Calendar} Start Time
     * @param calorificValue {@link Integer} Calorific Value
     * @param calorificValueUnit {@link Integer} Calorific Value Unit
     * @param calorificValueTrailingDigit {@link Integer} Calorific Value Trailing Digit
     */
    public PublishCalorificValueCommand(
            Integer issuerEventId,
            Calendar startTime,
            Integer calorificValue,
            Integer calorificValueUnit,
            Integer calorificValueTrailingDigit) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.SERVER_TO_CLIENT;

        this.issuerEventId = issuerEventId;
        this.startTime = startTime;
        this.calorificValue = calorificValue;
        this.calorificValueUnit = calorificValueUnit;
        this.calorificValueTrailingDigit = calorificValueTrailingDigit;
    }

    /**
     * Gets Issuer Event ID.
     *
     * @return the Issuer Event ID
     */
    public Integer getIssuerEventId() {
        return issuerEventId;
    }

    /**
     * Sets Issuer Event ID.
     *
     * @param issuerEventId the Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Start Time.
     *
     * @return the Start Time
     */
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * Sets Start Time.
     *
     * @param startTime the Start Time
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setStartTime(final Calendar startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets Calorific Value.
     *
     * @return the Calorific Value
     */
    public Integer getCalorificValue() {
        return calorificValue;
    }

    /**
     * Sets Calorific Value.
     *
     * @param calorificValue the Calorific Value
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setCalorificValue(final Integer calorificValue) {
        this.calorificValue = calorificValue;
    }

    /**
     * Gets Calorific Value Unit.
     *
     * @return the Calorific Value Unit
     */
    public Integer getCalorificValueUnit() {
        return calorificValueUnit;
    }

    /**
     * Sets Calorific Value Unit.
     *
     * @param calorificValueUnit the Calorific Value Unit
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setCalorificValueUnit(final Integer calorificValueUnit) {
        this.calorificValueUnit = calorificValueUnit;
    }

    /**
     * Gets Calorific Value Trailing Digit.
     *
     * @return the Calorific Value Trailing Digit
     */
    public Integer getCalorificValueTrailingDigit() {
        return calorificValueTrailingDigit;
    }

    /**
     * Sets Calorific Value Trailing Digit.
     *
     * @param calorificValueTrailingDigit the Calorific Value Trailing Digit
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setCalorificValueTrailingDigit(final Integer calorificValueTrailingDigit) {
        this.calorificValueTrailingDigit = calorificValueTrailingDigit;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(startTime, ZclDataType.UTCTIME);
        serializer.serialize(calorificValue, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(calorificValueUnit, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(calorificValueTrailingDigit, ZclDataType.BITMAP_8_BIT);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        startTime = (Calendar) deserializer.deserialize(ZclDataType.UTCTIME);
        calorificValue = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        calorificValueUnit = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        calorificValueTrailingDigit = (Integer) deserializer.deserialize(ZclDataType.BITMAP_8_BIT);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(212);
        builder.append("PublishCalorificValueCommand [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", startTime=");
        builder.append(startTime);
        builder.append(", calorificValue=");
        builder.append(calorificValue);
        builder.append(", calorificValueUnit=");
        builder.append(calorificValueUnit);
        builder.append(", calorificValueTrailingDigit=");
        builder.append(calorificValueTrailingDigit);
        builder.append(']');
        return builder.toString();
    }

}
