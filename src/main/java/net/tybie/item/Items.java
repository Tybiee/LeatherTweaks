package net.tybie.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    // Infected Leather
    public static final Item CRIMSON_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CRIMSON_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item WARPED_LEATHER_STRIP = new Item(new Item.Settings().group(ItemGroup.MISC));

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
    }
}