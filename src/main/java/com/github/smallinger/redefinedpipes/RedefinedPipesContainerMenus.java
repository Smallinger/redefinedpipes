package com.github.smallinger.redefinedpipes;

import com.github.smallinger.redefinedpipes.menu.ExtractorAttachmentContainerMenu;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.extractor.*;
import com.github.smallinger.redefinedpipes.util.DirectionUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RedefinedPipesContainerMenus {
    public static final DeferredRegister<MenuType<?>> CONTAINER_MENUS = DeferredRegister.create(Registries.MENU, RedefinedPipes.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<ExtractorAttachmentContainerMenu>> EXTRACTOR_ATTACHMENT = CONTAINER_MENUS.register(
        "extractor_attachment",
        () -> IMenuTypeExtension.create((windowId, inv, data) -> {
            if (data != null) {
                // Server-side data available - use real values
                return new ExtractorAttachmentContainerMenu(
                    windowId,
                    inv.player,
                    data.readBlockPos(),
                    DirectionUtil.safeGet(data.readByte()),
                    RedstoneMode.get(data.readByte()),
                    BlacklistWhitelist.get(data.readByte()),
                    RoutingMode.get(data.readByte()),
                    data.readInt(),
                    data.readBoolean(),
                    ExtractorAttachmentType.get(data.readByte()),
                    ExtractorAttachment.createItemFilterInventory(null),
                    ExtractorAttachment.createFluidFilterInventory(null),
                    data.readBoolean()
                );
            } else {
                // Fallback for client-only constructor
                return new ExtractorAttachmentContainerMenu(windowId, inv.player);
            }
        })
    );
} 