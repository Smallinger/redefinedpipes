package com.github.smallinger.redefinedpipes.network.pipe.attachment.extractor;

import com.github.smallinger.redefinedpipes.block.FluidPipeBlock;
import com.github.smallinger.redefinedpipes.block.ItemPipeBlock;
import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.Attachment;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.AttachmentFactory;
import com.github.smallinger.redefinedpipes.util.DirectionUtil;
import com.github.smallinger.redefinedpipes.util.StringUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ExtractorAttachmentFactory implements AttachmentFactory {
    private final ExtractorAttachmentType type;

    public ExtractorAttachmentFactory(ExtractorAttachmentType type) {
        this.type = type;
    }

    @Override
    public Attachment createFromNbt(Pipe pipe, CompoundTag tag) {
        Direction dir = DirectionUtil.safeGet((byte) tag.getInt("dir"));

        ExtractorAttachment attachment = new ExtractorAttachment(pipe, dir, type);

        if (tag.contains("itemfilter")) {
            attachment.getItemFilter().deserializeNBT(pipe.getLevel().registryAccess(), tag.getCompound("itemfilter"));
        }

        if (tag.contains("rm")) {
            attachment.setRedstoneMode(RedstoneMode.get(tag.getByte("rm")));
        }

        if (tag.contains("bw")) {
            attachment.setBlacklistWhitelist(BlacklistWhitelist.get(tag.getByte("bw")));
        }

        if (tag.contains("rr")) {
            attachment.setRoundRobinIndex(tag.getInt("rr"));
        }

        if (tag.contains("routingm")) {
            attachment.setRoutingMode(RoutingMode.get(tag.getByte("routingm")));
        }

        if (tag.contains("stacksi")) {
            attachment.setStackSize(tag.getInt("stacksi"));
        }

        if (tag.contains("exa")) {
            attachment.setExactMode(tag.getBoolean("exa"));
        }

        if (tag.contains("fluidfilter")) {
            attachment.getFluidFilter().readFromNbt(tag.getCompound("fluidfilter"), pipe.getLevel().registryAccess());
        }

        return attachment;
    }

    @Override
    public Attachment create(Pipe pipe, Direction dir) {
        return new ExtractorAttachment(pipe, dir, type);
    }

    @Override
    public ResourceLocation getItemId() {
        return type.getItemId();
    }

    @Override
    public ResourceLocation getId() {
        return type.getId();
    }

    @Override
    public ResourceLocation getModelLocation() {
        return type.getModelLocation();
    }

    @Override
    public void addInformation(List<Component> tooltip) {
        tooltip.add(Component.translatable("misc.redefinedpipes.tier", Component.translatable("enchantment.level." + type.getTier())).withStyle(ChatFormatting.YELLOW));

        Component itemsToExtract = Component.literal(StringUtil.formatNumber(type.getItemsToExtract()) + " ")
            .append(Component.translatable("misc.refinedpipes.item" + (type.getItemsToExtract() == 1 ? "" : "s")))
            .withStyle(ChatFormatting.WHITE);

        float itemSecondsInterval = type.getItemTickInterval() / 20F;
        Component itemTickInterval = Component.literal(StringUtil.formatNumber(itemSecondsInterval) + " ")
            .append(Component.translatable("misc.refinedpipes.second" + (itemSecondsInterval == 1 ? "" : "s")))
            .withStyle(ChatFormatting.WHITE);

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.extractor_attachment.item_extraction_rate",
            itemsToExtract,
            itemTickInterval
        ).withStyle(ChatFormatting.GRAY));

        Component fluidsToExtract = Component.literal(StringUtil.formatNumber(type.getFluidsToExtract()) + " mB")
            .withStyle(ChatFormatting.WHITE);

        float fluidSecondsInterval = type.getFluidTickInterval() / 20F;
        Component fluidTickInterval = Component.literal(StringUtil.formatNumber(fluidSecondsInterval) + " ")
            .append(Component.translatable("misc.refinedpipes.second" + (fluidSecondsInterval == 1 ? "" : "s")))
            .withStyle(ChatFormatting.WHITE);

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.extractor_attachment.fluid_extraction_rate",
            fluidsToExtract,
            fluidTickInterval
        ).withStyle(ChatFormatting.GRAY));

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.extractor_attachment.filter_slots",
            Component.literal("" + type.getFilterSlots()).withStyle(ChatFormatting.WHITE)
        ).withStyle(ChatFormatting.GRAY));

        addAbilityToInformation(tooltip, type.getCanSetRedstoneMode(), "misc.redefinedpipes.redstone_mode");
        addAbilityToInformation(tooltip, type.getCanSetWhitelistBlacklist(), "misc.redefinedpipes.mode");
        addAbilityToInformation(tooltip, type.getCanSetRoutingMode(), "misc.redefinedpipes.routing_mode");
        addAbilityToInformation(tooltip, type.getCanSetExactMode(), "misc.redefinedpipes.exact_mode");
    }

    private void addAbilityToInformation(List<Component> tooltip, boolean possible, String key) {
        tooltip.add(
            Component.literal(possible ? "✓ " : "❌ ").append(Component.translatable(key))
                .withStyle(possible ? ChatFormatting.GREEN : ChatFormatting.RED)
        );
    }

    @Override
    public boolean canPlaceOnPipe(Block pipe) {
        return pipe instanceof ItemPipeBlock
            || pipe instanceof FluidPipeBlock;
    }
} 