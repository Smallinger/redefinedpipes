package com.github.smallinger.redefinedpipes.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

import javax.annotation.Nonnull;

/**
 * @see <a href="https://github.com/mezz/JustEnoughItems/blob/1.15/src/main/java/mezz/jei/plugins/vanilla/ingredients/fluid/FluidStackRenderer.java">JEI implementation</a>
 */
public class FluidRenderer {
    public static final FluidRenderer INSTANCE = new FluidRenderer(1000, 16, 16, 16);

    private static final int TEX_WIDTH = 16;
    private static final int TEX_HEIGHT = 16;

    private final int capacityMb;
    private final int width;
    private final int height;
    private final int minHeight;

    public FluidRenderer(int capacityMb, int width, int height, int minHeight) {
        this.capacityMb = capacityMb;
        this.width = width;
        this.height = height;
        this.minHeight = minHeight;
    }

    private static TextureAtlasSprite getStillFluidSprite(FluidStack fluidStack) {
        Fluid fluid = fluidStack.getFluid();
        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation fluidStill = extensions.getStillTexture(fluidStack);
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(fluidStill);
    }

    private static void setGLColorFromInt(int color) {
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;
        float alpha = ((color >> 24) & 0xFF) / 255F;

        RenderSystem.setShaderColor(red, green, blue, alpha);
    }

    private static void drawTextureWithMasking(double xCoord, double yCoord, TextureAtlasSprite textureSprite, int maskTop, int maskRight, double zLevel) {
        double uMin = textureSprite.getU0();
        double uMax = textureSprite.getU1();
        double vMin = textureSprite.getV0();
        double vMax = textureSprite.getV1();
        uMax = uMax - (maskRight / 16.0 * (uMax - uMin));
        vMax = vMax - (maskTop / 16.0 * (vMax - vMin));

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferBuilder.addVertex((float) xCoord, (float) (yCoord + 16), (float) zLevel).setUv((float) uMin, (float) vMax);
        bufferBuilder.addVertex((float) (xCoord + 16 - maskRight), (float) (yCoord + 16), (float) zLevel).setUv((float) uMax, (float) vMax);
        bufferBuilder.addVertex((float) (xCoord + 16 - maskRight), (float) (yCoord + maskTop), (float) zLevel).setUv((float) uMax, (float) vMin);
        bufferBuilder.addVertex((float) xCoord, (float) (yCoord + maskTop), (float) zLevel).setUv((float) uMin, (float) vMin);
        BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());
    }

    public void render(final int xPosition, final int yPosition, @Nonnull FluidStack fluidStack) {
        RenderSystem.enableBlend();
        drawFluid(xPosition, yPosition, fluidStack);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.disableBlend();
    }

    private void drawFluid(final int xPosition, final int yPosition, @Nonnull FluidStack fluidStack) {
        if (fluidStack.isEmpty()) {
            return;
        }

        Fluid fluid = fluidStack.getFluid();

        TextureAtlasSprite fluidStillSprite = getStillFluidSprite(fluidStack);

        IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluid);
        int fluidColor = extensions.getTintColor(fluidStack);

        int amount = fluidStack.getAmount();
        int scaledAmount = (amount * height) / capacityMb;
        if (amount > 0 && scaledAmount < minHeight) {
            scaledAmount = minHeight;
        }
        if (scaledAmount > height) {
            scaledAmount = height;
        }

        drawTiledSprite(xPosition, yPosition, width, height, fluidColor, scaledAmount, fluidStillSprite);
    }

    private void drawTiledSprite(final int xPosition, final int yPosition, final int tiledWidth, final int tiledHeight, int color, int scaledAmount, TextureAtlasSprite sprite) {
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);

        setGLColorFromInt(color);

        final int xTileCount = tiledWidth / TEX_WIDTH;
        final int xRemainder = tiledWidth - (xTileCount * TEX_WIDTH);
        final int yTileCount = scaledAmount / TEX_HEIGHT;
        final int yRemainder = scaledAmount - (yTileCount * TEX_HEIGHT);

        final int yStart = yPosition + tiledHeight;

        for (int xTile = 0; xTile <= xTileCount; xTile++) {
            for (int yTile = 0; yTile <= yTileCount; yTile++) {
                int width = (xTile == xTileCount) ? xRemainder : TEX_WIDTH;
                int height = (yTile == yTileCount) ? yRemainder : TEX_HEIGHT;
                int x = xPosition + (xTile * TEX_WIDTH);
                int y = yStart - ((yTile + 1) * TEX_HEIGHT);
                if (width > 0 && height > 0) {
                    int maskTop = TEX_HEIGHT - height;
                    int maskRight = TEX_WIDTH - width;

                    drawTextureWithMasking(x, y, sprite, maskTop, maskRight, 100);
                }
            }
        }
    }
} 