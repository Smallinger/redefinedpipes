package com.github.smallinger.redefinedpipes.network.pipe.item;

import com.github.smallinger.redefinedpipes.network.pipe.Pipe;
import com.github.smallinger.redefinedpipes.network.pipe.PipeFactory;
import com.github.smallinger.redefinedpipes.util.DirectionUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class ItemPipeFactory implements PipeFactory {
    @Override
    public Pipe createFromNbt(Level level, CompoundTag tag) {
        BlockPos pos = BlockPos.of(tag.getLong("pos"));
        ItemPipeType type = ItemPipeType.get(tag.getInt("type"));
        
        ItemPipe pipe = new ItemPipe(level, pos, type);
        pipe.readFromNbt(tag);
        
        return pipe;
    }
} 