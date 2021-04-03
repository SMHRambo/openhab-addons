/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.rollershutterautomation.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link RollershutterAutomationBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
public class RollershutterAutomationBindingConstants {

    private static final String BINDING_ID = "rollershutterautomation";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_CONTROLLER = new ThingTypeUID(BINDING_ID, "controller");
    public static final ThingTypeUID THING_TYPE_ROLLERSHUTTER = new ThingTypeUID(BINDING_ID, "rollershutter");

    // List of actor Channel ids
    public static final String CHANNEL_ROLLERSHUTTER = "rollershutter";

    // List of sensor Channel ids
    public static final String CHANNEL_AZIMUTH = "azimuth";
    public static final String CHANNEL_ELEVATION = "elevation";
    public static final String CHANNEL_WINDOW = "window";

    // Thing configuration properties
    public static final String LEFT_CONFIG = "left";
    public static final String RIGHT_CONFIG = "right";
}
