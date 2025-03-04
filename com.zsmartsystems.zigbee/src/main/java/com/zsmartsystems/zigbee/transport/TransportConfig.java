/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.transport;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.zsmartsystems.zigbee.ZigBeeStatus;

/**
 * A class to hold {@link TransportConfigOption}s
 *
 * @author Chris Jackson
 *
 */
public class TransportConfig {
    private final Map<TransportConfigOption, Object> request = new ConcurrentHashMap<>();
    private final Map<TransportConfigOption, ZigBeeStatus> response = new ConcurrentHashMap<>();

    /**
     * Creates a configuration and directly adds the option
     *
     * @param option
     * @param value
     */
    public TransportConfig(TransportConfigOption option, Object value) {
        request.put(option, value);
    }

    /**
     * Default constructor
     */
    public TransportConfig() {
    }

    /**
     * Adds a {@link TransportConfigOption} and its value. The same option can't be added to the configuration twice.
     *
     * @param option the {@link TransportConfigOption} to set
     * @return true if the option was added, false if the option already existed
     */
    public boolean addOption(TransportConfigOption option, Object value) {
        if (request.get(option) != null) {
            return false;
        }
        request.put(option, value);
        return true;
    }

    /**
     * Gets the a {@link TransportConfigOption} if it is configured
     *
     * @param option the {@link TransportConfigOption} to retrieve
     * @return the requested {@link TransportConfigOption} value or null if it is not set
     */
    public Object getOption(TransportConfigOption option) {
        return request.get(option);
    }

    /**
     * Gets the {@link Set} of {@link TransportConfigOption}s
     *
     * @return the {@link Set} of {@link TransportConfigOption}s
     */
    public Set<TransportConfigOption> getOptions() {
        return request.keySet();
    }

    /**
     * Gets a value for the specified {@link TransportConfigOption}
     *
     * @param option the {@link TransportConfigOption} to retrieve
     * @return the {@link Object}
     */
    public Object getValue(TransportConfigOption option) {
        return request.get(option);
    }

    /**
     * Sets the {@link ZigBeeStatus} for a configuration setting
     *
     * @param option the {@link TransportConfigOption} to set the result
     * @param value the {@link ZigBeeStatus}
     * @return true if the result was set, false if the option did not exist or the result was already set
     */
    public boolean setResult(TransportConfigOption option, ZigBeeStatus value) {
        if (request.get(option) == null || response.get(option) != null) {
            return false;
        }
        response.put(option, value);
        return true;
    }

    /**
     * Gets the the {@link TransportConfigResult} for a {@link TransportConfigOption} if it is configured
     *
     * @param option the {@link TransportConfigOption} to retrieve the result
     * @return the result {@link ZigBeeStatus} for the requested {@link TransportConfigOption}
     */
    public ZigBeeStatus getResult(TransportConfigOption option) {
        if (request.get(option) == null) {
            return ZigBeeStatus.INVALID_ARGUMENTS;
        }
        if (response.get(option) == null) {
            return ZigBeeStatus.BAD_RESPONSE;
        }
        return response.get(option);
    }

}
