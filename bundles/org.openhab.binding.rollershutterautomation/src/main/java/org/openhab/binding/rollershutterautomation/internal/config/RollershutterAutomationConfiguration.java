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
package org.openhab.binding.rollershutterautomation.internal.config;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The {@link RollershutterAutomationConfiguration} class contains fields mapping thing configuration parameters.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
public class RollershutterAutomationConfiguration {

    // Sun protection settings
    public boolean sunprotectionEnabled = false;
    public int sunElevationAngle = 45;
    public int sunAzimuthAngleLeft = 180;
    public int sunAzimuthAngleRight = 180;

    // Rain protection settings
    public boolean rainprotectionEnabled = false;

    // Trigger settings
    public @Nullable String rollershutterclosing = "off";
    public @Nullable String rollershutteropening = "off";

    /**
     * Returns true if sun protection is enabled.
     */
    public boolean isSunprotectionEnabled() {
        return sunprotectionEnabled;
    }

    /**
     * Returns true if rain protection is enabled.
     */
    public boolean isRainprotectionEnabled() {
        return rainprotectionEnabled;
    }

    /**
     * Returns the rollershutter closing trigger type.
     */
    public @Nullable String getRollershutterclosing() {
        return rollershutterclosing;
    }

    /**
     * Returns the rollershutter opening trigger type.
     */
    public @Nullable String getRollershutteropening() {
        return rollershutteropening;
    }
}
