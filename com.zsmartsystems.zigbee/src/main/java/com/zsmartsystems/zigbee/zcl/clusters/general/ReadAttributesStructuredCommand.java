/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.general;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Read Attributes Structured Command value object class.
 * <p>
 * Cluster: <b>General</b>. Command ID 0x0E is sent <b>TO</b> the server.
 * This command is a <b>generic</b> command used across the profile.
 * <p>
 * The read attributes command is generated when a device wishes to determine the values of one
 * or more attributes, or elements of attributes, located on another device. Each attribute
 * identifier field shall contain the identifier of the attribute to be read.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ReadAttributesStructuredCommand extends ZclGeneralCommand {
    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x0E;

    /**
     * Attribute Selectors command message field.
     */
    private Object attributeSelectors;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ReadAttributesStructuredCommand() {
        commandId = COMMAND_ID;
        genericCommand = true;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param attributeSelectors {@link Object} Attribute Selectors
     */
    public ReadAttributesStructuredCommand(
            Object attributeSelectors) {

        commandId = COMMAND_ID;
        genericCommand = true;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.attributeSelectors = attributeSelectors;
    }

    /**
     * Sets the cluster ID for <i>generic</i> commands. {@link ReadAttributesStructuredCommand} is a <i>generic</i> command.
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
     * Gets Attribute Selectors.
     *
     * @return the Attribute Selectors
     */
    public Object getAttributeSelectors() {
        return attributeSelectors;
    }

    /**
     * Sets Attribute Selectors.
     *
     * @param attributeSelectors the Attribute Selectors
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setAttributeSelectors(final Object attributeSelectors) {
        this.attributeSelectors = attributeSelectors;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(attributeSelectors, ZclDataType.N_X_ATTRIBUTE_SELECTOR);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        attributeSelectors = (Object) deserializer.deserialize(ZclDataType.N_X_ATTRIBUTE_SELECTOR);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(72);
        builder.append("ReadAttributesStructuredCommand [");
        builder.append(super.toString());
        builder.append(", attributeSelectors=");
        builder.append(attributeSelectors);
        builder.append(']');
        return builder.toString();
    }

}
