package net.trashelemental.floral_tonics_and_tinctures.compat.JEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.TonicItem;
import net.trashelemental.floral_tonics_and_tinctures.magic.brewing.ModPotions;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("deprecation")
@JeiPlugin
public class JEIBrewingRecipes implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation("infested:brewing_recipes");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();

        List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();


        addPotionRecipesWithAllVariants(brewingRecipes, factory,
                Items.WITHER_SKELETON_SKULL,
                ModPotions.WITHER_POTION.get(),
                ModPotions.WITHER_POTION_LONG.get(),
                ModPotions.WITHER_POTION_STRONG.get()
        );

        addPotionRecipesWithAllVariants(brewingRecipes, factory,
                Items.CHORUS_FLOWER,
                ModPotions.LEVITATION_POTION.get(),
                ModPotions.LEVITATION_POTION_LONG.get(),
                ModPotions.LEVITATION_POTION_STRONG.get()
        );

        addPotionRecipesWithAllVariants(brewingRecipes, factory,
                Items.GOLDEN_APPLE,
                ModPotions.HASTE_POTION.get(),
                ModPotions.HASTE_POTION_LONG.get(),
                ModPotions.HASTE_POTION_STRONG.get()
        );

        addPotionRecipesWithLongVariant(brewingRecipes, factory,
                Items.SCULK,
                ModPotions.BLINDNESS_POTION.get(),
                ModPotions.BLINDNESS_POTION_LONG.get()
        );

        addPotionRecipesWithLongVariant(brewingRecipes, factory,
                Items.NAUTILUS_SHELL,
                ModPotions.DOLPHINS_GRACE_POTION.get(),
                ModPotions.DOLPHINS_GRACE_POTION_LONG.get()
        );

        addPotionRecipesWithLongVariant(brewingRecipes, factory,
                Items.WARPED_WART_BLOCK,
                ModPotions.NAUSEA_POTION.get(),
                ModPotions.NAUSEA_POTION_LONG.get()
        );

        addPotionRecipesWithLongVariant(brewingRecipes, factory,
                Items.GLOW_INK_SAC,
                ModPotions.GLOWING_POTION.get(),
                ModPotions.GLOWING_POTION_LONG.get()
        );

        //Luck potion from tonic.
        ItemStack inputPotion = new ItemStack(Items.POTION);
        PotionUtils.setPotion(inputPotion, Potions.AWKWARD);
        ItemStack outputPotion = new ItemStack(Items.POTION);
        PotionUtils.setPotion(outputPotion, Potions.LUCK);
        ItemStack tonicOfLuck = TonicItem.withEffect(Potions.LUCK);
        brewingRecipes.add(factory.createBrewingRecipe(List.of(tonicOfLuck), inputPotion, outputPotion));

        registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
    }

    private static void addPotionRecipesWithAllVariants(List<IJeiBrewingRecipe> brewingRecipes, IVanillaRecipeFactory factory,
            Item baseIngredient, Potion basePotion, Potion longPotion, Potion strongPotion) {
        ItemStack potion = new ItemStack(Items.POTION);
        ItemStack potion2 = new ItemStack(Items.POTION);
        List<ItemStack> ingredientStack = new ArrayList<>();

        ingredientStack.add(new ItemStack(baseIngredient));
        PotionUtils.setPotion(potion, Potions.AWKWARD);
        PotionUtils.setPotion(potion2, basePotion);
        brewingRecipes.add(factory.createBrewingRecipe(
                List.copyOf(ingredientStack),
                potion.copy(),
                potion2.copy()
        ));

        ingredientStack.clear();
        ingredientStack.add(new ItemStack(Items.REDSTONE));
        PotionUtils.setPotion(potion, basePotion);
        PotionUtils.setPotion(potion2, longPotion);
        brewingRecipes.add(factory.createBrewingRecipe(
                List.copyOf(ingredientStack),
                potion.copy(),
                potion2.copy()
        ));

        ingredientStack.clear();
        ingredientStack.add(new ItemStack(Items.GLOWSTONE_DUST));
        PotionUtils.setPotion(potion, basePotion);
        PotionUtils.setPotion(potion2, strongPotion);
        brewingRecipes.add(factory.createBrewingRecipe(
                List.copyOf(ingredientStack),
                potion.copy(),
                potion2.copy()
        ));
    }

    private static void addPotionRecipesWithLongVariant(List<IJeiBrewingRecipe> brewingRecipes, IVanillaRecipeFactory factory,
            Item baseIngredient, Potion basePotion, Potion longPotion) {
        ItemStack potion = new ItemStack(Items.POTION);
        ItemStack potion2 = new ItemStack(Items.POTION);
        List<ItemStack> ingredientStack = new ArrayList<>();

        ingredientStack.add(new ItemStack(baseIngredient));
        PotionUtils.setPotion(potion, Potions.AWKWARD);
        PotionUtils.setPotion(potion2, basePotion);
        brewingRecipes.add(factory.createBrewingRecipe(
                List.copyOf(ingredientStack),
                potion.copy(),
                potion2.copy()
        ));

        ingredientStack.clear();
        ingredientStack.add(new ItemStack(Items.REDSTONE));
        PotionUtils.setPotion(potion, basePotion);
        PotionUtils.setPotion(potion2, longPotion);
        brewingRecipes.add(factory.createBrewingRecipe(
                List.copyOf(ingredientStack),
                potion.copy(),
                potion2.copy()
        ));
    }

}
