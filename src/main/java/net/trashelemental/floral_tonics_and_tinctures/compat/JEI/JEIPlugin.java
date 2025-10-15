package net.trashelemental.floral_tonics_and_tinctures.compat.JEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.HerbalismRecipe;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipeTypes;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "jei_plugin");
    }

    public static RecipeType<HerbalismRecipe> HERBALISM_RECIPE_TYPE =
            new RecipeType<>(HerbalismJEIRecipeType.UID, HerbalismRecipe.class);

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new HerbalismJEIRecipeType(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        registration.addIngredientInfo(List.of(
                new ItemStack(ModItems.HERBALISM_KIT.get())), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.floral_tonics_and_tinctures.herbalism_kit_info"));
        registration.addIngredientInfo(List.of(
                new ItemStack(ModBlocks.HERBALISM_TABLE.get())), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.floral_tonics_and_tinctures.herbalism_table_info"));

        registration.addRecipes(RecipeTypes.CRAFTING, TonicArrowJEIRecipe.createRecipes(registration));

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null) {
            RecipeManager recipeManager = minecraft.level.getRecipeManager();
            List<HerbalismRecipe> recipes = recipeManager.getAllRecipesFor(ModRecipeTypes.HERBALISM.get());
            registration.addRecipes(HERBALISM_RECIPE_TYPE, recipes);
        }
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.useNbtForSubtypes(ModItems.TONIC.get());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.HERBALISM_TABLE.get().asItem()), HERBALISM_RECIPE_TYPE);
    }

}
