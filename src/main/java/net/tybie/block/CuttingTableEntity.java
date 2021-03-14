package net.tybie.block;

import com.mojang.serialization.MapEncoder;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.tybie.screen.CuttingTableScreenHandler;

public class CuttingTableEntity extends BlockEntity implements Nameable {
    private Text customName;
//ngl, this is a :wa
    public CuttingTableEntity() {
        super(Blocks.CUTTING_TABLE_ENTITY);
    }
//not crashing, good sign:p
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (this.hasCustomName()) {
            tag.putString("CustomName", Text.Serializer.toJson(this.customName));
        }

        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag.contains("CustomName", 8)) {
            this.customName = Text.Serializer.fromJson(tag.getString("CustomName"));
        }
    }



      public Text getName() {
        return (Text)(this.customName != null ? this.customName : new TranslatableText("container.leathertweaks.cutting_table"));
    }

    @Override
    public Text getDisplayName() {
        return null;
    }

    public void setCustomName(Text value) {
        this.customName = value;
    }

    public Text getCustomName() {
        return this.customName;
    }

}