package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.floraltonicsandtinctures.jei_recipes.JEIHerbalismRecipeTypeRecipe;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTincturesMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FloralTonicsAndTincturesModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "floral_tonics_and_tinctures");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("jei_herbalism_recipe_type", () -> JEIHerbalismRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}
