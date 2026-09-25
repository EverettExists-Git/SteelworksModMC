package com.theorymc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class TungstenArmorMaterial {

    public static final TagKey<Item> REPAIRS_TUNGSTEN_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Steelworks.id("repairs_tungsten_armor"));
    public static final int BASE_DURABILITY = 35;
    public static final ResourceKey<EquipmentAsset> TUNGSTEN_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Steelworks.id("tungsten"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_IRON,
            2.5f,
            0.025f,
            REPAIRS_TUNGSTEN_ARMOR,
            TUNGSTEN_ARMOR_MATERIAL_KEY
    );
}
