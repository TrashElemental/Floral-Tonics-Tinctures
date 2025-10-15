package net.trashelemental.floral_tonics_and_tinctures.menu.custom.herbalism_kit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.menu.ModMenuTypes;
import net.trashelemental.floral_tonics_and_tinctures.util.ModTags;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipeTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class HerbalismKitMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private final Player player;
    private final Level level;
    private final ItemStackHandler internal = new ItemStackHandler(22) {
        @Override
        protected void onContentsChanged(int slot) {
            if (slot >= 0 && slot <= 2) {
                updateOutput();
            }
        }
    };
    private final ItemStack bagStack;

    @OnlyIn(Dist.CLIENT)
    public HerbalismKitMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, buf.readItem());
    }

    public HerbalismKitMenu(int id, Inventory inv, ItemStack stack) {
        super(ModMenuTypes.HERBALISM_KIT.get(), id);
        this.player = inv.player;
        this.level = inv.player.level();
        this.bagStack = stack;

        if (bagStack.hasTag() && bagStack.getTag().contains("Inventory")) {
            internal.deserializeNBT(bagStack.getTag().getCompound("Inventory"));
        }

        //Input slots
        customSlots.put(0, addSlot(new SlotItemHandler(internal, 0, 17, 66) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(Items.SUGAR) || stack.is(Items.SPIDER_EYE);
            }
        })); //Additive
        customSlots.put(1, addSlot(new SlotItemHandler(internal, 1, 35, 66) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return !stack.is(ModItems.HERBALISM_KIT.get());
            }
        })); //Ingredient
        customSlots.put(2, addSlot(new SlotItemHandler(internal, 2, 26, 84) {
            @Override
            public boolean mayPlace(ItemStack stack) { return stack.is(Items.GLASS_BOTTLE); }
        })); //Bottle
        //Output slot
        customSlots.put(3, addSlot(new SlotItemHandler(internal, 3, 135, 76) {
            @Override
            public boolean mayPlace(ItemStack stack) { return false; }

            @Override
            public void onTake(Player player, ItemStack stack) {
                for (int i = 0; i < 3; i++) {
                    ItemStack input = internal.getStackInSlot(i);
                    if (!input.isEmpty()) {
                        input.shrink(1);
                        internal.setStackInSlot(i, input);
                    }
                }
                updateOutput();
                if (!level.isClientSide()) {
                    level.playSound(null, player.blockPosition(), SoundEvents.BREWING_STAND_BREW,
                            SoundSource.BLOCKS, 1.0f, 1.5f);
                }
                super.onTake(player, stack);
            }
        }));

        //Storage slots
        int[][] positions = {
                {8, 21}, {26, 21}, {44, 21}, {62, 21}, {80, 21}, {98, 21}, {116, 21}, {134, 21}, {152, 21},
                {8, 39}, {26, 39}, {44, 39}, {62, 39}, {80, 39}, {98, 39}, {116, 39}, {134, 39}, {152, 39}
        };

        for (int i = 0; i < positions.length; i++) {
            int index = i + 4;
            int x = positions[i][0];
            int y = positions[i][1];
            addStorageSlot(index, x, y, internal);
        }

        //Player inventory
        int startX = 9, startY = 113;
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                addSlot(new Slot(inv, col + row * 9 + 9, startX + col * 18, startY + row * 18));
        for (int col = 0; col < 9; col++)
            addSlot(new Slot(inv, col, startX + col * 18, startY + 58));
    }

    @Override
    public boolean stillValid(Player player) { return true; }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack movedStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            movedStack = slotStack.copy();

            int kitStart = 0, kitEnd = 21;
            int invStart = 22, invEnd = slots.size() - 1;

            if (index >= kitStart && index <= kitEnd) {
                if (!moveItemStackTo(slotStack, invStart, invEnd + 1, true))
                    return ItemStack.EMPTY;
            } else {
                if (!moveItemStackTo(slotStack, kitStart, kitEnd + 1, false))
                    return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty())
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();

            if (slotStack.getCount() == movedStack.getCount())
                return ItemStack.EMPTY;

            slot.onTake(player, slotStack);
        }

        return movedStack;
    }

    @Override
    public Map<Integer, Slot> get() { return customSlots; }

    @Override
    public void removed(Player player) {
        super.removed(player);
        CompoundTag tag = bagStack.getOrCreateTag();
        tag.put("Inventory", internal.serializeNBT());

        player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 1, 1.5f);
    }

    private Slot addStorageSlot(int index, int x, int y, ItemStackHandler handler) {
        Slot slot = addSlot(new SlotItemHandler(handler, index, x, y) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ModTags.Items.HERBALISM_GUI_ALLOWED);
            }
        });
        customSlots.put(index, slot);
        return slot;
    }

    private void updateOutput() {
        if (level.isClientSide) return;

        SimpleContainer input = new SimpleContainer(3);
        for (int i = 0; i < 3; i++) {
            input.setItem(i, internal.getStackInSlot(i));
        }

        level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.HERBALISM.get()).stream()
                .filter(recipe -> recipe.matches(input, level))
                .findFirst()
                .ifPresentOrElse(
                        recipe -> internal.setStackInSlot(3, recipe.assemble(input, level.registryAccess())),
                        () -> internal.setStackInSlot(3, ItemStack.EMPTY)
                );
    }
}