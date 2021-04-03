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

import static org.openhab.binding.rollershutterautomation.internal.RollershutterAutomationBindingConstants.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.rollershutterautomation.internal.handler.ControllerHandler;
import org.openhab.binding.rollershutterautomation.internal.handler.RollershutterAutomationThingHandler;
import org.openhab.binding.rollershutterautomation.internal.handler.RollershutterHandler;
import org.openhab.core.config.core.Configuration;
import org.openhab.core.thing.Thing;
import org.openhab.core.thing.ThingTypeUID;
import org.openhab.core.thing.ThingUID;
import org.openhab.core.thing.binding.BaseThingHandlerFactory;
import org.openhab.core.thing.binding.ThingHandler;
import org.openhab.core.thing.binding.ThingHandlerFactory;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link RollershutterAutomationHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
@Component(configurationPid = "binding.rollershutterautomation", service = ThingHandlerFactory.class)
public class RollershutterAutomationHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Set.of(THING_TYPE_CONTROLLER,
            THING_TYPE_ROLLERSHUTTER);
    private static final Map<String, RollershutterAutomationThingHandler> ROLLERSHUTTERAUTOMATION_THING_HANDLERS = new HashMap<>();

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES.contains(thingTypeUID);
    }

    @Override
    public @Nullable Thing createThing(ThingTypeUID thingTypeUID, Configuration configuration,
            @Nullable ThingUID thingUID, @Nullable ThingUID bridgeUID) {
        if (thingTypeUID.equals(THING_TYPE_CONTROLLER)) {
            return super.createThing(thingTypeUID, configuration, thingUID, null);
        } else if (thingTypeUID.equals(THING_TYPE_ROLLERSHUTTER)) {
            return super.createThing(thingTypeUID, configuration, thingUID, bridgeUID);
        }

        return null;
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        RollershutterAutomationThingHandler thingHandler = null;

        if (thingTypeUID.equals(THING_TYPE_CONTROLLER)) {
            thingHandler = new ControllerHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_ROLLERSHUTTER)) {
            thingHandler = new RollershutterHandler(thing);
        }

        if (thingHandler != null) {
            ROLLERSHUTTERAUTOMATION_THING_HANDLERS.put(thing.getUID().toString(), thingHandler);
        }
        return thingHandler;
    }

    @Override
    public void unregisterHandler(Thing thing) {
        super.unregisterHandler(thing);
        ROLLERSHUTTERAUTOMATION_THING_HANDLERS.remove(thing.getUID().toString());
    }

    public static @Nullable RollershutterAutomationThingHandler getHandler(String thingUid) {
        return ROLLERSHUTTERAUTOMATION_THING_HANDLERS.get(thingUid);
    }
}
