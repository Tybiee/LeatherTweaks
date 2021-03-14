package net.tybie.screen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;

import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.tybie.block.Blocks;
import net.tybie.item.Items;
import net.tybie.leathertweaks;

public class CuttingTableScreenHandler extends ScreenHandler {

    private final ScreenHandlerContext context;
    protected final CraftingResultInventory output;
    private final Inventory inventory;
    private World world;
    private final PlayerEntity player;

    public CuttingTableScreenHandler(int syncId, PlayerInventory playerInventory)  {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public CuttingTableScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(leathertweaks.CUTTING_TABLE_SCREEN_HANDLER, syncId);
        this.player = playerInventory.player;
        this.inventory = new SimpleInventory(1) {
            public void markDirty() {
                super.markDirty();
                CuttingTableScreenHandler.this.onContentChanged(this);
            }
        };
        this.output = new CraftingResultInventory();
        this.context = context;
        this.world = playerInventory.player.world;
        this.addSlot(new Slot(this.inventory, 0, 80, 11) {
        });


        this.addSlot(new Slot(this.output, 0, 80, 59) {
            public boolean canInsert(ItemStack stack) {
                return false;
            }
            public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
                return CuttingTableScreenHandler.this.onTakeOutput(player, stack);
            }
            public boolean canTakeItems(PlayerEntity playerEntity) {
                return true;
            }
        });


        int k;
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }

        for(k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, Blocks.CUTTING_TABLE);
    }

    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return true;
    }


    protected ItemStack onTakeOutput(PlayerEntity player, ItemStack stack) {
        this.output.markDirty();
        ItemStack inputStack = this.inventory.getStack(0);
        ItemStack outputStack = this.output.getStack(0);

        inputStack.decrement(1);
        updateResult(this.syncId, this.world, player, this.inventory, this.output);
        return outputStack;
    }


    protected boolean canUse(BlockState state) {
        return true;
    }


    public void updateResult(int syncId, World world, PlayerEntity player, Inventory inventory, Inventory output)
    {
        ItemStack result = ItemStack.EMPTY;
        if (!world.isClient) {
            ItemStack inputStack = inventory.getStack(0);

            if (!inputStack.isEmpty()) {
                if (inputStack.getItem() == net.minecraft.item.Items.LEATHER) {
                    result = Items.LEATHER_STRIP.getDefaultStack();
                    output.setStack(0, result);
                }
                if (inputStack.getItem() == Items.CRIMSON_LEATHER) {
                    result = Items.CRIMSON_LEATHER_STRIP.getDefaultStack();
                    output.setStack(0, result);
                }
                if (inputStack.getItem() == Items.WARPED_LEATHER) {
                    result = Items.WARPED_LEATHER_STRIP.getDefaultStack();
                    output.setStack(0, result);
                }
                if (inputStack.getItem() == Blocks.LEATHER_BLOCK_ITEM) {
                    result = Items.LEATHER_SHEET.getDefaultStack();
                    output.setStack(0, result);

                }
                if (inputStack.getItem() == Blocks.CRIMSON_LEATHER_BLOCK_ITEM) {
                    result = Items.CRIMSON_LEATHER_SHEET.getDefaultStack();
                    output.setStack(0, result);

                }
                if (inputStack.getItem() == Blocks.WARPED_LEATHER_BLOCK_ITEM) {
                    result = Items.WARPED_LEATHER_SHEET.getDefaultStack();
                    output.setStack(0, result);
                }

            } else {
                output.setStack(0, ItemStack.EMPTY);
            }
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
            serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(syncId, 1, result));
        }
    }

    public void onContentChanged(Inventory inventory) {
        this.context.run((world, blockPos) -> {
            updateResult(this.syncId, world, this.player, this.inventory, this.output);
        });
    }

    public void close(PlayerEntity player) {
        super.close(player);
        this.context.run((world, blockPos) -> {
            this.dropInventory(player, player.world, this.inventory);
        });
    }

    public ItemStack transferSlot(PlayerEntity player, int index) {

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        Slot slotInput = (Slot)this.slots.get(0);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2.copy();
            if (index == 1) {
                if (!this.insertItem(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                //onTakeOutput(this.player, itemStack);
                onContentChanged(this.inventory);
                //updateResult(this.syncId, this.world, player, this.inventory, this.output);
                //slot.onStackChanged(itemStack2, itemStack);

            } else if (index != 1 && index != 0) {
                if (index < 2) {
                    if (!this.insertItem(itemStack2, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 2 && index < 29) {
                    if (!this.insertItem(itemStack2, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 29 && index < 38 && !this.insertItem(itemStack2, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 3, 38, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, itemStack2);
        }

        return itemStack;

    }
}