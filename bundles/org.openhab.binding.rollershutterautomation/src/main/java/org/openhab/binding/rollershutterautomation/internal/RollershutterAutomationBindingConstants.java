/*
 * Copyright (c) 2010-2026 Contributors to the openHAB project
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

    /** Constructor */
    private RollershutterAutomationBindingConstants() {
        throw new IllegalAccessError("Non-instantiable");
    }

    private static final String BINDING_ID = "rollershutterautomation";

    // List of actor Channel ids
    public static final String CHANNEL_ROLLERSHUTTER = "rollershutter";

    // List of sensor Channel ids
    public static final String CHANNEL_AZIMUTH = "azimuth";
    public static final String CHANNEL_ELEVATION = "elevation";
    public static final String CHANNEL_WINDOW = "window";

    // Thing configuration properties
    public static final String LEFT_CONFIG = "left";
    public static final String RIGHT_CONFIG = "right";

    private static final String CONTROLLER = "controller";
    public static final String ROLLERSHUTTER = "rollershutter";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_CONTROLLER = new ThingTypeUID(BINDING_ID, CONTROLLER);
    public static final ThingTypeUID THING_TYPE_ROLLERSHUTTER = new ThingTypeUID(BINDING_ID, ROLLERSHUTTER);

    // events
    public static final String EVENT_START = "START";
    public static final String EVENT_END = "END";

    public static final String EVENT_PERIGEE = "PERIGEE";
    public static final String EVENT_APOGEE = "APOGEE";

    // event channelIds
    public static final String EVENT_CHANNEL_ID_PERIGEE = "perigee#event";
    public static final String EVENT_CHANNEL_ID_APOGEE = "apogee#event";

    public static final String EVENT_CHANNEL_ID_RISE = "rise#event";
    public static final String EVENT_CHANNEL_ID_SET = "set#event";
    public static final String EVENT_CHANNEL_ID_NOON = "noon#event";
    public static final String EVENT_CHANNEL_ID_NIGHT = "night#event";
    public static final String EVENT_CHANNEL_ID_MORNING_NIGHT = "morningNight#event";
    public static final String EVENT_CHANNEL_ID_ASTRO_DAWN = "astroDawn#event";
    public static final String EVENT_CHANNEL_ID_NAUTIC_DAWN = "nauticDawn#event";
    public static final String EVENT_CHANNEL_ID_CIVIL_DAWN = "civilDawn#event";
    public static final String EVENT_CHANNEL_ID_ASTRO_DUSK = "astroDusk#event";
    public static final String EVENT_CHANNEL_ID_NAUTIC_DUSK = "nauticDusk#event";
    public static final String EVENT_CHANNEL_ID_CIVIL_DUSK = "civilDusk#event";
    public static final String EVENT_CHANNEL_ID_EVENING_NIGHT = "eveningNight#event";
    public static final String EVENT_CHANNEL_ID_DAYLIGHT = "daylight#event";

    public static final String CHANNEL_ID_SUN_PHASE_NAME = "phase#name";
}
