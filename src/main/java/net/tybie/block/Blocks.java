package net.tybie.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    // Leather Block Code
    public static final Block LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds (BlockSoundGroup.WOOL));

    // Infected Leather Block Code
    public static final Block CRIMSON_LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds (BlockSoundGroup.WOOL));
    public static final Block WARPED_LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds (BlockSoundGroup.WOOL));

    // Registry
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "leather_block"), LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "leather_block"), new BlockItem(LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "crimson_leather_block"), CRIMSON_LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather_block"), new BlockItem(CRIMSON_LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "warped_leather_block"), WARPED_LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather_block"), new BlockItem(WARPED_LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}