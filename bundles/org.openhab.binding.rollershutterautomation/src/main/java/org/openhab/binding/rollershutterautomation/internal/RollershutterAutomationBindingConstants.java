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

    // List of all Thing ids
    private static final String CONTROLLER = "controller";
    public static final String ROLLERSHUTTER = "rollershutter";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_CONTROLLER = new ThingTypeUID(BINDING_ID, CONTROLLER);
    public static final ThingTypeUID THING_TYPE_ROLLERSHUTTER = new ThingTypeUID(BINDING_ID, ROLLERSHUTTER);

    // events
    public static final String EVENT_START = "START";
    public static final String EVENT_END = "END";

    public static final String EVENT_OPEN = "OPEN";
    public static final String EVENT_CLOSE = "CLOSE";

    public static final String EVENT_OPENED = "OPENED";
    public static final String EVENT_CLOSED = "CLOSED";
    public static final String EVENT_TILTED = "TILTED";
}
