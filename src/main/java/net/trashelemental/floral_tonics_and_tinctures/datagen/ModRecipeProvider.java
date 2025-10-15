package net.trashelemental.floral_tonics_and_tinctures.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HERBALISM_KIT.get())
                .pattern("dbd")
                .pattern("aca")
                .pattern("aaa")
                .define('a', Items.LEATHER)
                .define('b', Items.GOLD_INGOT)
                .define('c', ModBlocks.HERBALISM_TABLE.get())
                .define('d', Items.STRING)
                .unlockedBy(getHasName(ModBlocks.HERBALISM_TABLE.get()), has(ModBlocks.HERBALISM_TABLE.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERBALISM_TABLE.get())
                .pattern("bc ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', ItemTags.PLANKS)
                .define('b', Items.BOWL)
                .define('c', ItemTags.FLOWERS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter);

    }

}



