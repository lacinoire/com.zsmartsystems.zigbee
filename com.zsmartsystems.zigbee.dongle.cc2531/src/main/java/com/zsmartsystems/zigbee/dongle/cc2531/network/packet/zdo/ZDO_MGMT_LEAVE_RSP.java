/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
/*
   Copyright 2008-2013 ITACA-TSB, http://www.tsb.upv.es/
   Instituto Tecnologico de Aplicaciones de Comunicacion
   Avanzadas - Grupo Tecnologias para la Salud y el
   Bienestar (TSB)


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.zsmartsystems.zigbee.dongle.cc2531.network.packet.zdo;

import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ResponseStatus;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolCMD;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolPacket;
import com.zsmartsystems.zigbee.dongle.cc2531.zigbee.util.DoubleByte;
import com.zsmartsystems.zigbee.dongle.cc2531.zigbee.util.ZToolAddress16;

/**
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 */
public class ZDO_MGMT_LEAVE_RSP extends ZToolPacket /* implements IRESPONSE_CALLBACK,IZDO */ {
    /// <name>TI.ZPI1.ZDO_MGMT_LEAVE_RSP.SrcAddress</name>
    /// <summary>Source address of the message</summary>
    private ZToolAddress16 SrcAddress;
    /// <name>TI.ZPI1.ZDO_MGMT_LEAVE_RSP.Status</name>
    /// <summary>this field indicates either SUCCESS (0) or FAILURE (1).</summary>
    public int Status;

    /// <name>TI.ZPI1.ZDO_MGMT_LEAVE_RSP</name>
    /// <summary>Constructor</summary>
    public ZDO_MGMT_LEAVE_RSP() {
    }

    public ZDO_MGMT_LEAVE_RSP(int[] framedata) {
        this.SrcAddress = new ZToolAddress16(framedata[1], framedata[0]);
        this.Status = framedata[2];
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MGMT_LEAVE_RSP), framedata);
    }

    @Override
    public String toString() {
        return "ZDO_MGMT_LEAVE_RSP{" + "SrcAddress=" + SrcAddress + ", Status=" + ResponseStatus.getStatus(Status)
                + '}';
    }
}
