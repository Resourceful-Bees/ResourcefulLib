package com.teamresourceful.resourcefullib.common.registry.builtin.base;

import com.teamresourceful.resourcefullib.common.registry.HolderRegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public record ItemLikeHolderEntry<T extends ItemLike>(HolderRegistryEntry<T> entry) implements HolderRegistryEntry<T>, ItemLike {

    @Override
    public Holder<T> holder() {
        return entry.holder();
    }

    @Override
    public ResourceLocation getId() {
        return entry.getId();
    }

    @Override
    @NotNull
    public Item asItem() {
        return get().asItem();
    }

}