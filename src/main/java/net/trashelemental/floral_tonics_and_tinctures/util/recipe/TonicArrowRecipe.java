package net.trashelemental.floral_tonics_and_tinctures.util.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

public class TonicArrowRecipe extends CustomRecipe implements CraftingRecipe {
    public TonicArrowRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingContainer inv, Level level) {
        ItemStack tonic = ItemStack.EMPTY;
        int arrowCount = 0;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack.isEmpty()) continue;

            if (stack.is(ModItems.TONIC.get())) {
                if (!tonic.isEmpty()) return false;
                tonic = stack;
            } else if (stack.is(Items.ARROW)) {
                arrowCount++;
            } else {
                return false;
            }
        }

        if (tonic.isEmpty() || arrowCount != 4) {
            return false;
        }

        return PotionUtils.getPotion(tonic) != Potions.EMPTY;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv, RegistryAccess registryAccess) {
        ItemStack tonic = ItemStack.EMPTY;

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack.is(ModItems.TONIC.get())) {
                tonic = stack;
                break;
            }
        }

        if (tonic.isEmpty()) return ItemStack.EMPTY;

        Potion potion = PotionUtils.getPotion(tonic);
        if (potion == Potions.EMPTY) return ItemStack.EMPTY;
        ItemStack result = new ItemStack(Items.TIPPED_ARROW, 4);
        PotionUtils.setPotion(result, potion);
        return result;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer inv) {
        NonNullList<ItemStack> list = NonNullList.withSize(inv.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < list.size(); ++i) {
            ItemStack stack = inv.getItem(i);
            if (stack.is(ModItems.TONIC.get())) {
                list.set(i, new ItemStack(Items.GLASS_BOTTLE));
            } else if (stack.hasCraftingRemainingItem()) {
                list.set(i, stack.getCraftingRemainingItem());
            }
        }

        return list;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 5;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TONIC_ARROW_SERIALIZER.get();
    }

}
