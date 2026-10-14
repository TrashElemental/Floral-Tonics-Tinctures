package net.trashelemental.floral_tonics_and_tinctures.compat.JEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.TonicItem;
import net.trashelemental.floral_tonics_and_tinctures.magic.brewing.ModPotions;

import javax.annotation.Nullable;
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


        ItemStack luckInput = new ItemStack(Items.POTION);
        PotionUtils.setPotion(luckInput, Potions.AWKWARD);
        ItemStack luckOutput = new ItemStack(Items.POTION);
        PotionUtils.setPotion(luckOutput, Potions.LUCK);
        ItemStack tonicOfLuck = ModItems.FOUR_LEAF_CLOVER.get().getDefaultInstance();
        brewingRecipes.add(factory.createBrewingRecipe(List.of(tonicOfLuck), luckInput, luckOutput));


        for (Potion potion : ForgeRegistries.POTIONS) {
            if (potion == Potions.EMPTY) continue;
            ItemStack tonicStack = TonicItem.withEffect(potion);
            ItemStack inputPotion = tonicStack.copy();
            ItemStack ingredient = new ItemStack(Items.NETHER_WART);
            ItemStack outputPotion = new ItemStack(Items.POTION);
            PotionUtils.setPotion(outputPotion, potion);
            brewingRecipes.add(factory.createBrewingRecipe(List.of(ingredient), List.of(inputPotion), outputPotion));
        }

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.FIERY_POTION.get(),
                ModPotions.FIERY_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.FROSTY_POTION.get(),
                ModPotions.FROSTY_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.FLORAL_SCENT_POTION.get(),
                ModPotions.FLORAL_SCENT_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.GOLD_RUSH_POTION.get(),
                ModPotions.GOLD_RUSH_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.MAGIC_RESISTANCE_POTION.get(),
                ModPotions.MAGIC_RESISTANCE_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.PRICKLY_POTION.get(),
                ModPotions.PRICKLY_POTION_LONG.get(),
                ModPotions.PRICKLY_POTION_STRONG.get());

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.PURIFYING_POTION.get(),
                ModPotions.PURIFYING_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.WAYFARING_POTION.get(),
                ModPotions.WAYFARING_LONG.get(),
                null);

        addPotionUpgradeVariants(brewingRecipes, factory,
                ModPotions.RESISTANCE_POTION.get(),
                ModPotions.RESISTANCE_POTION_LONG.get(),
                ModPotions.RESISTANCE_POTION_STRONG.get());

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

    private static void addPotionUpgradeVariants(List<IJeiBrewingRecipe> brewingRecipes, IVanillaRecipeFactory factory,
                                                 Potion basePotion, @Nullable Potion longPotion, @Nullable Potion strongPotion) {
        // Base potion input stack
        ItemStack baseInput = new ItemStack(Items.POTION);
        PotionUtils.setPotion(baseInput, basePotion);

        // Long potion input/output
        if (longPotion != null) {
            ItemStack longOutput = new ItemStack(Items.POTION);
            PotionUtils.setPotion(longOutput, longPotion);
            brewingRecipes.add(factory.createBrewingRecipe(
                    List.of(baseInput.copy()),                  // input potion
                    List.of(new ItemStack(Items.REDSTONE)),    // ingredient
                    longOutput                                  // result
            ));
        }

        // Strong potion input/output
        if (strongPotion != null) {
            ItemStack strongOutput = new ItemStack(Items.POTION);
            PotionUtils.setPotion(strongOutput, strongPotion);
            brewingRecipes.add(factory.createBrewingRecipe(
                    List.of(baseInput.copy()),                  // input potion
                    List.of(new ItemStack(Items.GLOWSTONE_DUST)), // ingredient
                    strongOutput                                // result
            ));
        }
    }
}
