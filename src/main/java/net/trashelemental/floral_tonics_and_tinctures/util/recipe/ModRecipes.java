package net.trashelemental.floral_tonics_and_tinctures.util.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<RecipeSerializer<TonicArrowRecipe>> TONIC_ARROW_SERIALIZER =
            SERIALIZERS.register("crafting_tonic_arrow",
                    () -> new SimpleCraftingRecipeSerializer<>(TonicArrowRecipe::new));

    public static final RegistryObject<RecipeSerializer<HerbalismRecipe>> HERBALISM =
            SERIALIZERS.register("herbalism", () -> HerbalismRecipe.Serializer.INSTANCE);

}
