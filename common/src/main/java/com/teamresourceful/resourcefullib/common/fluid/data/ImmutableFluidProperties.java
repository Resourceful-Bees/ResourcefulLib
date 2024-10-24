package com.teamresourceful.resourcefullib.common.fluid.data;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.pathfinder.PathType;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public record ImmutableFluidProperties(
        double motionScale,
        boolean canPushEntity,
        boolean canSwim,
        boolean canDrown,
        float fallDistanceModifier,
        boolean canExtinguish,
        boolean canConvertToSource,
        boolean supportsBoating,
        PathType pathType,
        PathType adjacentPathType,
        boolean canHydrate,
        int lightLevel,
        int density,
        int temperature,
        int viscosity,
        Rarity rarity,
        FluidSounds sounds,
        int tickDelay,
        int slopeFindDistance,
        int dropOff,
        float explosionResistance,
        boolean canPlace
) implements FluidProperties {


}
