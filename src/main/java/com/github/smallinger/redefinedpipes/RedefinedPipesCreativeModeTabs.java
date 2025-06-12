package com.github.smallinger.redefinedpipes;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RedefinedPipesCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedefinedPipes.MOD_ID);

    public static final Supplier<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + RedefinedPipes.MOD_ID + ".main"))
            .icon(() -> new ItemStack(RedefinedPipesItems.BASIC_ITEM_PIPE.get()))
            .displayItems((params, output) -> {
                // Item Pipes
                output.accept(RedefinedPipesItems.BASIC_ITEM_PIPE.get());
                output.accept(RedefinedPipesItems.IMPROVED_ITEM_PIPE.get());
                output.accept(RedefinedPipesItems.ADVANCED_ITEM_PIPE.get());
                
                // Fluid Pipes
                output.accept(RedefinedPipesItems.BASIC_FLUID_PIPE.get());
                output.accept(RedefinedPipesItems.IMPROVED_FLUID_PIPE.get());
                output.accept(RedefinedPipesItems.ADVANCED_FLUID_PIPE.get());
                output.accept(RedefinedPipesItems.ELITE_FLUID_PIPE.get());
                output.accept(RedefinedPipesItems.ULTIMATE_FLUID_PIPE.get());
                
                // Energy Pipes
                output.accept(RedefinedPipesItems.BASIC_ENERGY_PIPE.get());
                output.accept(RedefinedPipesItems.IMPROVED_ENERGY_PIPE.get());
                output.accept(RedefinedPipesItems.ADVANCED_ENERGY_PIPE.get());
                output.accept(RedefinedPipesItems.ELITE_ENERGY_PIPE.get());
                output.accept(RedefinedPipesItems.ULTIMATE_ENERGY_PIPE.get());
                
                // Attachments
                output.accept(RedefinedPipesItems.BASIC_EXTRACTOR_ATTACHMENT.get());
                output.accept(RedefinedPipesItems.IMPROVED_EXTRACTOR_ATTACHMENT.get());
                output.accept(RedefinedPipesItems.ADVANCED_EXTRACTOR_ATTACHMENT.get());
                output.accept(RedefinedPipesItems.ELITE_EXTRACTOR_ATTACHMENT.get());
                output.accept(RedefinedPipesItems.ULTIMATE_EXTRACTOR_ATTACHMENT.get());
            })
            .build()
    );
} 