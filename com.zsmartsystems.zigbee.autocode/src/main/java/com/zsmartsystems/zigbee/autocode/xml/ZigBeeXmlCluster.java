/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.autocode.xml;

import java.util.List;

/**
 *
 * @author Chris Jackson (zsmartsystems.com)
 *
 */
public class ZigBeeXmlCluster {
    public String name;
    public Integer code;
    public List<ZigBeeXmlDescription> description;
    public List<ZigBeeXmlCommand> commands;
    public List<ZigBeeXmlAttribute> attributes;
    public List<ZigBeeXmlConstant> constants;
    public List<ZigBeeXmlStructure> structures;
    public ZigBeeXmlScenes scenes;
}
