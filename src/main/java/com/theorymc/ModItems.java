package com.theorymc;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
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
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_FRAGMENT));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_RAW));
    }

    public static final Item TUNGSTEN_FRAGMENT = register(ModItemIds.TUNGSTEN_FRAGMENT, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_RAW = register(ModItemIds.TUNGSTEN_RAW, Item::new, new Item.Properties());
}
