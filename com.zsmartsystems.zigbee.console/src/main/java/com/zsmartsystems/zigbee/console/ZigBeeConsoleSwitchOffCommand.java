/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.console;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.ZigBeeEndpoint;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.ZigBeeNode;
import com.zsmartsystems.zigbee.groups.ZigBeeGroup;
import com.zsmartsystems.zigbee.zcl.clusters.ZclOnOffCluster;
import com.zsmartsystems.zigbee.zcl.clusters.onoff.OffCommand;

/**
 * Uses the OnOff cluster to switch a device off
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeConsoleSwitchOffCommand extends ZigBeeConsoleAbstractCommand {
    @Override
    public String getCommand() {
        return "off";
    }

    @Override
    public String getDescription() {
        return "Switches a device OFF";
    }

    @Override
    public String getSyntax() {
        return "ENDPOINT";
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public void process(ZigBeeNetworkManager networkManager, String[] args, PrintStream out)
            throws IllegalArgumentException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        List<ZclOnOffCluster> clusters = new ArrayList<>();
        if (WILDCARD.equals(args[1])) {
            for (ZigBeeNode node : networkManager.getNodes()) {
                for (ZigBeeEndpoint endpoint : node.getEndpoints()) {
                    ZclOnOffCluster cluster = (ZclOnOffCluster) endpoint.getInputCluster(ZclOnOffCluster.CLUSTER_ID);
                    if (cluster != null) {
                        clusters.add(cluster);
                    }
                }
            }
        } else {
            ZigBeeGroup group = getGroup(networkManager, args[1]);
            if (group != null) {
                OffCommand command = new OffCommand();
                group.sendCommand(command);
                return;
            }

            ZigBeeEndpoint endpoint = getEndpoint(networkManager, args[1]);
            ZclOnOffCluster cluster = (ZclOnOffCluster) endpoint.getInputCluster(ZclOnOffCluster.CLUSTER_ID);
            if (cluster != null) {
                clusters.add(cluster);
            }
        }

        CommandResult result;
        for (ZclOnOffCluster cluster : clusters) {
            OffCommand command = new OffCommand();
            try {
                result = cluster.sendCommand(command).get();
            } catch (Exception e) {
                out.println(
                        "[Endpoint: " + cluster.getZigBeeAddress() + "] Fail to send command [" + e.getMessage() + "]");
                return;
            }
            if (result.isError() || result.isTimeout()) {
                out.println("[Endpoint: " + cluster.getZigBeeAddress() + "] Command failed [error = " + result.isError()
                        + " , timeout = " + result.isTimeout() + "]");
                return;
            }
            out.println("[Endpoint: " + cluster.getZigBeeAddress() + "] Command has been successfully sent");
        }
    }
}
