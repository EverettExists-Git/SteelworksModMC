package com.theorymc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import java.util.function.Function;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings){
        // Create Item Instance
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register Item (NOT LIKE NEOFORGE)
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
        // Easier than Neoforge?
    }
}
