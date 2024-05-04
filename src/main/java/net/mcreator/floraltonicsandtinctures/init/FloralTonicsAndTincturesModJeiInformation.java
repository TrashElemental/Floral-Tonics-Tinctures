
package net.mcreator.floraltonicsandtinctures.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class FloralTonicsAndTincturesModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("floral_tonics_and_tinctures:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(FloralTonicsAndTincturesModBlocks.HERBALISM_TABLE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.floral_tonics_and_tinctures.jei_herbalism_table_info"));
		registration.addIngredientInfo(List.of(new ItemStack(FloralTonicsAndTincturesModItems.HERBALISM_KIT.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.floral_tonics_and_tinctures.jei_herbalist_kit_info"));
		registration.addIngredientInfo(List.of(new ItemStack(FloralTonicsAndTincturesModItems.FTT_PRICKLY_TONIC.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.floral_tonics_and_tinctures.jei_prickly_info"));
		registration.addIngredientInfo(List.of(new ItemStack(FloralTonicsAndTincturesModItems.FTT_PURIFYING_TONIC.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.floral_tonics_and_tinctures.jei_purifying_info"));
	}
}
