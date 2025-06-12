package com.github.smallinger.redefinedpipes.network;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public interface NetworkFactory {
    Network create(BlockPos pos);

    Network create(CompoundTag tag);
} 