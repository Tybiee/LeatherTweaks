package net.tybie.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tybie.armor.CrimsonLeather;
import net.tybie.armor.WarpedLeather;

public class Items {

    // Infected Leather
    public static final Item CRIMSON_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CRIMSON_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CRIMSON_LEATHER_SHEET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER_SHEET = new Item(new Item.Settings().group(ItemGroup.MISC));

    // Infected Leather Armor
    public static final ArmorMaterial CrimsonLeather = new CrimsonLeather();
    public static final ArmorMaterial WarpedLeather = new WarpedLeather();
    public static final Item CRIMSON_HELMET = new ArmorItem(CrimsonLeather, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_CHESTPLATE = new ArmorItem(CrimsonLeather, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_LEGGINGS = new ArmorItem(CrimsonLeather, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CRIMSON_BOOTS = new ArmorItem(CrimsonLeather, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item WARPED_HELMET = new ArmorItem(WarpedLeather, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item WARPED_CHESTPLATE = new ArmorItem(WarpedLeather, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item WARPED_LEGGINGS = new ArmorItem(WarpedLeather, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item WARPED_BOOTS = new ArmorItem(WarpedLeather, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    // Misc Items
    public static final Item LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item LEATHER_SHEET = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final MushroomStewItem CRIMSON_STEW = new MushroomStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build()));
    public static final MushroomStewItem WARPED_STEW = new MushroomStewItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2F).build()));


    // Registry
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather"), (CRIMSON_LEATHER));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather"), (WARPED_LEATHER));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "leather_strip"), (LEATHER_STRIP));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather_strip"), (CRIMSON_LEATHER_STRIP));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather_strip"), (WARPED_LEATHER_STRIP));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "leather_sheet"), (LEATHER_SHEET));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather_sheet"), (CRIMSON_LEATHER_SHEET));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather_sheet"), (WARPED_LEATHER_SHEET));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_stew"), (CRIMSON_STEW));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_stew"), (WARPED_STEW));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_helmet"), (CRIMSON_HELMET));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_chestplate"), (CRIMSON_CHESTPLATE));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leggings"), (CRIMSON_LEGGINGS));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_boots"), (CRIMSON_BOOTS));

        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_helmet"), (WARPED_HELMET));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_chestplate"), (WARPED_CHESTPLATE));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leggings"), (WARPED_LEGGINGS));
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_boots"), (WARPED_BOOTS));

    }
}