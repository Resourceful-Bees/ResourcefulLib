package com.teamresourceful.resourcefullib.client.fluid.neoforge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teamresourceful.resourcefullib.client.fluid.data.ClientFluidProperties;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.textures.FluidSpriteCache;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4f;

public record ResourcefulClientFluidType(ClientFluidProperties properties) implements IClientFluidTypeExtensions {

    @Override
    public @NotNull ResourceLocation getStillTexture() {
        return properties().still(null, null, null);
    }

    @Override
    public @NotNull ResourceLocation getStillTexture(@NotNull FluidStack stack) {
        return properties().still(null, null, stack.getFluid().defaultFluidState());
    }

    @Override
    public @NotNull ResourceLocation getStillTexture(@NotNull FluidState state, @NotNull BlockAndTintGetter getter, @NotNull BlockPos pos) {
        return properties().still(getter, pos, state);
    }

    @Override
    public @NotNull ResourceLocation getFlowingTexture() {
        return properties().flowing(null, null, null);
    }

    @Override
    public @NotNull ResourceLocation getFlowingTexture(@NotNull FluidStack stack) {
        return properties().flowing(null, null, stack.getFluid().defaultFluidState());
    }

    @Override
    public @NotNull ResourceLocation getFlowingTexture(@NotNull FluidState state, @NotNull BlockAndTintGetter getter, @NotNull BlockPos pos) {
        return properties().flowing(getter, pos, state);
    }

    @Override
    public @Nullable ResourceLocation getOverlayTexture() {
        return properties().overlay(null, null, null);
    }

    @Override
    public @NotNull ResourceLocation getOverlayTexture(@NotNull FluidStack stack) {
        return properties().overlay(null, null, stack.getFluid().defaultFluidState());
    }

    @Override
    public @NotNull ResourceLocation getOverlayTexture(@NotNull FluidState state, @NotNull BlockAndTintGetter getter, @NotNull BlockPos pos) {
        return properties().overlay(getter, pos, state);
    }

    @Override
    public void renderOverlay(@NotNull Minecraft mc, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffers) {
        properties().renderOverlay(mc, poseStack, buffers);
    }

    @Override
    public int getTintColor() {
        return properties().tintColor(null, null, null);
    }

    @Override
    public int getTintColor(@NotNull FluidStack stack) {
        return properties().tintColor(null, null, stack.getFluid().defaultFluidState());
    }

    @Override
    public int getTintColor(@NotNull FluidState state, @NotNull BlockAndTintGetter getter, @NotNull BlockPos pos) {
        return properties().tintColor(getter, pos, state);
    }

    @Override
    public boolean renderFluid(@NotNull FluidState fluidState, @NotNull BlockAndTintGetter getter, @NotNull BlockPos pos, @NotNull VertexConsumer vertexConsumer, @NotNull BlockState blockState) {
        if (properties().renderFluid(pos, getter, vertexConsumer, blockState, fluidState, FluidSpriteCache::getSprite)) {
            return true;
        }
        return IClientFluidTypeExtensions.super.renderFluid(fluidState, getter, pos, vertexConsumer, blockState);
    }

    @Override
    public @NotNull Vector4f modifyFogColor(@NotNull Camera camera, float partialTick, @NotNull ClientLevel level, int renderDistance, float darkenWorldAmount, @NotNull Vector4f color) {
        return properties().modifyFogColor(camera, partialTick, level, renderDistance, darkenWorldAmount, color);
    }

    @Override
    public @NotNull FogParameters modifyFogRender(@NotNull Camera camera, FogRenderer.@NotNull FogMode mode, float renderDistance, float partialTick, @NotNull FogParameters parameters) {
        return properties().modifyFogRender(camera, mode, renderDistance, partialTick, parameters);
    }

}
