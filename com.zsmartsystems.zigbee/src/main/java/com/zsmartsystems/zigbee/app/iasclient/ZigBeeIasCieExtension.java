/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.app.iasclient;

import com.zsmartsystems.zigbee.ZigBeeEndpoint;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.ZigBeeNetworkNodeListener;
import com.zsmartsystems.zigbee.ZigBeeNode;
import com.zsmartsystems.zigbee.ZigBeeStatus;
import com.zsmartsystems.zigbee.app.ZigBeeNetworkExtension;
import com.zsmartsystems.zigbee.zcl.clusters.ZclIasZoneCluster;

/**
 * IAS extension. This provides the top level functionality for the IAS application.
 * <p>
 * It listens for new nodes that are discovered on the network and registers the {@link ZclIasZoneCluster} if the
 * device supports IAS Zone control.
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeIasCieExtension implements ZigBeeNetworkExtension, ZigBeeNetworkNodeListener {
    // private final Map<Integer, IeeeAddress> zoneMap = new ConcurrentHashMap<>();

    private ZigBeeNetworkManager networkManager;

    @Override
    public ZigBeeStatus extensionInitialize(ZigBeeNetworkManager networkManager) {
        this.networkManager = networkManager;

        networkManager.addSupportedClientCluster(ZclIasZoneCluster.CLUSTER_ID);
        networkManager.addNetworkNodeListener(this);
        return ZigBeeStatus.SUCCESS;
    }

    @Override
    public ZigBeeStatus extensionStartup() {
        return ZigBeeStatus.SUCCESS;
    }

    @Override
    public void extensionShutdown() {
        networkManager.removeNetworkNodeListener(this);
    }

    @Override
    public void nodeAdded(ZigBeeNode node) {
        for (ZigBeeEndpoint endpoint : node.getEndpoints()) {
            if (endpoint.getInputCluster(ZclIasZoneCluster.CLUSTER_ID) != null) {
                endpoint.addApplication(new ZclIasZoneClient(networkManager, networkManager.getLocalIeeeAddress(), 0));
                break;
            }
        }
    }
}
