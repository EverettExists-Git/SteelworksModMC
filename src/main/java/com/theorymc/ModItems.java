package com.theorymc;

import net.minecraft.world.level.block.Block;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;


import java.util.function.Function;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
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
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_INGOT));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_SWORD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_AXE));
    }

    public static final TagKey<Item> REPAIRS_TUNGSTEN_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Steelworks.id("repairs_tungsten_armor"));
    public static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = TagKey.create(Registries.BLOCK,
            Steelworks.id("incorrect_for_tungsten_tool"));

    public static final ToolMaterial TUNGSTEN_TOOL_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_TUNGSTEN_TOOL,
            1721,
            7.5F,
            1.5F,
            12,
            REPAIRS_TUNGSTEN_ARMOR // NOT PARITY WITH DOCS MISSING TungstenArmorMaterial
    );

    // Item
    public static final Item TUNGSTEN_FRAGMENT = register(ModItemIds.TUNGSTEN_FRAGMENT, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_RAW = register(ModItemIds.TUNGSTEN_RAW, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_INGOT = register(ModItemIds.TUNGSTEN_INGOT, Item::new, new Item.Properties());

    // Tool
    public static final Item TUNGSTEN_PICKAXE = register(
            ModItemIds.TUNGSTEN_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(TUNGSTEN_TOOL_MATERIAL, 3f, -3f)
    );
    public static final Item TUNGSTEN_SWORD = register(
            ModItemIds.TUNGSTEN_SWORD,
            Item::new,
            new Item.Properties().sword(TUNGSTEN_TOOL_MATERIAL, 5.0f, -2.6f)
    );
    public static final Item TUNGSTEN_AXE = register(
            ModItemIds.TUNGSTEN_AXE,
            Item::new,
            new Item.Properties().axe(TUNGSTEN_TOOL_MATERIAL, 7f, -3.2f)
    );
}