package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.screen.ExtractorAttachmentScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = RedefinedPipes.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RedefinedPipesScreens {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(RedefinedPipesContainerMenus.EXTRACTOR_ATTACHMENT.get(), ExtractorAttachmentScreen::new);
    }
} 