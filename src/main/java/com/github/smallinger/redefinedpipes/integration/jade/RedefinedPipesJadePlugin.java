package com.github.smallinger.redefinedpipes.integration.jade;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import com.github.smallinger.redefinedpipes.block.EnergyPipeBlock;
import com.github.smallinger.redefinedpipes.blockentity.EnergyPipeBlockEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class RedefinedPipesJadePlugin implements IWailaPlugin {
    
    public static final ResourceLocation ENERGY_PIPE_INFO = ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "energy_pipe_info");

    @Override
    public void register(IWailaCommonRegistration registration) {
        // Register server data providers
        registration.registerBlockDataProvider(EnergyPipeComponentProvider.INSTANCE, EnergyPipeBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        // Register component providers for client-side display
        registration.registerBlockComponent(EnergyPipeComponentProvider.INSTANCE, EnergyPipeBlock.class);
    }
} 