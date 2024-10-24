package com.teamresourceful.resourcefullib.common.fluid.data;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.pathfinder.PathType;

public interface FluidProperties {

    double motionScale();

    boolean canPushEntity();

    boolean canSwim();

    boolean canDrown();

    float fallDistanceModifier();

    boolean canExtinguish();

    boolean canConvertToSource();

    boolean supportsBoating();

    PathType pathType();

    PathType adjacentPathType();

    boolean canHydrate();

    int lightLevel();

    int density();

    int temperature();

    int viscosity();

    Rarity rarity();

    FluidSounds sounds();

    int tickDelay();

    int slopeFindDistance();

    int dropOff();

    float explosionResistance();

    boolean canPlace();

    static Builder builder() {
        return new Builder();
    }

    class Builder {

        private double motionScale = 0.014;
        private boolean canPushEntity = true;
        private boolean canSwim = false;
        private boolean canDrown = true;
        private float fallDistanceModifier = 0.5f;
        private boolean canExtinguish = false;
        private boolean canConvertToSource = true;
        private boolean supportsBoating = false;
        private PathType pathType = PathType.WATER;
        private PathType adjacentPathType = PathType.WATER_BORDER;
        private boolean canHydrate = true;
        private int lightLevel = 0;
        private int density = 1000;
        private int temperature = 300;
        private int viscosity = 1000;
        private Rarity rarity = Rarity.COMMON;
        private final FluidSounds sounds = new FluidSounds();
        private int tickRate = 5;
        private int slopeFindDistance = 4;
        private int dropOff = 1;
        private float explosionResistance = 100.0f;

        private boolean canPlace = true;

        private Builder() {
        }

        public Builder motionScale(double motionScale) {
            this.motionScale = motionScale;
            return this;
        }

        public Builder canPushEntity(boolean canPushEntity) {
            this.canPushEntity = canPushEntity;
            return this;
        }

        public Builder canSwim(boolean canSwim) {
            this.canSwim = canSwim;
            return this;
        }

        public Builder canDrown(boolean canDrown) {
            this.canDrown = canDrown;
            return this;
        }

        public Builder fallDistanceModifier(float fallDistanceModifier) {
            this.fallDistanceModifier = fallDistanceModifier;
            return this;
        }

        public Builder canExtinguish(boolean canExtinguish) {
            this.canExtinguish = canExtinguish;
            return this;
        }

        public Builder canConvertToSource(boolean canConvertToSource) {
            this.canConvertToSource = canConvertToSource;
            return this;
        }

        public Builder supportsBoating(boolean supportsBoating) {
            this.supportsBoating = supportsBoating;
            return this;
        }

        public Builder pathType(PathType pathType) {
            this.pathType = pathType;
            return this;
        }

        public Builder adjacentPathType(PathType adjacentPathType) {
            this.adjacentPathType = adjacentPathType;
            return this;
        }

        public Builder canHydrate(boolean canHydrate) {
            this.canHydrate = canHydrate;
            return this;
        }

        public Builder lightLevel(int lightLevel) {
            this.lightLevel = lightLevel;
            return this;
        }

        public Builder density(int density) {
            this.density = density;
            return this;
        }

        public Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder viscosity(int viscosity) {
            this.viscosity = viscosity;
            return this;
        }

        public Builder rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder sounds(String sound, SoundEvent soundEvent) {
            this.sounds.add(sound, soundEvent);
            return this;
        }

        public Builder tickRate(int tickRate) {
            this.tickRate = tickRate;
            return this;
        }

        public Builder slopeFindDistance(int slopeFindDistance) {
            this.slopeFindDistance = slopeFindDistance;
            return this;
        }

        public Builder dropOff(int dropOff) {
            this.dropOff = dropOff;
            return this;
        }

        public Builder explosionResistance(float explosionResistance) {
            this.explosionResistance = explosionResistance;
            return this;
        }

        public Builder disablePlacing() {
            this.canPlace = false;
            return this;
        }

        public FluidProperties build() {
            return new ImmutableFluidProperties(
                    motionScale, canPushEntity, canSwim, canDrown, fallDistanceModifier,
                    canExtinguish, canConvertToSource, supportsBoating,
                    pathType, adjacentPathType, canHydrate, lightLevel, density,
                    temperature, viscosity, rarity, sounds, tickRate, slopeFindDistance,
                    dropOff, explosionResistance, canPlace
            );
        }
    }
}