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

import static java.lang.Math.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.library.types.IncreaseDecreaseType;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.library.types.PercentType;
import org.openhab.core.thing.ChannelUID;
import org.openhab.core.thing.Thing;
import org.openhab.core.thing.ThingStatus;
import org.openhab.core.thing.ThingStatusDetail;
import org.openhab.core.types.Command;
import org.openhab.core.types.RefreshType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link LEADenergySWHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Sascha Marcel Hacker - Initial contribution
 */
@NonNullByDefault
public class LEADenergySWHandler extends LEADenergyHandler {

    private byte[] unknown = { (byte) 0x02, (byte) 0x00 };
    private byte[] brightnessCommand = { (byte) 0x08, (byte) 0x38 };

    private PercentType brightness = PercentType.ZERO;

    private final Logger logger = LoggerFactory.getLogger(LEADenergySWHandler.class);

    public LEADenergySWHandler(Thing thing) {
        super(thing);
    }

    private void setBrightness(byte brightness) throws UnknownHostException, IOException {
        List<byte[]> payload = new ArrayList<byte[]>();
        payload.add(unknown);
        payload.add(brightnessCommand);
        payload.add(new byte[] { brightness });
        super.sendData(payload);
    }

    private void handlePowerCommand(Command command) throws IOException {
        if (command instanceof OnOffType) {
            setPowerstate((OnOffType) command == OnOffType.ON);
        }
    }

    private void handleBrightnessCommand(Command command) throws IOException {
        if (command instanceof PercentType) {
            this.brightness = (PercentType) command;
            setBrightness((byte) (this.brightness.intValue() * 2.55));
        } else if (command instanceof OnOffType) {
            super.setPowerstate((OnOffType) command == OnOffType.ON);
        } else if (command instanceof IncreaseDecreaseType) {
            IncreaseDecreaseType increaseDecreaseType = (IncreaseDecreaseType) command;
            int calcBrightness = ((PercentType) command).intValue();
            if (increaseDecreaseType.equals(IncreaseDecreaseType.INCREASE)) {
                calcBrightness = max(min(calcBrightness + 1, 0), 100);
                this.brightness = new PercentType(calcBrightness);
            } else {
                calcBrightness = max(min(calcBrightness - 1, 0), 100);
                this.brightness = new PercentType(calcBrightness);
            }
            setBrightness((byte) (this.brightness.intValue() * 2.55));
        }
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("Handle command '{}' for {}", command, channelUID);

        try {
            if (command == RefreshType.REFRESH) {
                super.update();
            } else if (channelUID.getId().equals(LEADenergyBindingConstants.CHANNEL_POWER)) {
                handlePowerCommand(command);
            } else if (channelUID.getId().equals(LEADenergyBindingConstants.CHANNEL_BRIGHTNESS)) {
                handleBrightnessCommand(command);
            }
        } catch (IOException e) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.OFFLINE.COMMUNICATION_ERROR, e.getMessage());
        }
    }
}
