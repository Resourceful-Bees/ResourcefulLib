package com.teamresourceful.resourcefullib.common.registry.builtin;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.teamresourceful.resourcefullib.common.registry.builtin.base.ItemLikeEntry;
import com.teamresourceful.resourcefullib.common.registry.builtin.base.ItemLikeHolderEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class ResourcefulItemRegistry implements ResourcefulRegistry<Item> {

    private final String namespace;
    private final ResourcefulRegistry<Item> registry;

    public ResourcefulItemRegistry(String id) {
        this.namespace = id;
        this.registry = ResourcefulRegistries.create(BuiltInRegistries.ITEM, this.namespace);
    }

    public <I extends Item> ItemLikeEntry<I> register(String id, Function<Item.Properties, I> factory, Supplier<Item.Properties> getter) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(this.namespace, id));
        return this.register(id, () -> factory.apply(getter.get().setId(key)));
    }

    public ItemLikeEntry<BlockItem> register(String id, Supplier<? extends Block> supplier, Supplier<Item.Properties> getter) {
        return register(id, properties -> new BlockItem(supplier.get(), properties), getter);
    }

    @Override
    public <I extends Item> ItemLikeEntry<I> register(String id, Supplier<I> supplier) {
        return new ItemLikeEntry<>(this.registry.register(id, supplier));
    }

    @Override
    public ItemLikeHolderEntry<Item> registerHolder(String id, Supplier<Item> supplier) {
        return new ItemLikeHolderEntry<>(this.registry.registerHolder(id, supplier));
    }

    @Override
    public Collection<RegistryEntry<Item>> getEntries() {
        return this.registry.getEntries();
    }

    @Override
    public void init() {
        this.registry.init();
    }
}
