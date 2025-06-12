package com.github.smallinger.redefinedpipes.setup;

import com.github.smallinger.redefinedpipes.RedefinedPipes;
import com.github.smallinger.redefinedpipes.RedefinedPipesBlockEntities;
import com.github.smallinger.redefinedpipes.RedefinedPipesBlocks;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.AttachmentFactory;
import com.github.smallinger.redefinedpipes.network.pipe.attachment.AttachmentRegistry;
import com.github.smallinger.redefinedpipes.network.pipe.energy.EnergyPipeType;
import com.github.smallinger.redefinedpipes.network.pipe.fluid.FluidPipeType;
import com.github.smallinger.redefinedpipes.network.pipe.item.ItemPipeType;
import com.github.smallinger.redefinedpipes.render.FluidPipeBlockEntityRenderer;
import com.github.smallinger.redefinedpipes.render.ItemPipeBlockEntityRenderer;
import com.github.smallinger.redefinedpipes.render.PipeBakedModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ClientSetup {
    private static final Logger LOGGER = LogManager.getLogger(ClientSetup.class);

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Set render layers for pipes to cutout for transparency
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.BASIC_ITEM_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.IMPROVED_ITEM_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ADVANCED_ITEM_PIPE.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.BASIC_FLUID_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.IMPROVED_FLUID_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ADVANCED_FLUID_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ELITE_FLUID_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ULTIMATE_FLUID_PIPE.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.BASIC_ENERGY_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.IMPROVED_ENERGY_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ADVANCED_ENERGY_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ELITE_ENERGY_PIPE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(RedefinedPipesBlocks.ULTIMATE_ENERGY_PIPE.get(), RenderType.cutout());

            // Register block entity renderers
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.BASIC_ITEM_PIPE.get(), ItemPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.IMPROVED_ITEM_PIPE.get(), ItemPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.ADVANCED_ITEM_PIPE.get(), ItemPipeBlockEntityRenderer::new);

            BlockEntityRenderers.register(RedefinedPipesBlockEntities.BASIC_FLUID_PIPE.get(), FluidPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.IMPROVED_FLUID_PIPE.get(), FluidPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.ADVANCED_FLUID_PIPE.get(), FluidPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.ELITE_FLUID_PIPE.get(), FluidPipeBlockEntityRenderer::new);
            BlockEntityRenderers.register(RedefinedPipesBlockEntities.ULTIMATE_FLUID_PIPE.get(), FluidPipeBlockEntityRenderer::new);
        });
    }

    @SubscribeEvent
    public static void registerSpecialModels(ModelEvent.RegisterAdditional event) {
        LOGGER.debug("Registering special models for Refined Pipes");
        
        // Register attachment models using ModelResourceLocation
        for (AttachmentFactory factory : AttachmentRegistry.INSTANCE.all()) {
            LOGGER.debug("Registering attachment model {}", factory.getModelLocation());
            event.register(ModelResourceLocation.standalone(factory.getModelLocation()));
        }

        // Register pipe models for all types using ModelResourceLocation
        for (String type : new String[]{"item", "fluid", "energy"}) {
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/basic/core")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/basic/extension")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/basic/straight")));

            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/improved/core")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/improved/extension")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/improved/straight")));

            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/advanced/core")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/advanced/extension")));
            event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/advanced/straight")));

            if (type.equals("fluid") || type.equals("energy")) {
                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/elite/core")));
                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/elite/extension")));
                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/elite/straight")));

                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/ultimate/core")));
                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/ultimate/extension")));
                event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/ultimate/straight")));
            }
        }

        event.register(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/attachment/inventory_attachment")));
        
        LOGGER.debug("Special models registered successfully");
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult event) {
        LOGGER.debug("Modifying baking result for Refined Pipes");
        
        Map<ResourceLocation, BakedModel> attachmentModels = new HashMap<>();

        // Collect attachment models
        for (AttachmentFactory factory : AttachmentRegistry.INSTANCE.all()) {
            BakedModel model = event.getModels().get(ModelResourceLocation.standalone(factory.getModelLocation()));
            if (model != null) {
                attachmentModels.put(factory.getId(), model);
                LOGGER.debug("Collected attachment model for {}", factory.getId());
            } else {
                LOGGER.warn("Failed to find attachment model for {}", factory.getModelLocation());
            }
        }

        Map<ResourceLocation, PipeBakedModel> pipeModels = new HashMap<>();

        // Create pipe baked models
        createPipeBakedModel(event, pipeModels, attachmentModels, ItemPipeType.BASIC.getId(), "item", "basic");
        createPipeBakedModel(event, pipeModels, attachmentModels, ItemPipeType.IMPROVED.getId(), "item", "improved");
        createPipeBakedModel(event, pipeModels, attachmentModels, ItemPipeType.ADVANCED.getId(), "item", "advanced");

        createPipeBakedModel(event, pipeModels, attachmentModels, FluidPipeType.BASIC.getId(), "fluid", "basic");
        createPipeBakedModel(event, pipeModels, attachmentModels, FluidPipeType.IMPROVED.getId(), "fluid", "improved");
        createPipeBakedModel(event, pipeModels, attachmentModels, FluidPipeType.ADVANCED.getId(), "fluid", "advanced");
        createPipeBakedModel(event, pipeModels, attachmentModels, FluidPipeType.ELITE.getId(), "fluid", "elite");
        createPipeBakedModel(event, pipeModels, attachmentModels, FluidPipeType.ULTIMATE.getId(), "fluid", "ultimate");

        createPipeBakedModel(event, pipeModels, attachmentModels, EnergyPipeType.BASIC.getId(), "energy", "basic");
        createPipeBakedModel(event, pipeModels, attachmentModels, EnergyPipeType.IMPROVED.getId(), "energy", "improved");
        createPipeBakedModel(event, pipeModels, attachmentModels, EnergyPipeType.ADVANCED.getId(), "energy", "advanced");
        createPipeBakedModel(event, pipeModels, attachmentModels, EnergyPipeType.ELITE.getId(), "energy", "elite");
        createPipeBakedModel(event, pipeModels, attachmentModels, EnergyPipeType.ULTIMATE.getId(), "energy", "ultimate");

        // Replace pipe models in the registry
        int replacedModels = 0;
        for (ModelResourceLocation id : event.getModels().keySet()) {
            for (Map.Entry<ResourceLocation, PipeBakedModel> entry : pipeModels.entrySet()) {
                if (isPipeModel(id, entry.getKey())) {
                    event.getModels().put(id, entry.getValue());
                    replacedModels++;
                    // Only log individual replacements in trace mode to avoid spam
                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace("Replaced pipe model for {}", id);
                    }
                }
            }
        }
        
        LOGGER.info("Model baking modification completed - replaced {} pipe model variants", replacedModels);
    }

    private static void createPipeBakedModel(ModelEvent.ModifyBakingResult event, Map<ResourceLocation, PipeBakedModel> pipeModels, 
                                           Map<ResourceLocation, BakedModel> attachmentModels, ResourceLocation pipeId, String type, String tier) {
        BakedModel core = event.getModels().get(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/" + tier + "/core")));
        BakedModel extension = event.getModels().get(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/" + tier + "/extension")));
        BakedModel straight = event.getModels().get(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/" + type + "/" + tier + "/straight")));
        BakedModel inventoryAttachment = event.getModels().get(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(RedefinedPipes.MOD_ID, "block/pipe/attachment/inventory_attachment")));

        if (core != null && extension != null && straight != null && inventoryAttachment != null) {
            pipeModels.put(pipeId, new PipeBakedModel(core, extension, straight, inventoryAttachment, attachmentModels));
            LOGGER.trace("Created PipeBakedModel for {} {} {}", type, tier, pipeId);
        } else {
            LOGGER.warn("Failed to create PipeBakedModel for {} {} {} - missing models: core={}, extension={}, straight={}, inventoryAttachment={}", 
                       type, tier, pipeId, core != null, extension != null, straight != null, inventoryAttachment != null);
        }
    }

    private static boolean isPipeModel(ModelResourceLocation modelId, ResourceLocation pipeId) {
        return modelId.id().getNamespace().equals(RedefinedPipes.MOD_ID)
            && modelId.id().getPath().equals(pipeId.getPath())
            && !modelId.variant().equals("inventory");
    }


} 