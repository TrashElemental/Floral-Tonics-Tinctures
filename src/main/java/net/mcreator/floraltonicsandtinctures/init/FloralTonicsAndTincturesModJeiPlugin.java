
package net.mcreator.floraltonicsandtinctures.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.floraltonicsandtinctures.jei_recipes.JEIHerbalismRecipeTypeRecipeCategory;
import net.mcreator.floraltonicsandtinctures.jei_recipes.JEIHerbalismRecipeTypeRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class FloralTonicsAndTincturesModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<JEIHerbalismRecipeTypeRecipe> JEIHerbalismRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(JEIHerbalismRecipeTypeRecipeCategory.UID, JEIHerbalismRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("floral_tonics_and_tinctures:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new JEIHerbalismRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<JEIHerbalismRecipeTypeRecipe> JEIHerbalismRecipeTypeRecipes = recipeManager.getAllRecipesFor(JEIHerbalismRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(JEIHerbalismRecipeType_Type, JEIHerbalismRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(FloralTonicsAndTincturesModBlocks.HERBALISM_TABLE.get().asItem()), JEIHerbalismRecipeType_Type);
	}
}
