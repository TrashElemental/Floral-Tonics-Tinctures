
package net.mcreator.floraltonicsandtinctures.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.floraltonicsandtinctures.init.FloralTonicsAndTincturesModJeiPlugin;
import net.mcreator.floraltonicsandtinctures.init.FloralTonicsAndTincturesModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class JEIHerbalismRecipeTypeRecipeCategory implements IRecipeCategory<JEIHerbalismRecipeTypeRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("floral_tonics_and_tinctures", "jei_herbalism_recipe_type");
	public final static ResourceLocation TEXTURE = new ResourceLocation("floral_tonics_and_tinctures", "textures/screens/jeirecipetexture.png");
	private final IDrawable background;
	private final IDrawable icon;

	public JEIHerbalismRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 81);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FloralTonicsAndTincturesModBlocks.HERBALISM_TABLE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<JEIHerbalismRecipeTypeRecipe> getRecipeType() {
		return FloralTonicsAndTincturesModJeiPlugin.JEIHerbalismRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Herbalism");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, JEIHerbalismRecipeTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 26).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 32, 26).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 20, 50).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 37).addItemStack(recipe.getResultItem(null));
	}
}
