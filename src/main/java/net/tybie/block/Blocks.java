package net.tybie.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {

    // Leather Block Code
    public static final Block LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds (BlockSoundGroup.WOOL));

    public static final Item LEATHER_BLOCK_ITEM = new BlockItem(LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    // Infected Leather Block Code
    public static final Block CRIMSON_LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block WARPED_LEATHER_BLOCK = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.8f).sounds(BlockSoundGroup.WOOL));

    public static final Item CRIMSON_LEATHER_BLOCK_ITEM = new BlockItem(CRIMSON_LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item WARPED_LEATHER_BLOCK_ITEM = new BlockItem(WARPED_LEATHER_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    // Misc Code
    public static final CuttingTable CUTTING_TABLE = new CuttingTable(FabricBlockSettings.of(Material.STONE).strength(1.5f).sounds(BlockSoundGroup.STONE).nonOpaque());

    // Block Entities
    public static BlockEntityType<CuttingTableEntity> CUTTING_TABLE_ENTITY;

    // Registry
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "leather_block"), LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "leather_block"), LEATHER_BLOCK_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "crimson_leather_block"), CRIMSON_LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "crimson_leather_block"), CRIMSON_LEATHER_BLOCK_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "warped_leather_block"), WARPED_LEATHER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "warped_leather_block"), WARPED_LEATHER_BLOCK_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("leathertweaks", "cutting_table"), CUTTING_TABLE);
        Registry.register(Registry.ITEM, new Identifier("leathertweaks", "cutting_table"), new BlockItem(CUTTING_TABLE, new Item.Settings().group(ItemGroup.DECORATIONS)));

        CUTTING_TABLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("leathertweaks", "cutting_table"),
            BlockEntityType.Builder.create(CuttingTableEntity::new, CUTTING_TABLE).build(null));

    }
}