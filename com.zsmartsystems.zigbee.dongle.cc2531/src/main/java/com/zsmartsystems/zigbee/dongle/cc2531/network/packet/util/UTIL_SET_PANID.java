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
package com.zsmartsystems.zigbee.dongle.cc2531.network.packet.util;

import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolCMD;
import com.zsmartsystems.zigbee.dongle.cc2531.network.packet.ZToolPacket;
import com.zsmartsystems.zigbee.dongle.cc2531.zigbee.util.DoubleByte;

/**
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 */
public class UTIL_SET_PANID extends ZToolPacket/* implements IREQUEST,ISYSTEM */ {
    /// <name>TI.ZPI1.SYS_SET_PANID.PanID</name>
    /// <summary>PanID.</summary>
    public DoubleByte PanID;

    /// <name>TI.ZPI1.SYS_SET_PANID</name>
    /// <summary>Constructor</summary>
    public UTIL_SET_PANID() {
    }

    /// <name>TI.ZPI1.SYS_SET_PANID</name>
    /// <summary>Constructor</summary>
    public UTIL_SET_PANID(DoubleByte num1) {
        this.PanID = num1;

        int[] framedata = new int[1];
        framedata[0] = this.PanID.getMsb();
        framedata[1] = this.PanID.getLsb();

        super.buildPacket(new DoubleByte(ZToolCMD.UTIL_SET_PANID), framedata);
    }

    public UTIL_SET_PANID(int[] framedata) {
        this.PanID = new DoubleByte(framedata[1], framedata[0]);

        super.buildPacket(new DoubleByte(ZToolCMD.UTIL_SET_PANID), framedata);
    }
}
