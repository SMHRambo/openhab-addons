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
package org.openhab.binding.rollershutterautomation.internal.state;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * State machine for roller shutter status management.
 *
 * @author Gerhard Riegler - Initial contribution
 */
@NonNullByDefault
public class RollerShutterStateMachine {

    public class StateHistoryEntry {

        private State state = State.UNDEFINE;
        private final LocalDateTime date = LocalDateTime.now();

        public StateHistoryEntry(State state) {
            this.state = state;
        }

        public State getState() {
            return state;
        }

        public LocalDateTime getDateTime() {
            return date;
        }

    }

    /**
     * Possible states of a roller shutter.
     */
    public enum State {
        UNDEFINE,
        INIT,
        UP,
        DOWN,
        SHADE,
        RAIN,
        VENTILATE,
        OPEN
    }

    /**
     * Events that can trigger state transitions.
     */
    public enum Event {
        INITIALIZED,
        MOVE_UP,
        MOVE_DOWN,
        ENABLE_SHADE,
        RAIN_DETECTED,
        ENABLE_VENTILATION,
        OPEN_WINDOW,
        RESET
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RollerShutterStateMachine.class);

    private State currentState = State.UNDEFINE;

    private final Map<State, Map<Event, State>> transitions = new EnumMap<>(State.class);

    public RollerShutterStateMachine() {
        initTransitions();
    }

    private void initTransitions() {
        // Initialize all states with empty event maps
        for (State state : State.values()) {
            transitions.put(state, new EnumMap<>(Event.class));
        }

        // UNDEFINE
        addTransition(State.UNDEFINE, Event.INITIALIZED, State.INIT);

        // INIT
        addTransition(State.INIT, Event.MOVE_UP, State.UP);
        addTransition(State.INIT, Event.MOVE_DOWN, State.DOWN);

        // UP
        addTransition(State.UP, Event.MOVE_DOWN, State.DOWN);
        addTransition(State.UP, Event.ENABLE_SHADE, State.SHADE);
        addTransition(State.UP, Event.RAIN_DETECTED, State.RAIN);
        addTransition(State.UP, Event.ENABLE_VENTILATION, State.VENTILATE);
        addTransition(State.UP, Event.OPEN_WINDOW, State.OPEN);

        // DOWN
        addTransition(State.DOWN, Event.MOVE_UP, State.UP);
        addTransition(State.DOWN, Event.ENABLE_SHADE, State.SHADE);
        addTransition(State.DOWN, Event.RAIN_DETECTED, State.RAIN);
        addTransition(State.DOWN, Event.ENABLE_VENTILATION, State.VENTILATE);
        addTransition(State.DOWN, Event.OPEN_WINDOW, State.OPEN);

        // SHADE
        addTransition(State.SHADE, Event.MOVE_UP, State.UP);
        addTransition(State.SHADE, Event.MOVE_DOWN, State.DOWN);
        addTransition(State.SHADE, Event.RAIN_DETECTED, State.RAIN);
        addTransition(State.SHADE, Event.ENABLE_VENTILATION, State.VENTILATE);
        addTransition(State.SHADE, Event.OPEN_WINDOW, State.OPEN);

        // RAIN
        addTransition(State.RAIN, Event.MOVE_UP, State.UP);
        addTransition(State.RAIN, Event.MOVE_DOWN, State.DOWN);

        // VENTILATE
        addTransition(State.VENTILATE, Event.MOVE_UP, State.UP);
        addTransition(State.VENTILATE, Event.MOVE_DOWN, State.DOWN);
        addTransition(State.VENTILATE, Event.RAIN_DETECTED, State.RAIN);

        // OPEN
        addTransition(State.OPEN, Event.MOVE_UP, State.UP);
        addTransition(State.OPEN, Event.MOVE_DOWN, State.DOWN);

        // Global RESET
        for (State state : State.values()) {
            addTransition(state, Event.RESET, State.INIT);
        }
    }

    private void addTransition(State from, Event event, State to) {
        transitions.get(from).put(event, to);
    }

    /**
     * Handles an event and triggers the corresponding state transition.
     *
     * @param event the event to handle
     */
    public synchronized void handleEvent(Event event) {
        State nextState = transitions.getOrDefault(currentState, Map.of()).get(event);

        if (nextState == null) {
            LOGGER.warn("Keine Transition definiert: {} + {}", currentState, event);
            return;
        }

        LOGGER.info("Statewechsel: {} -> {} durch {}", currentState, nextState, event);

        currentState = nextState;

        onEnterState(currentState);
    }

    private void onEnterState(State state) {
        switch (state) {
            case UP -> LOGGER.debug("Rollladen fährt hoch");
            case DOWN -> LOGGER.debug("Rollladen fährt runter");
            case SHADE -> LOGGER.debug("Sonnenschutz aktiv");
            case RAIN -> LOGGER.debug("Regenschutz aktiv");
            case VENTILATE -> LOGGER.debug("Lüftungsposition aktiv");
            case OPEN -> LOGGER.debug("Fenster geöffnet");
            case INIT -> LOGGER.debug("Initialisierung");
            case UNDEFINE -> LOGGER.debug("Unbekannter Zustand");
        }
    }

    /**
     * Returns the current state.
     *
     * @return the current state
     */
    public State getCurrentState() {
        return currentState;
    }
}
