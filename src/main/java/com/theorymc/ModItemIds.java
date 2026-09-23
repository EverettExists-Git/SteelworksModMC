package com.theorymc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;


public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        // Create Item Key
        return ResourceKey.create(Registries.ITEM, Quantum.id(name));
    }
}
