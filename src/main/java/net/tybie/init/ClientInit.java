package net.tybie.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.tybie.block.Blocks;
import net.tybie.block.CuttingTableEntity;
import net.tybie.client.gui.screen.ingame.CuttingTableScreen;
import net.tybie.leathertweaks;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CUTTING_TABLE, RenderLayer.getCutout());
        ScreenRegistry.register(leathertweaks.CUTTING_TABLE_SCREEN_HANDLER, CuttingTableScreen::new);
    }
}
