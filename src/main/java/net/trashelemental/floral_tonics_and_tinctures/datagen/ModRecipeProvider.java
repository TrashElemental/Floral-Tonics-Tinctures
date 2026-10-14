package net.trashelemental.floral_tonics_and_tinctures.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERBALISM_TABLE.get())
                .pattern("bc ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', ItemTags.PLANKS)
                .define('b', Items.BOWL)
                .define('c', ItemTags.SMALL_FLOWERS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter, new ResourceLocation("floral_tonics_tinctures", "herbalism_table_fallback_small_flowers"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERBALISM_TABLE.get())
                .pattern("bc ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', ItemTags.PLANKS)
                .define('b', Items.BOWL)
                .define('c', ItemTags.TALL_FLOWERS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter, new ResourceLocation("floral_tonics_tinctures", "herbalism_table_fallback_tall_flowers"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HERBALISM_TABLE.get())
                .pattern("bc ")
                .pattern("aa ")
                .pattern("aa ")
                .define('a', ItemTags.PLANKS)
                .define('b', Items.BOWL)
                .define('c', Items.DANDELION)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter, new ResourceLocation("floral_tonics_tinctures", "herbalism_table_fallback_dandelion"));



        //Flowers into Dye and other items
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 1)
                .requires(ModBlocks.FIRE_LILY.get())
                .unlockedBy(getHasName(ModBlocks.FIRE_LILY.get()), has(ModBlocks.FIRE_LILY.get()))
                .save(pWriter, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "orange_dye_from_fire_lily"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE, 1)
                .requires(ModBlocks.HEATHER.get())
                .unlockedBy(getHasName(ModBlocks.HEATHER.get()), has(ModBlocks.HEATHER.get()))
                .save(pWriter, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "pink_dye_from_heather"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE, 1)
                .requires(ModBlocks.MILKWEED.get())
                .unlockedBy(getHasName(ModBlocks.MILKWEED.get()), has(ModBlocks.MILKWEED.get()))
                .save(pWriter, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "white_dye_from_milkweed"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLD_NUGGET, 1)
                .requires(ModBlocks.MIDAS_FINGERS.get())
                .unlockedBy(getHasName(ModBlocks.MIDAS_FINGERS.get()), has(ModBlocks.MIDAS_FINGERS.get()))
                .save(pWriter, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "gold_nugget_from_midas_fingers"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGMA_CREAM, 1)
                .requires(ModBlocks.LAVADROP.get())
                .unlockedBy(getHasName(ModBlocks.LAVADROP.get()), has(ModBlocks.LAVADROP.get()))
                .save(pWriter, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "magma_cream_from_lavadrop"));


    }

}



