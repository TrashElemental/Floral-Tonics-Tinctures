package net.trashelemental.floral_tonics_and_tinctures.compat.JEI;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.HerbalismRecipe;

public class HerbalismJEIRecipeType implements IRecipeCategory<HerbalismRecipe> {
    public static final ResourceLocation UID =
            new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "herbalism");
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/gui/herbalism_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public HerbalismJEIRecipeType(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 81);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.HERBALISM_TABLE.get().asItem()));
    }

    @Override
    public mezz.jei.api.recipe.RecipeType<HerbalismRecipe> getRecipeType() {
        return JEIPlugin.HERBALISM_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.floral_tonics_and_tinctures.herbalism");
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
    public void setRecipe(IRecipeLayoutBuilder builder, HerbalismRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 8, 26).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 32, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 20, 50).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 37).addItemStack(recipe.getResultItem(null));
    }
}
