package com.github.smallinger.redefinedpipes.network.pipe.energy;

import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import com.github.smallinger.redefinedpipes.network.pipe.PipeFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class EnergyPipeFactory implements PipeFactory {
    @Override
    public Pipe createFromNbt(Level level, CompoundTag tag) {
        BlockPos pos = BlockPos.of(tag.getLong("pos"));
        EnergyPipeType type = EnergyPipeType.get(tag.getInt("type"));
        
        EnergyPipe pipe = new EnergyPipe(level, pos, type);
        pipe.readFromNbt(tag);
        
        return pipe;
    }
} 