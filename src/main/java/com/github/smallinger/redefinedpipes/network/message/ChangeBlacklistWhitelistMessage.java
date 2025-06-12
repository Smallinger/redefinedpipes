package com.github.smallinger.redefinedpipes.network.message;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import com.github.smallinger.redefinedpipes.blockentity.PipeBlockEntity;
import com.github.smallinger.redefinedpipes.network.NetworkManager;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.Attachment;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.extractor.BlacklistWhitelist;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.extractor.ExtractorAttachment;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ChangeBlacklistWhitelistMessage(BlockPos pos, Direction direction, boolean blacklist) implements CustomPacketPayload {
    
    public static final CustomPacketPayload.Type<ChangeBlacklistWhitelistMessage> TYPE = 
        new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "change_blacklist_whitelist"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ChangeBlacklistWhitelistMessage> STREAM_CODEC = StreamCodec.composite(
        BlockPos.STREAM_CODEC, ChangeBlacklistWhitelistMessage::pos,
        Direction.STREAM_CODEC, ChangeBlacklistWhitelistMessage::direction,
        net.minecraft.network.codec.ByteBufCodecs.BOOL, ChangeBlacklistWhitelistMessage::blacklist,
        ChangeBlacklistWhitelistMessage::new
    );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleServer(final ChangeBlacklistWhitelistMessage message, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() == null || context.player().level() == null) {
                return;
            }

            BlockEntity blockEntity = context.player().level().getBlockEntity(message.pos());

            if (blockEntity instanceof PipeBlockEntity) {
                Attachment attachment = ((PipeBlockEntity) blockEntity).getAttachmentManager().getAttachment(message.direction());

                if (attachment instanceof ExtractorAttachment) {
                    BlacklistWhitelist blacklistWhitelist = message.blacklist() ? BlacklistWhitelist.BLACKLIST : BlacklistWhitelist.WHITELIST;
                    ((ExtractorAttachment) attachment).setBlacklistWhitelist(blacklistWhitelist);

                    NetworkManager.get(blockEntity.getLevel()).setDirty();
                }
            }
        }).exceptionally(e -> {
            context.disconnect(net.minecraft.network.chat.Component.literal("Failed to handle ChangeBlacklistWhitelistMessage: " + e.getMessage()));
            return null;
        });
    }
} 