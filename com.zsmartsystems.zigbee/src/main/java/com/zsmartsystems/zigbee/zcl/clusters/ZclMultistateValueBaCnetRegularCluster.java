package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.ZigBeeDeviceAddress;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Multistate Value (BACnet Regular)</b> cluster implementation (<i>Cluster ID 0x0612</i>).
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclMultistateValueBaCnetRegularCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0612;

    // Cluster Name
    public static final String CLUSTER_NAME = "Multistate Value (BACnet Regular)";

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclMultistateValueBaCnetRegularCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }

}
