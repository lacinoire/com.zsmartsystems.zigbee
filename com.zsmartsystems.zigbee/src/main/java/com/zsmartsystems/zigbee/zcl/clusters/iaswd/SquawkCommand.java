/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.iaswd;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;

/**
 * Squawk Command value object class.
 * <p>
 * Cluster: <b>IAS WD</b>. Command is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the IAS WD cluster.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZclProtocolCodeGenerator", date = "2018-04-13T17:16:42Z")
public class SquawkCommand extends ZclCommand {
    /**
     * Header command message field.
     */
    private Integer header;

    /**
     * Default constructor.
     */
    public SquawkCommand() {
        genericCommand = false;
        clusterId = 1282;
        commandId = 2;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Gets Header.
     *
     * @return the Header
     */
    public Integer getHeader() {
        return header;
    }

    /**
     * Sets Header.
     *
     * @param header the Header
     */
    public void setHeader(final Integer header) {
        this.header = header;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(header, ZclDataType.DATA_8_BIT);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        header = (Integer) deserializer.deserialize(ZclDataType.DATA_8_BIT);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(42);
        builder.append("SquawkCommand [");
        builder.append(super.toString());
        builder.append(", header=");
        builder.append(header);
        builder.append(']');
        return builder.toString();
    }

}
