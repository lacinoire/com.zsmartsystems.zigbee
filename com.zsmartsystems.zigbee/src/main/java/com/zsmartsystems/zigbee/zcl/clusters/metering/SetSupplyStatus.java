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
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Set Supply Status value object class.
 * <p>
 * Cluster: <b>Metering</b>. Command ID 0x0D is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Metering cluster.
 * <p>
 * This command is used to specify the required status of the supply following the occurance of
 * certain events on the meter.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class SetSupplyStatus extends ZclMeteringCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0702;

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
     * identifying when the command was issued. Thus, newer information will have a value in
     * the Issuer Event ID field that is larger than older information.
     */
    private Integer issuerEventId;

    /**
     * Supply Tamper State command message field.
     * <p>
     * The SupplyTamperState indicates the required status of the supply following the
     * detection of a tamper event within the metering device.
     */
    private Integer supplyTamperState;

    /**
     * Supply Depletion State command message field.
     * <p>
     * The SupplyDepletionState indicates the required status of the supply following
     * detection of a depleted battery within the metering device.
     */
    private Integer supplyDepletionState;

    /**
     * Supply Uncontrolled Flow State command message field.
     * <p>
     * The SupplyUncontrolledFlowState indicates the required status of the supply
     * following detection of an uncontrolled flow event within the metering device.
     */
    private Integer supplyUncontrolledFlowState;

    /**
     * Load Limit Supply State command message field.
     * <p>
     * The LoadLimitSupplyState indicates the required status of the supply once the device
     * is in a load limit state.
     */
    private Integer loadLimitSupplyState;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public SetSupplyStatus() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param issuerEventId {@link Integer} Issuer Event ID
     * @param supplyTamperState {@link Integer} Supply Tamper State
     * @param supplyDepletionState {@link Integer} Supply Depletion State
     * @param supplyUncontrolledFlowState {@link Integer} Supply Uncontrolled Flow State
     * @param loadLimitSupplyState {@link Integer} Load Limit Supply State
     */
    public SetSupplyStatus(
            Integer issuerEventId,
            Integer supplyTamperState,
            Integer supplyDepletionState,
            Integer supplyUncontrolledFlowState,
            Integer loadLimitSupplyState) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.issuerEventId = issuerEventId;
        this.supplyTamperState = supplyTamperState;
        this.supplyDepletionState = supplyDepletionState;
        this.supplyUncontrolledFlowState = supplyUncontrolledFlowState;
        this.loadLimitSupplyState = loadLimitSupplyState;
    }

    /**
     * Gets Issuer Event ID.
     * <p>
     * Unique identifier generated by the commodity provider. When new information is
     * provided that replaces older information for the same time period, this field allows
     * devices to determine which information is newer. The value contained in this field is a
     * unique number managed by upstream servers or a UTC based time stamp (UTCTime data type)
     * identifying when the command was issued. Thus, newer information will have a value in
     * the Issuer Event ID field that is larger than older information.
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
     * the Issuer Event ID field that is larger than older information.
     *
     * @param issuerEventId the Issuer Event ID
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setIssuerEventId(final Integer issuerEventId) {
        this.issuerEventId = issuerEventId;
    }

    /**
     * Gets Supply Tamper State.
     * <p>
     * The SupplyTamperState indicates the required status of the supply following the
     * detection of a tamper event within the metering device.
     *
     * @return the Supply Tamper State
     */
    public Integer getSupplyTamperState() {
        return supplyTamperState;
    }

    /**
     * Sets Supply Tamper State.
     * <p>
     * The SupplyTamperState indicates the required status of the supply following the
     * detection of a tamper event within the metering device.
     *
     * @param supplyTamperState the Supply Tamper State
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setSupplyTamperState(final Integer supplyTamperState) {
        this.supplyTamperState = supplyTamperState;
    }

    /**
     * Gets Supply Depletion State.
     * <p>
     * The SupplyDepletionState indicates the required status of the supply following
     * detection of a depleted battery within the metering device.
     *
     * @return the Supply Depletion State
     */
    public Integer getSupplyDepletionState() {
        return supplyDepletionState;
    }

    /**
     * Sets Supply Depletion State.
     * <p>
     * The SupplyDepletionState indicates the required status of the supply following
     * detection of a depleted battery within the metering device.
     *
     * @param supplyDepletionState the Supply Depletion State
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setSupplyDepletionState(final Integer supplyDepletionState) {
        this.supplyDepletionState = supplyDepletionState;
    }

    /**
     * Gets Supply Uncontrolled Flow State.
     * <p>
     * The SupplyUncontrolledFlowState indicates the required status of the supply
     * following detection of an uncontrolled flow event within the metering device.
     *
     * @return the Supply Uncontrolled Flow State
     */
    public Integer getSupplyUncontrolledFlowState() {
        return supplyUncontrolledFlowState;
    }

    /**
     * Sets Supply Uncontrolled Flow State.
     * <p>
     * The SupplyUncontrolledFlowState indicates the required status of the supply
     * following detection of an uncontrolled flow event within the metering device.
     *
     * @param supplyUncontrolledFlowState the Supply Uncontrolled Flow State
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setSupplyUncontrolledFlowState(final Integer supplyUncontrolledFlowState) {
        this.supplyUncontrolledFlowState = supplyUncontrolledFlowState;
    }

    /**
     * Gets Load Limit Supply State.
     * <p>
     * The LoadLimitSupplyState indicates the required status of the supply once the device
     * is in a load limit state.
     *
     * @return the Load Limit Supply State
     */
    public Integer getLoadLimitSupplyState() {
        return loadLimitSupplyState;
    }

    /**
     * Sets Load Limit Supply State.
     * <p>
     * The LoadLimitSupplyState indicates the required status of the supply once the device
     * is in a load limit state.
     *
     * @param loadLimitSupplyState the Load Limit Supply State
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setLoadLimitSupplyState(final Integer loadLimitSupplyState) {
        this.loadLimitSupplyState = loadLimitSupplyState;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(issuerEventId, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(supplyTamperState, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(supplyDepletionState, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(supplyUncontrolledFlowState, ZclDataType.ENUMERATION_8_BIT);
        serializer.serialize(loadLimitSupplyState, ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        issuerEventId = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        supplyTamperState = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        supplyDepletionState = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        supplyUncontrolledFlowState = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
        loadLimitSupplyState = (Integer) deserializer.deserialize(ZclDataType.ENUMERATION_8_BIT);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(215);
        builder.append("SetSupplyStatus [");
        builder.append(super.toString());
        builder.append(", issuerEventId=");
        builder.append(issuerEventId);
        builder.append(", supplyTamperState=");
        builder.append(supplyTamperState);
        builder.append(", supplyDepletionState=");
        builder.append(supplyDepletionState);
        builder.append(", supplyUncontrolledFlowState=");
        builder.append(supplyUncontrolledFlowState);
        builder.append(", loadLimitSupplyState=");
        builder.append(loadLimitSupplyState);
        builder.append(']');
        return builder.toString();
    }

}
