package com.theorymc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;


public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        // Create Item Key
        return ResourceKey.create(Registries.ITEM, Steelworks.id(name));

    }
    public static final ResourceKey<Item> TUNGSTEN_FRAGMENT = create("tungsten_fragment");
    public static final ResourceKey<Item> TUNGSTEN_RAW = create("tungsten_raw");
}
