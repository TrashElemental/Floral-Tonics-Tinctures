package net.trashelemental.floral_tonics_and_tinctures.menu.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.menu.ModMenuTypes;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipeTypes;

public class HerbalismTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final ItemStackHandler handler;

    public HerbalismTableMenu(int id, Inventory playerInv, ContainerLevelAccess access) {
        super(ModMenuTypes.HERBALISM_TABLE.get(), id);
        this.access = access;
        this.handler = new ItemStackHandler(4) {
            @Override
            protected void onContentsChanged(int slot) {
                if (slot == 3) return;
                access.execute((level, pos) -> HerbalismTableMenu.this.updateOutput(level));
            }
        };

        // Input slots

        //Additive
        this.addSlot(new SlotItemHandler(handler, 0, 8, 26) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Items.SUGAR) || stack.is(Items.SPIDER_EYE);
            }
        });

        //Ingredient
        this.addSlot(new SlotItemHandler(handler, 1, 32, 26) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return !stack.is(ModItems.HERBALISM_KIT.get());
            }
        });

        //Bottle
        this.addSlot(new SlotItemHandler(handler, 2, 20, 50) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Items.GLASS_BOTTLE);
            }
        });

        //Output slot
        this.addSlot(new SlotItemHandler(handler, 3, 140, 37) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                for (int i = 0; i < 3; i++) {
                    ItemStack input = handler.getStackInSlot(i);
                    if (!input.isEmpty()) {
                        input.shrink(1);
                        handler.setStackInSlot(i, input);
                    }
                }

                access.execute((level, pos) -> {
                    updateOutput(level);

                    if (!level.isClientSide()) {
                        level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0f,1.5f);
                    }
                });

                super.onTake(player, stack);
            }
        });

        addPlayerInventory(playerInv);
    }

    private void addPlayerInventory(Inventory inv) {
        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 9; ++col)
                addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
        for (int col = 0; col < 9; ++col)
            addSlot(new Slot(inv, col, 8 + col * 18, 142));
    }

    private void updateOutput(Level level) {
        if (level.isClientSide) return;

        SimpleContainer input = new SimpleContainer(handler.getSlots());
        for (int i = 0; i < handler.getSlots(); i++) {
            input.setItem(i, handler.getStackInSlot(i));
        }

        level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.HERBALISM.get()).stream()
                .filter(recipe -> recipe.matches(input, level))
                .findFirst()
                .ifPresentOrElse(
                        recipe -> handler.setStackInSlot(3, recipe.assemble(input, level.registryAccess())),
                        () -> handler.setStackInSlot(3, ItemStack.EMPTY)
                );
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ModBlocks.HERBALISM_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            result = stackInSlot.copy();

            if (index == 3) {
                if (!moveItemStackTo(stackInSlot, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stackInSlot, result);
            }
            else if (index >= 0 && index <= 2) {
                if (!moveItemStackTo(stackInSlot, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (index >= 4) {
                if (stackInSlot.is(Items.SUGAR) || stackInSlot.is(Items.SPIDER_EYE)) {
                    if (!moveItemStackTo(stackInSlot, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (stackInSlot.is(Items.GLASS_BOTTLE)) {
                    if (!moveItemStackTo(stackInSlot, 2, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (!moveItemStackTo(stackInSlot, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (stackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (stackInSlot.getCount() == result.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, stackInSlot);
        }

        return result;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!player.level().isClientSide) {
            for (int i = 0; i < 3; i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    if (!player.getInventory().add(stack)) {
                        player.drop(stack, false);
                    }
                    handler.setStackInSlot(i, ItemStack.EMPTY);
                }
            }
        }
    }
}