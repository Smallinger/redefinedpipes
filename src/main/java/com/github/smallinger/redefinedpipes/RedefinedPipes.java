package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.config.ServerConfig;
import com.github.smallinger.redefinedpipes.network.RedefinedPipesNetwork;
import com.github.smallinger.redefinedpipes.setup.ClientSetup;
import com.github.smallinger.redefinedpipes.setup.CommonSetup;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;

@Mod(RedefinedPipes.MOD_ID)
public class RedefinedPipes {
    public static final String MOD_ID = "redefinedpipes";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    public RedefinedPipes(IEventBus modEventBus, ModContainer modContainer) {
        // Register DeferredRegisters
        RedefinedPipesBlocks.BLOCKS.register(modEventBus);
        RedefinedPipesItems.ITEMS.register(modEventBus);
        RedefinedPipesBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        RedefinedPipesContainerMenus.CONTAINER_MENUS.register(modEventBus);
        RedefinedPipesCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Client-only setup
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.register(ClientSetup.class);
        }

        // Register server config
        modContainer.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

        // Register networking
        modEventBus.addListener(RedefinedPipesNetwork::register);

        // Register capabilities
        modEventBus.addListener(RedefinedPipesCapabilities::registerCapabilities);

        // Register mod event listeners
        modEventBus.addListener(CommonSetup::onConstructMod);
        modEventBus.addListener(CommonSetup::onCommonSetup);

        // Register forge event listeners
        NeoForge.EVENT_BUS.addListener(CommonSetup::onLevelTick);
    }
} 