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
 * Get Conversion Factor Command value object class.
 * <p>
 * Cluster: <b>Price</b>. Command ID 0x04 is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Price cluster.
 * <p>
 * This command initiates a PublishConversionFactor command(s) for scheduled conversion
 * factor updates. A server device shall be capable of storing at least two instances, the
 * current and (if available) next instance to be activated in the future. <br> A ZCL Default
 * response with status NOT_FOUND shall be returned if there are no conversion factor updates
 * available
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class GetConversionFactorCommand extends ZclPriceCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0700;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x04;

    /**
     * Earliest Start Time command message field.
     * <p>
     * UTCTime stamp indicating the earliest start time of values to be returned by the
     * corresponding PublishConversionFactor command. The first returned
     * PublishConversionFactor command shall be the instance which is active or becomes
     * active at or after the stated Earliest Start Time. If more than one instance is
     * requested, the active and scheduled instances shall be sent with ascending ordered
     * StartTime.
     * <p>
     * Min. Issuer Event ID Field A 32-bit integer representing the minimum Issuer Event ID of
     * values to be returned by the corresponding PublishCalorificValue command. A value of
     * 0xFFFFFFFF means not specified; the server shall return values irrespective of the
     * value of the Issuer Event ID.
     */
    private Calendar earliestStartTime;

    /**
     * Min . Issuer Event ID command message field.
     */
    private Integer minIssuerEventId;

    /**
     * Number Of Commands command message field.
     * <p>
     * An 8-bit integer which represents the maximum number of PublishConversionFactor
     * commands that the CLIENT is willing to receive in response to this command. A value of 0
     * would indicate all available PublishConversionFactor commands shall be returned.
     */
    private Integer numberOfCommands;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public GetConversionFactorCommand() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param earliestStartTime {@link Calendar} Earliest Start Time
     * @param minIssuerEventId {@link Integer} Min . Issuer Event ID
     * @param numberOfCommands {@link Integer} Number Of Commands
     */
    public GetConversionFactorCommand(
            Calendar earliestStartTime,
            Integer minIssuerEventId,
            Integer numberOfCommands) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.earliestStartTime = earliestStartTime;
        this.minIssuerEventId = minIssuerEventId;
        this.numberOfCommands = numberOfCommands;
    }

    /**
     * Gets Earliest Start Time.
     * <p>
     * UTCTime stamp indicating the earliest start time of values to be returned by the
     * corresponding PublishConversionFactor command. The first returned
     * PublishConversionFactor command shall be the instance which is active or becomes
     * active at or after the stated Earliest Start Time. If more than one instance is
     * requested, the active and scheduled instances shall be sent with ascending ordered
     * StartTime.
     * <p>
     * Min. Issuer Event ID Field A 32-bit integer representing the minimum Issuer Event ID of
     * values to be returned by the corresponding PublishCalorificValue command. A value of
     * 0xFFFFFFFF means not specified; the server shall return values irrespective of the
     * value of the Issuer Event ID.
     *
     * @return the Earliest Start Time
     */
    public Calendar getEarliestStartTime() {
        return earliestStartTime;
    }

    /**
     * Sets Earliest Start Time.
     * <p>
     * UTCTime stamp indicating the earliest start time of values to be returned by the
     * corresponding PublishConversionFactor command. The first returned
     * PublishConversionFactor command shall be the instance which is active or becomes
     * active at or after the stated Earliest Start Time. If more than one instance is
     * requested, the active and scheduled instances shall be sent with ascending ordered
     * StartTime.
     * <p>
     * Min. Issuer Event ID Field A 32-bit integer representing the minimum Issuer Event ID of
     * values to be returned by the corresponding PublishCalorificValue command. A value of
     * 0xFFFFFFFF means not specified; the server shall return values irrespective of the
     * value of the Issuer Event ID.
     *
     * @param earliestStartTime the Earliest Start Time
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setEarliestStartTime(final Calendar earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    /**
     * Gets Min . Issuer Event ID.
     *
     * @return the Min . Issuer Event ID
     */
    public Integer getMinIssuerEventId() {
        return minIssuerEventId;
    }

    /**
     * Sets Min . Issuer Event ID.
     *
     * @param minIssuerEventId the Min . Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setMinIssuerEventId(final Integer minIssuerEventId) {
        this.minIssuerEventId = minIssuerEventId;
    }

    /**
     * Gets Number Of Commands.
     * <p>
     * An 8-bit integer which represents the maximum number of PublishConversionFactor
     * commands that the CLIENT is willing to receive in response to this command. A value of 0
     * would indicate all available PublishConversionFactor commands shall be returned.
     *
     * @return the Number Of Commands
     */
    public Integer getNumberOfCommands() {
        return numberOfCommands;
    }

    /**
     * Sets Number Of Commands.
     * <p>
     * An 8-bit integer which represents the maximum number of PublishConversionFactor
     * commands that the CLIENT is willing to receive in response to this command. A value of 0
     * would indicate all available PublishConversionFactor commands shall be returned.
     *
     * @param numberOfCommands the Number Of Commands
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setNumberOfCommands(final Integer numberOfCommands) {
        this.numberOfCommands = numberOfCommands;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(earliestStartTime, ZclDataType.UTCTIME);
        serializer.serialize(minIssuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(numberOfCommands, ZclDataType.UNSIGNED_8_BIT_INTEGER);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        earliestStartTime = (Calendar) deserializer.deserialize(ZclDataType.UTCTIME);
        minIssuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        numberOfCommands = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(138);
        builder.append("GetConversionFactorCommand [");
        builder.append(super.toString());
        builder.append(", earliestStartTime=");
        builder.append(earliestStartTime);
        builder.append(", minIssuerEventId=");
        builder.append(minIssuerEventId);
        builder.append(", numberOfCommands=");
        builder.append(numberOfCommands);
        builder.append(']');
        return builder.toString();
    }

}
