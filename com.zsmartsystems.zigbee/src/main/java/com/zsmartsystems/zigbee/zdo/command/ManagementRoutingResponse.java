/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zdo.command;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoResponse;
import com.zsmartsystems.zigbee.zdo.ZdoStatus;
import com.zsmartsystems.zigbee.zdo.field.RoutingTable;

/**
 * Management Routing Response value object class.
 * <p>
 * <p>
 * The Mgmt_Rtg_rsp is generated in response to an Mgmt_Rtg_req. If this management command is
 * not supported, a status of NOT_SUPPORTED shall be returned and all parameter fields after
 * the Status field shall be omitted. Otherwise, the Remote Device shall implement the
 * following processing.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class ManagementRoutingResponse extends ZdoResponse {
    /**
     * The ZDO cluster ID.
     */
    public static int CLUSTER_ID = 0x8032;

    /**
     * Routing Table Entries command message field.
     */
    private Integer routingTableEntries;

    /**
     * Start Index command message field.
     */
    private Integer startIndex;

    /**
     * Routing Table List command message field.
     */
    private List<RoutingTable> routingTableList;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public ManagementRoutingResponse() {
        clusterId = CLUSTER_ID;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param status {@link ZdoStatus} Status
     * @param routingTableEntries {@link Integer} Routing Table Entries
     * @param startIndex {@link Integer} Start Index
     * @param routingTableList {@link List<RoutingTable>} Routing Table List
     */
    public ManagementRoutingResponse(
            ZdoStatus status,
            Integer routingTableEntries,
            Integer startIndex,
            List<RoutingTable> routingTableList) {

        clusterId = CLUSTER_ID;

        this.status = status;
        this.routingTableEntries = routingTableEntries;
        this.startIndex = startIndex;
        this.routingTableList = routingTableList;
    }

    /**
     * Gets Routing Table Entries.
     *
     * @return the Routing Table Entries
     */
    public Integer getRoutingTableEntries() {
        return routingTableEntries;
    }

    /**
     * Sets Routing Table Entries.
     *
     * @param routingTableEntries the Routing Table Entries
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setRoutingTableEntries(final Integer routingTableEntries) {
        this.routingTableEntries = routingTableEntries;
    }

    /**
     * Gets Start Index.
     *
     * @return the Start Index
     */
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * Sets Start Index.
     *
     * @param startIndex the Start Index
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setStartIndex(final Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * Gets Routing Table List.
     *
     * @return the Routing Table List
     */
    public List<RoutingTable> getRoutingTableList() {
        return routingTableList;
    }

    /**
     * Sets Routing Table List.
     *
     * @param routingTableList the Routing Table List
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setRoutingTableList(final List<RoutingTable> routingTableList) {
        this.routingTableList = routingTableList;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
        serializer.serialize(routingTableEntries, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(startIndex, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(routingTableList.size(), ZclDataType.UNSIGNED_8_BIT_INTEGER);
        for (int cnt = 0; cnt < routingTableList.size(); cnt++) {
            serializer.serialize(routingTableList.get(cnt), ZclDataType.ROUTING_TABLE);
        }
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        // Create lists
        routingTableList = new ArrayList<RoutingTable>();

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
        routingTableEntries = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        startIndex = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        Integer routingTableListCount = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        if (routingTableListCount != null) {
            for (int cnt = 0; cnt < routingTableListCount; cnt++) {
                routingTableList.add((RoutingTable) deserializer.deserialize(ZclDataType.ROUTING_TABLE));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ManagementRoutingResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", routingTableEntries=");
        builder.append(routingTableEntries);
        builder.append(", startIndex=");
        builder.append(startIndex);
        builder.append(", routingTableList=");
        builder.append(routingTableList);
        builder.append(']');
        return builder.toString();
    }

}
