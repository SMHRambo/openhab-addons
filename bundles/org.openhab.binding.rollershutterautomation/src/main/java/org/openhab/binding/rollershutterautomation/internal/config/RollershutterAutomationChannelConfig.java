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
 * RollershutterAutomation Channel configuration.
 *
 * @author Gerhard Riegler - Initial contribution
 */
@NonNullByDefault
public class RollershutterAutomationChannelConfig {
    public int offset = 0;
    public @Nullable String earliest;
    public @Nullable String latest;
}
