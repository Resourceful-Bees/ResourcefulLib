package com.teamresourceful.resourcefullib.common.utils.types;

import org.jetbrains.annotations.ApiStatus;

/**
 * @deprecated Use {@link net.minecraft.client.renderer.Rect2i} instead.
 */
@Deprecated
@ApiStatus.ScheduledForRemoval(inVersion = "1.21")
public record Bound(int x, int y, int width, int height) {}