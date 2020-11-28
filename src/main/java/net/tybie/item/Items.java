package net.tybie.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tybie.armor.CrimsonLeather;

public class Items {

    // Infected Leather
    public static final Item CRIMSON_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CRIMSON_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));

    // Infected Leather Armor
    public static final ArmorMaterial customArmorMaterial = new CrimsonLeather();
    public static final Item CRIMSON_HELMET = new ArmorItem(customArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_CHESTPLATE = new ArmorItem(customArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_LEGGINGS = new ArmorItem(customArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_BOOTS = new ArmorItem(customArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    // Misc Items
    public static final Item LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final MushroomStewItem CRIMSON_STEW = new MushroomStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build()));
    public static final MushroomStewItem WARPED_STEW = new MushroomStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build()));


    // Registry
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather"), (CRIMSON_LEATHER));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather"), (WARPED_LEATHER));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "leather_strip"), (LEATHER_STRIP));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather_strip"), (CRIMSON_LEATHER_STRIP));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather_strip"), (WARPED_LEATHER_STRIP));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_stew"), (CRIMSON_STEW));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_stew"), (WARPED_STEW));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_helmet"), (CRIMSON_HELMET));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_chestplate"), (CRIMSON_CHESTPLATE));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leggings"), (CRIMSON_LEGGINGS));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_boots"), (CRIMSON_BOOTS));

    }
}