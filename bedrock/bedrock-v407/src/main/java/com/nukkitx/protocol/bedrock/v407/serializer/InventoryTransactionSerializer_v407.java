package com.nukkitx.protocol.bedrock.v407.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.BedrockPacketHelper;
import com.nukkitx.protocol.bedrock.BedrockSession;
import com.nukkitx.protocol.bedrock.data.inventory.*;
import com.nukkitx.protocol.bedrock.packet.InventoryTransactionPacket;
import com.nukkitx.protocol.bedrock.v340.serializer.InventoryTransactionSerializer_v340;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryTransactionSerializer_v407 extends InventoryTransactionSerializer_v340 {
    public static final InventoryTransactionSerializer_v407 INSTANCE = new InventoryTransactionSerializer_v407();

    private boolean hasNetworkIds;
    @Override
    public void serialize(ByteBuf buffer, BedrockPacketHelper helper, InventoryTransactionPacket packet, BedrockSession session) {
        int legacyRequestId = packet.getLegacyRequestId();
        VarInts.writeInt(buffer, legacyRequestId);

        if (legacyRequestId < -1 && (legacyRequestId & 1) == 0) {
            helper.writeArray(buffer, packet.getLegacySlots(), (buf, packetHelper, data) -> {
                buf.writeByte(data.getContainerId());
                packetHelper.writeByteArray(buf, data.getSlots());
            });
        }

        TransactionType transactionType = packet.getTransactionType();
        VarInts.writeUnsignedInt(buffer, transactionType.ordinal());

        buffer.writeBoolean(packet.isHasNetworkIds());
        helper.writeArray(buffer, packet.getActions(), (buf, action) -> this.writeAction(buf, helper, action, session));

        switch (transactionType) {
            case ITEM_USE:
                this.writeItemUse(buffer, helper, packet, session);
                break;
            case ITEM_USE_ON_ENTITY:
                this.writeItemUseOnEntity(buffer, helper, packet, session);
                break;
            case ITEM_RELEASE:
                this.writeItemRelease(buffer, helper, packet, session);
                break;
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockPacketHelper helper, InventoryTransactionPacket packet, BedrockSession session) {
        int legacyRequestId = VarInts.readInt(buffer);
        packet.setLegacyRequestId(legacyRequestId);

        if (legacyRequestId < -1 && (legacyRequestId & 1) == 0) {
            helper.readArray(buffer, packet.getLegacySlots(), (buf, packetHelper) -> {
                byte containerId = buf.readByte();
                byte[] slots = packetHelper.readByteArray(buf);
                return new LegacySetItemSlotData(containerId, slots);
            });
        }

        TransactionType transactionType = TransactionType.values()[VarInts.readUnsignedInt(buffer)];
        packet.setTransactionType(transactionType);
        hasNetworkIds = buffer.readBoolean();
        packet.setHasNetworkIds(hasNetworkIds);
        helper.readArray(buffer, packet.getActions(), buf -> this.readAction(buf, helper, session));

        switch (transactionType) {
            case ITEM_USE:
                this.readItemUse(buffer, helper, packet, session);
                break;
            case ITEM_USE_ON_ENTITY:
                this.readItemUseOnEntity(buffer, helper, packet, session);
                break;
            case ITEM_RELEASE:
                this.readItemRelease(buffer, helper, packet, session);
                break;
        }
    }

    @Override
    public InventoryActionData readAction(ByteBuf buffer, BedrockPacketHelper helper, BedrockSession session) {
        InventorySource source = this.readSource(buffer);
        int slot = VarInts.readUnsignedInt(buffer);
        ItemData fromItem = helper.readItem(buffer, session);
        ItemData toItem = helper.readItem(buffer, session);
        int networkStackId = 0;
        if (hasNetworkIds) {
            networkStackId = VarInts.readInt(buffer);
        }
        return new InventoryActionData(source, slot, fromItem, toItem, networkStackId);
    }

    @Override
    public void writeAction(ByteBuf buffer, BedrockPacketHelper helper, InventoryActionData action, BedrockSession session) {
        super.writeAction(buffer, helper, action, session);
        if (hasNetworkIds) {
            VarInts.writeInt(buffer, action.getStackNetworkId());
        }
    }
}
