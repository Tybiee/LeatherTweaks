package net.tybie;

import net.fabricmc.api.ModInitializer;
import net.tybie.block.Blocks;
import net.tybie.item.Items;

public class leathertweaks implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Jamie is an angel. That is a fact.");

		// Registry
		Blocks.register();
		Items.register();
	}
}
