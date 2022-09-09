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

/**
 * The {@link LEADenergyConfiguration} class contains fields mapping thing configuration parameters.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
public class LEADenergyConfiguration {

    private String host = "";
    private Integer port = LEADenergyBindingConstants.DEFAULTPORT;
    private Integer pollingPeriod = LEADenergyBindingConstants.DEFAULTPOLLINGPERIOD;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPollingPeriod() {
        return pollingPeriod;
    }

    public void setPollingPeriod(Integer pollingPeriod) {
        this.pollingPeriod = pollingPeriod;
    }
}
