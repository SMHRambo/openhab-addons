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
package org.openhab.binding.leadenergy.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link LEADenergyBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
public class LEADenergyBindingConstants {

    private static final String BINDING_ID = "leadenergy";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_SW = new ThingTypeUID(BINDING_ID, "SW");
    public static final ThingTypeUID THING_TYPE_PDW = new ThingTypeUID(BINDING_ID, "PDW");
    public static final ThingTypeUID THING_TYPE_PDC = new ThingTypeUID(BINDING_ID, "PDC");

    // List of thing Parameters names
    public static final String PARAMETER_HOST = "host";
    public static final String PARAMETER_PORT = "port";
    public static final String PARAMETER_POLLINGPERIOD = "pollingPeriod";

    // List of all Channel ids
    public static final String CHANNEL_POWER = "power";
    public static final String CHANNEL_BRIGHTNESS = "brightness";
    public static final String CHANNEL_COLOR_TEMPERATURE = "color-temperature";
    public static final String CHANNEL_COLOR = "color";
    public static final String CHANNEL_WHITE = "white";

    public static final Integer DEFAULTPORT = 8899;
    public static final Integer DEFAULTPOLLINGPERIOD = 30;
}
