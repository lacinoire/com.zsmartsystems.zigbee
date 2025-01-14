/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.otaupgrade;

import javax.annotation.Generated;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclCommandDirection;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;

/**
 * Query Specific File Command value object class.
 * <p>
 * Cluster: <b>Ota Upgrade</b>. Command ID 0x08 is sent <b>TO</b> the server.
 * This command is a <b>specific</b> command used for the Ota Upgrade cluster.
 * <p>
 * Client devices shall send a Query Specific File Request command to the server to request for a
 * file that is specific and unique to it. Such file could contain non-firmware data such as
 * security credential (needed for upgrading from Smart Energy 1.1 to Smart Energy 2.0),
 * configuration or log. When the device decides to send the Query Specific File Request
 * command is manufacturer specific. However, one example is during upgrading from SE 1.1 to
 * 2.0 where the client may have already obtained new SE 2.0 image and now needs new SE 2.0
 * security credential data.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZigBeeCodeGenerator", date = "2020-12-25T10:11:19Z")
public class QuerySpecificFileCommand extends ZclOtaUpgradeCommand {
    /**
     * The cluster ID to which this command belongs.
     */
    public static int CLUSTER_ID = 0x0019;

    /**
     * The command ID.
     */
    public static int COMMAND_ID = 0x08;

    /**
     * Request Node Address command message field.
     */
    private IeeeAddress requestNodeAddress;

    /**
     * Manufacturer Code command message field.
     */
    private Integer manufacturerCode;

    /**
     * Image Type command message field.
     */
    private Integer imageType;

    /**
     * File Version command message field.
     */
    private Integer fileVersion;

    /**
     * Zigbee Stack Version command message field.
     */
    private Integer zigbeeStackVersion;

    /**
     * Default constructor.
     *
     * @deprecated from release 1.3.0. Use the parameterised constructor instead of the default constructor and setters.
     */
    @Deprecated
    public QuerySpecificFileCommand() {
        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;
    }

    /**
     * Constructor providing all required parameters.
     *
     * @param requestNodeAddress {@link IeeeAddress} Request Node Address
     * @param manufacturerCode {@link Integer} Manufacturer Code
     * @param imageType {@link Integer} Image Type
     * @param fileVersion {@link Integer} File Version
     * @param zigbeeStackVersion {@link Integer} Zigbee Stack Version
     */
    public QuerySpecificFileCommand(
            IeeeAddress requestNodeAddress,
            Integer manufacturerCode,
            Integer imageType,
            Integer fileVersion,
            Integer zigbeeStackVersion) {

        clusterId = CLUSTER_ID;
        commandId = COMMAND_ID;
        genericCommand = false;
        commandDirection = ZclCommandDirection.CLIENT_TO_SERVER;

        this.requestNodeAddress = requestNodeAddress;
        this.manufacturerCode = manufacturerCode;
        this.imageType = imageType;
        this.fileVersion = fileVersion;
        this.zigbeeStackVersion = zigbeeStackVersion;
    }

    /**
     * Gets Request Node Address.
     *
     * @return the Request Node Address
     */
    public IeeeAddress getRequestNodeAddress() {
        return requestNodeAddress;
    }

    /**
     * Sets Request Node Address.
     *
     * @param requestNodeAddress the Request Node Address
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setRequestNodeAddress(final IeeeAddress requestNodeAddress) {
        this.requestNodeAddress = requestNodeAddress;
    }

    /**
     * Gets Manufacturer Code.
     *
     * @return the Manufacturer Code
     */
    public Integer getManufacturerCode() {
        return manufacturerCode;
    }

    /**
     * Sets Manufacturer Code.
     *
     * @param manufacturerCode the Manufacturer Code
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setManufacturerCode(final Integer manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    /**
     * Gets Image Type.
     *
     * @return the Image Type
     */
    public Integer getImageType() {
        return imageType;
    }

    /**
     * Sets Image Type.
     *
     * @param imageType the Image Type
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setImageType(final Integer imageType) {
        this.imageType = imageType;
    }

    /**
     * Gets File Version.
     *
     * @return the File Version
     */
    public Integer getFileVersion() {
        return fileVersion;
    }

    /**
     * Sets File Version.
     *
     * @param fileVersion the File Version
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setFileVersion(final Integer fileVersion) {
        this.fileVersion = fileVersion;
    }

    /**
     * Gets Zigbee Stack Version.
     *
     * @return the Zigbee Stack Version
     */
    public Integer getZigbeeStackVersion() {
        return zigbeeStackVersion;
    }

    /**
     * Sets Zigbee Stack Version.
     *
     * @param zigbeeStackVersion the Zigbee Stack Version
     * @deprecated as of 1.3.0. Use the parameterised constructor instead to ensure that all mandatory fields are provided.
     */
    @Deprecated
    public void setZigbeeStackVersion(final Integer zigbeeStackVersion) {
        this.zigbeeStackVersion = zigbeeStackVersion;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        serializer.serialize(requestNodeAddress, ZclDataType.IEEE_ADDRESS);
        serializer.serialize(manufacturerCode, ZclDataType.UNSIGNED_16_BIT_INTEGER);
        serializer.serialize(imageType, ZclDataType.UNSIGNED_16_BIT_INTEGER);
        serializer.serialize(fileVersion, ZclDataType.UNSIGNED_32_BIT_INTEGER);
        serializer.serialize(zigbeeStackVersion, ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        requestNodeAddress = (IeeeAddress) deserializer.deserialize(ZclDataType.IEEE_ADDRESS);
        manufacturerCode = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
        imageType = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
        fileVersion = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_32_BIT_INTEGER);
        zigbeeStackVersion = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_16_BIT_INTEGER);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(199);
        builder.append("QuerySpecificFileCommand [");
        builder.append(super.toString());
        builder.append(", requestNodeAddress=");
        builder.append(requestNodeAddress);
        builder.append(", manufacturerCode=");
        builder.append(manufacturerCode);
        builder.append(", imageType=");
        builder.append(imageType);
        builder.append(", fileVersion=");
        builder.append(fileVersion);
        builder.append(", zigbeeStackVersion=");
        builder.append(zigbeeStackVersion);
        builder.append(']');
        return builder.toString();
    }

}
