package net.tybie;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tybie.block.Blocks;
import net.tybie.item.Items;
import net.tybie.screen.CuttingTableScreenHandler;

public class leathertweaks implements ModInitializer {

	public static final ScreenHandlerType<CuttingTableScreenHandler> CUTTING_TABLE_SCREEN_HANDLER;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Registry
		Blocks.register();
		Items.register();
	}

	static {
		CUTTING_TABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("leathertweaks", "cutting_table"), CuttingTableScreenHandler::new);
	}
}