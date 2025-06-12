package com.github.smallinger.redefinedpipes.integration.jei;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import com.github.smallinger.redefinedpipes.RedefinedPipesItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JeiPlugin
public class RedefinedPipesJEIPlugin implements IModPlugin {
    private static final Logger LOGGER = LogManager.getLogger(RedefinedPipesJEIPlugin.class);
    
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        // Register any item subtypes if needed
        // For now, Refined Pipes doesn't need special item subtypes
    }

    @Override
    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
        // Register extensions for vanilla categories if needed
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        LOGGER.debug("Registering Refined Pipes ingredient information with JEI");
        
        // Add information about our items to JEI using the correct API
        // According to JEI documentation, addIngredientInfo expects ItemLike and Component...
        
        // Add all our pipe items to JEI's ingredient list
        registration.addIngredientInfo(RedefinedPipesItems.BASIC_ITEM_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.basic_item_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.IMPROVED_ITEM_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.improved_item_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ADVANCED_ITEM_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.advanced_item_pipe.description"));

        registration.addIngredientInfo(RedefinedPipesItems.BASIC_FLUID_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.basic_fluid_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.IMPROVED_FLUID_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.improved_fluid_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ADVANCED_FLUID_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.advanced_fluid_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ELITE_FLUID_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.elite_fluid_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ULTIMATE_FLUID_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.ultimate_fluid_pipe.description"));

        registration.addIngredientInfo(RedefinedPipesItems.BASIC_ENERGY_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.basic_energy_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.IMPROVED_ENERGY_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.improved_energy_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ADVANCED_ENERGY_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.advanced_energy_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ELITE_ENERGY_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.elite_energy_pipe.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ULTIMATE_ENERGY_PIPE.get(), 
            Component.translatable("jei.redefinedpipes.ultimate_energy_pipe.description"));

        // Add extractor attachments
        registration.addIngredientInfo(RedefinedPipesItems.BASIC_EXTRACTOR_ATTACHMENT.get(), 
            Component.translatable("jei.redefinedpipes.basic_extractor_attachment.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.IMPROVED_EXTRACTOR_ATTACHMENT.get(), 
            Component.translatable("jei.redefinedpipes.improved_extractor_attachment.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ADVANCED_EXTRACTOR_ATTACHMENT.get(), 
            Component.translatable("jei.redefinedpipes.advanced_extractor_attachment.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ELITE_EXTRACTOR_ATTACHMENT.get(), 
            Component.translatable("jei.redefinedpipes.elite_extractor_attachment.description"));
            
        registration.addIngredientInfo(RedefinedPipesItems.ULTIMATE_EXTRACTOR_ATTACHMENT.get(), 
            Component.translatable("jei.redefinedpipes.ultimate_extractor_attachment.description"));

        LOGGER.debug("Finished registering Refined Pipes ingredient information with JEI");
        
        // Note: Vanilla crafting recipes should be automatically detected by JEI
        // if they are properly registered in the recipe manager.
        // The recipes are loaded from data/refinedpipes/recipes/*.json files
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        // Register GUI handlers for JEI integration
        // This would be used for recipe transfer handlers, click areas, etc.
        // For now, we don't need special GUI handlers for Refined Pipes
    }
} 