package com.github.smallinger.redefinedpipes.network.pipe.transport.callback;

import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

public interface TransportCallbackFactory {
    @Nullable
    TransportCallback create(CompoundTag tag);
} 