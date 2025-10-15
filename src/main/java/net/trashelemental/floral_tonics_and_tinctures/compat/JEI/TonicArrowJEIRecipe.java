package net.trashelemental.floral_tonics_and_tinctures.compat.JEI;

import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.List;

public class TonicArrowJEIRecipe {

    public static List<CraftingRecipe> createRecipes(IRecipeRegistration registration) {
        String group = "jei.tonic.arrow";
        Ingredient arrowIngredient = Ingredient.of(Items.ARROW);

        return BuiltInRegistries.POTION.stream()
                .filter(potion -> {
                    if (potion == Potions.EMPTY) return false;

                    ResourceLocation id = BuiltInRegistries.POTION.getKey(potion);
                    String path = id.getPath();

                    if (path.contains("long_") || path.contains("strong_")) return false;
                    if (path.contains("_long") || path.contains("_strong")) return false;

                    if (potion.hasInstantEffects()) return false;

                    if (potion == Potions.AWKWARD ||
                            potion == Potions.MUNDANE ||
                            potion == Potions.THICK ||
                            potion == Potions.WATER ||
                            potion == Potions.TURTLE_MASTER) return false;

                    return true;
                })

                .<CraftingRecipe>map(potion -> {
                    ItemStack tonic = PotionUtils.setPotion(new ItemStack(ModItems.TONIC.get()), potion);
                    ItemStack output = PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW, 4), potion);
                    Ingredient empty = Ingredient.EMPTY;

                    Ingredient tonicIngredient = Ingredient.of(tonic);
                    NonNullList<Ingredient> inputs = NonNullList.of(empty,
                            empty,           arrowIngredient, empty,
                            arrowIngredient, tonicIngredient, arrowIngredient,
                            empty,           arrowIngredient, empty
                    );

                    ResourceLocation id = new ResourceLocation("floral_tonics_and_tinctures",
                            "jei.tonic_arrow." + BuiltInRegistries.POTION.getKey(potion).getPath());

                    return new ShapedRecipe(id, group, CraftingBookCategory.MISC, 3, 3, inputs, output);
                })
                .toList();
    }
}