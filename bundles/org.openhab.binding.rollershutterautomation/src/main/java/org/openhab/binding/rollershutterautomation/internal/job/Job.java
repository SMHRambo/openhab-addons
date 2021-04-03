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
package org.openhab.binding.rollershutterautomation.internal.job;

import static org.openhab.binding.rollershutterautomation.internal.RollershutterAutomationBindingConstants.*;
import static org.openhab.binding.rollershutterautomation.internal.util.DateTimeUtils.*;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.rollershutterautomation.internal.handler.ControllerHandler;
import org.openhab.core.scheduler.SchedulerRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The interface to be implemented by classes which represent a 'job' to be performed
 *
 * @author Amit Kumar Mondal - Initial contribution
 */
@NonNullByDefault
public interface Job extends SchedulerRunnable, Runnable {

    /** Logger Instance */
    public final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Schedules the provided {@link Job} instance
     *
     * @param thingUID the UID of the Thing instance
     * @param astroHandler the {@link ControllerHandler} instance
     * @param job the {@link Job} instance to schedule
     * @param eventAt the {@link Calendar} instance denoting scheduled instant
     */
    public static void schedule(String thingUID, ControllerHandler astroHandler, Job job, Calendar eventAt) {
    }

    /**
     * Returns the thing UID that is associated with this {@link Job} (cannot be {@code null})
     */
    public String getThingUID();
}
