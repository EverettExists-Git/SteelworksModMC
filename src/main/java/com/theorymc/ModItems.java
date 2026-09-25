package com.theorymc;

import net.minecraft.world.item.equipment.ArmorType;
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
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_SHOVEL));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_HOE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_BOOTS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
                .register((creativeTab) -> creativeTab.accept(ModItems.TUNGSTEN_LEGGINGS));
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
            TungstenArmorMaterial.REPAIRS_TUNGSTEN_ARMOR
    );

    // Item
    public static final Item TUNGSTEN_FRAGMENT = register(ModItemIds.TUNGSTEN_FRAGMENT, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_RAW = register(ModItemIds.TUNGSTEN_RAW, Item::new, new Item.Properties());
    public static final Item TUNGSTEN_INGOT = register(ModItemIds.TUNGSTEN_INGOT, Item::new, new Item.Properties());

    // Tool
    public static final Item TUNGSTEN_PICKAXE = register(
            ModItemIds.TUNGSTEN_PICKAXE,
            Item::new,
            new Item.Properties()
                    .pickaxe(TUNGSTEN_TOOL_MATERIAL, 3f, -3f)
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_SWORD = register(
            ModItemIds.TUNGSTEN_SWORD,
            Item::new,
            new Item.Properties()
                    .sword(TUNGSTEN_TOOL_MATERIAL, 5.0f, -2.6f)
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_AXE = register(
            ModItemIds.TUNGSTEN_AXE,
            Item::new,
            new Item.Properties()
                    .axe(TUNGSTEN_TOOL_MATERIAL, 7f, -3.2f)
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_SHOVEL = register(
            ModItemIds.TUNGSTEN_SHOVEL,
            Item::new,
            new Item.Properties()
                    .shovel(TUNGSTEN_TOOL_MATERIAL, 3.5f, -3.2f)
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_HOE = register(
            ModItemIds.TUNGSTEN_HOE,
            Item::new,
            new Item.Properties()
                    .hoe(TUNGSTEN_TOOL_MATERIAL, 0f, -1.2f)
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    // Armor

    public static final Item TUNGSTEN_HELMET = register(
            ModItemIds.TUNGSTEN_HELMET,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(TungstenArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(TungstenArmorMaterial.BASE_DURABILITY))
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_CHESTPLATE = register(
            ModItemIds.TUNGSTEN_CHESTPLATE,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(TungstenArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(TungstenArmorMaterial.BASE_DURABILITY))
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_LEGGINGS = register(
            ModItemIds.TUNGSTEN_LEGGINGS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(TungstenArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(TungstenArmorMaterial.BASE_DURABILITY))
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );
    public static final Item TUNGSTEN_BOOTS = register(
            ModItemIds.TUNGSTEN_BOOTS,
            Item::new,
            new Item.Properties()
                    .humanoidArmor(TungstenArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(TungstenArmorMaterial.BASE_DURABILITY))
                    .enchantable(TUNGSTEN_TOOL_MATERIAL.enchantmentValue())
    );

}