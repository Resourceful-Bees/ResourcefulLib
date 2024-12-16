package com.teamresourceful.resourcefullib.common.utils.neoforge;

import com.google.gson.JsonObject;
import com.teamresourceful.resourcefullib.common.utils.GenericMemoryPack;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import org.jetbrains.annotations.ApiStatus;

public class HiddenGenericMemoryPack extends GenericMemoryPack {

    @Deprecated
    @ApiStatus.ScheduledForRemoval(inVersion = "1.22")
    protected HiddenGenericMemoryPack(PackType type, String id, JsonObject meta) {
        super(type, id, meta);
    }

    protected HiddenGenericMemoryPack(PackType type, String id, PackMetadataSection meta) {
        super(type, id, meta);
    }

    @Override
    public boolean isHidden() {
        return true;
    }
}
