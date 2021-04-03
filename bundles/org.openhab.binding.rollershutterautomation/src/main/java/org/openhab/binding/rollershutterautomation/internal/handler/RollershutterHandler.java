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
package org.openhab.binding.rollershutterautomation.internal.handler;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ChannelUID;
import org.openhab.core.thing.Thing;
import org.openhab.core.types.Command;

/**
 * The ControllerHandler is responsible for updating calculated sun data.
 *
 * @author Gerhard Riegler - Initial contribution
 * @author Amit Kumar Mondal - Implementation to be compliant with ESH Scheduler
 */
@NonNullByDefault
public class RollershutterHandler extends RollershutterAutomationThingHandler {

    /**
     * Constructor
     */
    public RollershutterHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
    }

    @Override
    public void initialize() {
    }
}
