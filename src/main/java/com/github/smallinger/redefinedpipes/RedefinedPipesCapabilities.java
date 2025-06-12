package com.github.smallinger.redefinedpipes;
import com.github.smallinger.redefinedpipes.blockentity.EnergyPipeBlockEntity;
import com.github.smallinger.redefinedpipes.blockentity.FluidPipeBlockEntity;
import com.github.smallinger.redefinedpipes.blockentity.ItemPipeBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class RedefinedPipesCapabilities {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        // Register Item Handler capabilities for Item Pipes
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            RedefinedPipesBlockEntities.BASIC_ITEM_PIPE.get(),
            ItemPipeBlockEntity::getItemHandler
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            RedefinedPipesBlockEntities.IMPROVED_ITEM_PIPE.get(),
            ItemPipeBlockEntity::getItemHandler
        );
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            RedefinedPipesBlockEntities.ADVANCED_ITEM_PIPE.get(),
            ItemPipeBlockEntity::getItemHandler
        );

        // Register Fluid Handler capabilities for Fluid Pipes
        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            RedefinedPipesBlockEntities.BASIC_FLUID_PIPE.get(),
            FluidPipeBlockEntity::getFluidHandler
        );
        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            RedefinedPipesBlockEntities.IMPROVED_FLUID_PIPE.get(),
            FluidPipeBlockEntity::getFluidHandler
        );
        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            RedefinedPipesBlockEntities.ADVANCED_FLUID_PIPE.get(),
            FluidPipeBlockEntity::getFluidHandler
        );
        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            RedefinedPipesBlockEntities.ELITE_FLUID_PIPE.get(),
            FluidPipeBlockEntity::getFluidHandler
        );
        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            RedefinedPipesBlockEntities.ULTIMATE_FLUID_PIPE.get(),
            FluidPipeBlockEntity::getFluidHandler
        );

        // Register Energy Storage capabilities for Energy Pipes
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            RedefinedPipesBlockEntities.BASIC_ENERGY_PIPE.get(),
            EnergyPipeBlockEntity::getEnergyStorage
        );
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            RedefinedPipesBlockEntities.IMPROVED_ENERGY_PIPE.get(),
            EnergyPipeBlockEntity::getEnergyStorage
        );
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            RedefinedPipesBlockEntities.ADVANCED_ENERGY_PIPE.get(),
            EnergyPipeBlockEntity::getEnergyStorage
        );
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            RedefinedPipesBlockEntities.ELITE_ENERGY_PIPE.get(),
            EnergyPipeBlockEntity::getEnergyStorage
        );
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            RedefinedPipesBlockEntities.ULTIMATE_ENERGY_PIPE.get(),
            EnergyPipeBlockEntity::getEnergyStorage
        );
    }
} 