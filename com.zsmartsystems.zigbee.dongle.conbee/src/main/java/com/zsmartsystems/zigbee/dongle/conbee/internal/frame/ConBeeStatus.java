/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.conbee.internal.frame;

/**
 *
 * @author Chris Jackson
 *
 */
public enum ConBeeStatus {
    SUCCESS,
    FAILURE,
    BUSY,
    TIMEOUT,
    UNSUPPORTED,
    ERROR,
    NO_NETWORK,
    INVALID_VALUE;
}
