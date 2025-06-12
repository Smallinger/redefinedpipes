package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.block.EnergyPipeBlock;
import com.github.smallinger.redefinedpipes.block.FluidPipeBlock;
import com.github.smallinger.redefinedpipes.block.ItemPipeBlock;
import com.github.smallinger.redefinedpipes.network.pipe.energy.EnergyPipeType;
import com.github.smallinger.redefinedpipes.network.pipe.fluid.FluidPipeType;
import com.github.smallinger.redefinedpipes.network.pipe.item.ItemPipeType;
import com.github.smallinger.redefinedpipes.network.pipe.shape.PipeShapeCache;
import com.github.smallinger.redefinedpipes.network.pipe.shape.PipeShapeFactory;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RedefinedPipesBlocks {
    private static final PipeShapeCache PIPE_SHAPE_CACHE = new PipeShapeCache(new PipeShapeFactory());
    
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RedefinedPipes.MOD_ID);

    // Item Pipes
    public static final DeferredBlock<ItemPipeBlock> BASIC_ITEM_PIPE = BLOCKS.register(
        "basic_item_pipe", 
        () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.BASIC)
    );
    public static final DeferredBlock<ItemPipeBlock> IMPROVED_ITEM_PIPE = BLOCKS.register(
        "improved_item_pipe", 
        () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.IMPROVED)
    );
    public static final DeferredBlock<ItemPipeBlock> ADVANCED_ITEM_PIPE = BLOCKS.register(
        "advanced_item_pipe", 
        () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.ADVANCED)
    );

    // Fluid Pipes
    public static final DeferredBlock<FluidPipeBlock> BASIC_FLUID_PIPE = BLOCKS.register(
        "basic_fluid_pipe", 
        () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.BASIC)
    );
    public static final DeferredBlock<FluidPipeBlock> IMPROVED_FLUID_PIPE = BLOCKS.register(
        "improved_fluid_pipe", 
        () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.IMPROVED)
    );
    public static final DeferredBlock<FluidPipeBlock> ADVANCED_FLUID_PIPE = BLOCKS.register(
        "advanced_fluid_pipe", 
        () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ADVANCED)
    );
    public static final DeferredBlock<FluidPipeBlock> ELITE_FLUID_PIPE = BLOCKS.register(
        "elite_fluid_pipe", 
        () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ELITE)
    );
    public static final DeferredBlock<FluidPipeBlock> ULTIMATE_FLUID_PIPE = BLOCKS.register(
        "ultimate_fluid_pipe", 
        () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ULTIMATE)
    );

    // Energy Pipes
    public static final DeferredBlock<EnergyPipeBlock> BASIC_ENERGY_PIPE = BLOCKS.register(
        "basic_energy_pipe", 
        () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.BASIC)
    );
    public static final DeferredBlock<EnergyPipeBlock> IMPROVED_ENERGY_PIPE = BLOCKS.register(
        "improved_energy_pipe", 
        () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.IMPROVED)
    );
    public static final DeferredBlock<EnergyPipeBlock> ADVANCED_ENERGY_PIPE = BLOCKS.register(
        "advanced_energy_pipe", 
        () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ADVANCED)
    );
    public static final DeferredBlock<EnergyPipeBlock> ELITE_ENERGY_PIPE = BLOCKS.register(
        "elite_energy_pipe", 
        () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ELITE)
    );
    public static final DeferredBlock<EnergyPipeBlock> ULTIMATE_ENERGY_PIPE = BLOCKS.register(
        "ultimate_energy_pipe", 
        () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ULTIMATE)
    );
} 