package net.trashelemental.floral_tonics_and_tinctures.util.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<RecipeType<HerbalismRecipe>> HERBALISM = TYPES.register("herbalism",
            () -> RecipeType.simple(new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "herbalism")));


}
