package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.blockentity.EnergyPipeBlockEntity;
import com.github.smallinger.redefinedpipes.blockentity.FluidPipeBlockEntity;
import com.github.smallinger.redefinedpipes.blockentity.ItemPipeBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RedefinedPipesBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, RedefinedPipes.MOD_ID);

    // Item Pipe Block Entities
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ItemPipeBlockEntity>> BASIC_ITEM_PIPE = BLOCK_ENTITIES.register(
        "basic_item_pipe",
        () -> BlockEntityType.Builder.of(
            ItemPipeBlockEntity::new,
            RedefinedPipesBlocks.BASIC_ITEM_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ItemPipeBlockEntity>> IMPROVED_ITEM_PIPE = BLOCK_ENTITIES.register(
        "improved_item_pipe",
        () -> BlockEntityType.Builder.of(
            ItemPipeBlockEntity::new,
            RedefinedPipesBlocks.IMPROVED_ITEM_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ItemPipeBlockEntity>> ADVANCED_ITEM_PIPE = BLOCK_ENTITIES.register(
        "advanced_item_pipe",
        () -> BlockEntityType.Builder.of(
            ItemPipeBlockEntity::new,
            RedefinedPipesBlocks.ADVANCED_ITEM_PIPE.get()
        ).build(null)
    );

    // Fluid Pipe Block Entities
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidPipeBlockEntity>> BASIC_FLUID_PIPE = BLOCK_ENTITIES.register(
        "basic_fluid_pipe",
        () -> BlockEntityType.Builder.of(
            FluidPipeBlockEntity::new,
            RedefinedPipesBlocks.BASIC_FLUID_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidPipeBlockEntity>> IMPROVED_FLUID_PIPE = BLOCK_ENTITIES.register(
        "improved_fluid_pipe",
        () -> BlockEntityType.Builder.of(
            FluidPipeBlockEntity::new,
            RedefinedPipesBlocks.IMPROVED_FLUID_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidPipeBlockEntity>> ADVANCED_FLUID_PIPE = BLOCK_ENTITIES.register(
        "advanced_fluid_pipe",
        () -> BlockEntityType.Builder.of(
            FluidPipeBlockEntity::new,
            RedefinedPipesBlocks.ADVANCED_FLUID_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidPipeBlockEntity>> ELITE_FLUID_PIPE = BLOCK_ENTITIES.register(
        "elite_fluid_pipe",
        () -> BlockEntityType.Builder.of(
            FluidPipeBlockEntity::new,
            RedefinedPipesBlocks.ELITE_FLUID_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidPipeBlockEntity>> ULTIMATE_FLUID_PIPE = BLOCK_ENTITIES.register(
        "ultimate_fluid_pipe",
        () -> BlockEntityType.Builder.of(
            FluidPipeBlockEntity::new,
            RedefinedPipesBlocks.ULTIMATE_FLUID_PIPE.get()
        ).build(null)
    );

    // Energy Pipe Block Entities
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyPipeBlockEntity>> BASIC_ENERGY_PIPE = BLOCK_ENTITIES.register(
        "basic_energy_pipe",
        () -> BlockEntityType.Builder.of(
            EnergyPipeBlockEntity::new,
            RedefinedPipesBlocks.BASIC_ENERGY_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyPipeBlockEntity>> IMPROVED_ENERGY_PIPE = BLOCK_ENTITIES.register(
        "improved_energy_pipe",
        () -> BlockEntityType.Builder.of(
            EnergyPipeBlockEntity::new,
            RedefinedPipesBlocks.IMPROVED_ENERGY_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyPipeBlockEntity>> ADVANCED_ENERGY_PIPE = BLOCK_ENTITIES.register(
        "advanced_energy_pipe",
        () -> BlockEntityType.Builder.of(
            EnergyPipeBlockEntity::new,
            RedefinedPipesBlocks.ADVANCED_ENERGY_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyPipeBlockEntity>> ELITE_ENERGY_PIPE = BLOCK_ENTITIES.register(
        "elite_energy_pipe",
        () -> BlockEntityType.Builder.of(
            EnergyPipeBlockEntity::new,
            RedefinedPipesBlocks.ELITE_ENERGY_PIPE.get()
        ).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyPipeBlockEntity>> ULTIMATE_ENERGY_PIPE = BLOCK_ENTITIES.register(
        "ultimate_energy_pipe",
        () -> BlockEntityType.Builder.of(
            EnergyPipeBlockEntity::new,
            RedefinedPipesBlocks.ULTIMATE_ENERGY_PIPE.get()
        ).build(null)
    );
} 