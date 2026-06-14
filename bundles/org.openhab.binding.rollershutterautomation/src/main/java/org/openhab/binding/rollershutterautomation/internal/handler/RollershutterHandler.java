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

import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.binding.rollershutterautomation.internal.state.RollerShutterStateMachine;
import org.openhab.binding.rollershutterautomation.internal.state.RollerShutterStateMachine.StateHistoryEntry;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.library.types.PercentType;
import org.openhab.core.library.types.RefreshType;
import org.openhab.core.library.types.StopMoveType;
import org.openhab.core.library.types.StringType;
import org.openhab.core.library.types.UpDownType;
import org.openhab.core.thing.ChannelUID;
import org.openhab.core.thing.Thing;
import org.openhab.core.types.Command;

/**
 * The RollershutterHandler is responsible for managing individual roller shutters.
 *
 * @author Gerhard Riegler - Initial contribution
 * @author Amit Kumar Mondal - Implementation to be compliant with ESH Scheduler
 */
@NonNullByDefault
public class RollershutterHandler extends RollershutterAutomationThingHandler {

    @Nullable
    private ControllerHandler controllerHandler;

    private final RollerShutterStateMachine stateMachine = new RollerShutterStateMachine();
    private final LinkedBlockingQueue<StateHistoryEntry> stateHistory = new LinkedBlockingQueue<StateHistoryEntry>(10);

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
        final String channelId = channelUID.getId();

        switch (channelId) {
            case "rollershutter":
                handleRollershutterCommand(channelUID, command);
                break;
            case "sunprotection":
                handleSwitchCommand(channelUID, command);
                break;
            case "rainprotection":
                handleSwitchCommand(channelUID, command);
                break;
            case "openedsensor":
                handleStringCommand(channelUID, command);
                break;
            case "tiltedsensor":
                handleStringCommand(channelUID, command);
                break;
            case "closedsensor":
                handleStringCommand(channelUID, command);
                break;
            default:
                // Unknown channel — ignore
                break;
        }
    }

    private void handleRollershutterCommand(ChannelUID channelUID, Command command) {
        if (command instanceof UpDownType) {
            final boolean up = command == UpDownType.UP;
            // Send up/down logic to your physical device here

            // Update the state back to openHAB
            updateState(channelUID, command);
        } else if (command instanceof PercentType) {
            final PercentType percent = (PercentType) command;
            // Send position logic to your physical device here

            // Update the state back to openHAB
            updateState(channelUID, command);
        } else if (command instanceof StopMoveType) {
            final boolean stop = command == StopMoveType.STOP;
            // Send stop/move logic to your physical device here

            // Update the state back to openHAB
            updateState(channelUID, command);
        } else if (command instanceof RefreshType) {
            // Refresh requested — re-read state from the physical device
            // updateState(channelUID, currentPhysicalState);
        }
    }

    private void handleSwitchCommand(ChannelUID channelUID, Command command) {
        if (command instanceof OnOffType) {
            final boolean turnOn = command == OnOffType.ON;
            // Send turnOn logic to your physical device here

            // Update the state back to openHAB
            updateState(channelUID, command);
        }
    }

    private void handleStringCommand(ChannelUID channelUID, Command command) {
        if (command instanceof StringType) {
            final String value = command.toString();
            // Send value logic to your physical device here

            // Update the state back to openHAB
            updateState(channelUID, command);
        }
    }

    @Override
    public void initialize() {
        stateMachine.handleEvent(RollerShutterStateMachine.Event.INITIALIZED);
    }

    /**
     * Returns the state machine for this roller shutter.
     *
     * @return the state machine
     */
    public RollerShutterStateMachine getStateMachine() {
        return stateMachine;
    }
}
