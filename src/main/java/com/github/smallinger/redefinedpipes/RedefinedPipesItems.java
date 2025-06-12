package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.item.AttachmentItem;
import com.github.smallinger.redefinedpipes.item.BaseBlockItem;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.extractor.ExtractorAttachmentType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RedefinedPipesItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(net.minecraft.core.registries.Registries.ITEM, RedefinedPipes.MOD_ID);

    // Block Items for Pipes
    public static final DeferredHolder<Item, BaseBlockItem> BASIC_ITEM_PIPE = ITEMS.register(
        "basic_item_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.BASIC_ITEM_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> IMPROVED_ITEM_PIPE = ITEMS.register(
        "improved_item_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.IMPROVED_ITEM_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ADVANCED_ITEM_PIPE = ITEMS.register(
        "advanced_item_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ADVANCED_ITEM_PIPE.get())
    );

    public static final DeferredHolder<Item, BaseBlockItem> BASIC_FLUID_PIPE = ITEMS.register(
        "basic_fluid_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.BASIC_FLUID_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> IMPROVED_FLUID_PIPE = ITEMS.register(
        "improved_fluid_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.IMPROVED_FLUID_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ADVANCED_FLUID_PIPE = ITEMS.register(
        "advanced_fluid_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ADVANCED_FLUID_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ELITE_FLUID_PIPE = ITEMS.register(
        "elite_fluid_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ELITE_FLUID_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ULTIMATE_FLUID_PIPE = ITEMS.register(
        "ultimate_fluid_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ULTIMATE_FLUID_PIPE.get())
    );

    public static final DeferredHolder<Item, BaseBlockItem> BASIC_ENERGY_PIPE = ITEMS.register(
        "basic_energy_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.BASIC_ENERGY_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> IMPROVED_ENERGY_PIPE = ITEMS.register(
        "improved_energy_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.IMPROVED_ENERGY_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ADVANCED_ENERGY_PIPE = ITEMS.register(
        "advanced_energy_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ADVANCED_ENERGY_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ELITE_ENERGY_PIPE = ITEMS.register(
        "elite_energy_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ELITE_ENERGY_PIPE.get())
    );
    public static final DeferredHolder<Item, BaseBlockItem> ULTIMATE_ENERGY_PIPE = ITEMS.register(
        "ultimate_energy_pipe", 
        () -> new BaseBlockItem(RedefinedPipesBlocks.ULTIMATE_ENERGY_PIPE.get())
    );

    // Attachment Items
    public static final DeferredHolder<Item, AttachmentItem> BASIC_EXTRACTOR_ATTACHMENT = ITEMS.register(
        "basic_extractor_attachment", 
        () -> new AttachmentItem(ExtractorAttachmentType.BASIC.getFactory())
    );
    public static final DeferredHolder<Item, AttachmentItem> IMPROVED_EXTRACTOR_ATTACHMENT = ITEMS.register(
        "improved_extractor_attachment", 
        () -> new AttachmentItem(ExtractorAttachmentType.IMPROVED.getFactory())
    );
    public static final DeferredHolder<Item, AttachmentItem> ADVANCED_EXTRACTOR_ATTACHMENT = ITEMS.register(
        "advanced_extractor_attachment", 
        () -> new AttachmentItem(ExtractorAttachmentType.ADVANCED.getFactory())
    );
    public static final DeferredHolder<Item, AttachmentItem> ELITE_EXTRACTOR_ATTACHMENT = ITEMS.register(
        "elite_extractor_attachment", 
        () -> new AttachmentItem(ExtractorAttachmentType.ELITE.getFactory())
    );
    public static final DeferredHolder<Item, AttachmentItem> ULTIMATE_EXTRACTOR_ATTACHMENT = ITEMS.register(
        "ultimate_extractor_attachment", 
        () -> new AttachmentItem(ExtractorAttachmentType.ULTIMATE.getFactory())
    );
} 