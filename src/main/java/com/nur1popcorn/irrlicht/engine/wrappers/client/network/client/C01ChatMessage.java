/*
 * Copyright (C) Keanu Poeschko - All Rights Reserved
 * Unauthorized copying of this file is strictly prohibited
 *
 * Created by Keanu Poeschko <nur1popcorn@gmail.com>, April 2017
 * This file is part of {Irrlicht}.
 *
 * Do not copy or distribute files of {Irrlicht} without permission of {Keanu Poeschko}
 *
 * Permission to use, copy, modify, and distribute my software for
 * educational, and research purposes, without a signed licensing agreement
 * and for free, is hereby granted, provided that the above copyright notice
 * and this paragraph appear in all copies, modifications, and distributions.
 *
 *
 *
 *
 */

package com.nur1popcorn.irrlicht.engine.wrappers.client.network.client;

import com.nur1popcorn.irrlicht.engine.mapper.DiscoveryMethod;
import com.nur1popcorn.irrlicht.engine.mapper.Mapper;
import com.nur1popcorn.irrlicht.engine.wrappers.client.network.Packet;

/**
 * The {@link C01ChatMessage} is a packet sent by the player containing the chat message.
 *
 * @see Packet
 *
 * @author nur1popcorn
 * @since 1.1.0-alpha
 */
public interface C01ChatMessage extends Packet
{
    @DiscoveryMethod(checks = Mapper.DEFAULT | Mapper.FIELD)
    public String getMessage();

    @DiscoveryMethod(checks = Mapper.DEFAULT | Mapper.FIELD)
    public void setMessage(String message);
}
