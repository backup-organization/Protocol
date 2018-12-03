package com.nukkitx.protocol.bedrock.handler;

import com.nukkitx.protocol.bedrock.BedrockPacket;

public interface TailHandler {

    default boolean handle(BedrockPacket packet, boolean packetsHandled) {
        return false;
    }
}