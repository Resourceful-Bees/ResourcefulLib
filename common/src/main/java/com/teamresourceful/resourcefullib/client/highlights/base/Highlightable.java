package com.teamresourceful.resourcefullib.client.highlights.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public interface Highlightable {

    /**
     * @return returns a highlight of a block, null if no special highlight will be applied.
     */
    @Nullable
    Highlight getHighlight(Level level, BlockPos pos, BlockState state);
}
