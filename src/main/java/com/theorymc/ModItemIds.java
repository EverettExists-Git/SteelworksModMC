package com.theorymc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;


public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        // Create Item Key
        return ResourceKey.create(Registries.ITEM, Steelworks.id(name));

    }

    // Item

    public static final ResourceKey<Item> TUNGSTEN_FRAGMENT = create("tungsten_fragment");
    public static final ResourceKey<Item> TUNGSTEN_RAW = create("tungsten_raw");
    public static final ResourceKey<Item> TUNGSTEN_INGOT = create("tungsten_ingot");

    // Tool
    public static final ResourceKey<Item> TUNGSTEN_PICKAXE = create("tungsten_pickaxe");
    public static final ResourceKey<Item> TUNGSTEN_SWORD = create("tungsten_sword");
    public static final ResourceKey<Item> TUNGSTEN_AXE = create("tungsten_axe");
}
