/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.protocol;

/**
 * Direction of ZCL commands
 *
 * @author Chris Jackson
 *
 */
public enum ZclCommandDirection {
    CLIENT_TO_SERVER,
    SERVER_TO_CLIENT;

    /**
     * Returns the {@link ZclCommandDirection} for the response frame
     *
     * @return the {@link ZclCommandDirection} for the response frame
     */
    public ZclCommandDirection getResponseDirection() {
        return this == CLIENT_TO_SERVER ? SERVER_TO_CLIENT : CLIENT_TO_SERVER;
    }
}
