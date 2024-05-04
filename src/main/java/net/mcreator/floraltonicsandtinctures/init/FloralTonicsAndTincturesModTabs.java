
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FLORAL_TONICS_AND_TINCTURES = REGISTRY.register("floral_tonics_and_tinctures", () -> CreativeModeTab.builder()
			.title(Component.translatable("item_group.floral_tonics_and_tinctures.floral_tonics_and_tinctures")).icon(() -> new ItemStack(FloralTonicsAndTincturesModItems.HERBALISM_KIT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FloralTonicsAndTincturesModBlocks.HERBALISM_TABLE.get().asItem());
				tabData.accept(FloralTonicsAndTincturesModItems.HERBALISM_KIT.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_INVISIBILITY_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_FIRE_RESISTANCE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_SWIFTNESS_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_REGENERATION_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_NIGHT_VISION_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_LEAPING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_WATER_BREATHING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_LUCK_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_STRENGTH_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_SLOW_FALLING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_DOLPHINS_GRACE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_GLOWING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_HASTE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_WEAKNESS_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_SLOWNESS_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_POISON_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_DECAY_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_BLINDNESS_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_LEVITATION_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_NAUSEA_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_PRICKLY_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_PURIFYING_TONIC.get());
			})

			.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FLORAL_TONICS_COMPAT = REGISTRY.register("floral_tonics_compat", () -> CreativeModeTab.builder()
			.title(Component.translatable("item_group.floral_tonics_and_tinctures.floral_tonics_compat")).icon(() -> new ItemStack(FloralTonicsAndTincturesModItems.COMPAT_ICON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_SPELL_DAMAGE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_MANA_REGEN_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_DEEPSIGHT_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_RAGE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_BUG_PHEROMONES_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_KNOCKBACK_RESISTANCE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_RAMPAGE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_INTOXICATION_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_ARMOR_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_DAMAGE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_PINT_CHARISMA.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_HEALING_TOUCH.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_TOXIC_TOUCH.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_PROTECTION_OF_THE_HIVE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_PARALYZED_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_SUNSCREEN_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_THIRD_EYE_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_VIBING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_REPELLENCE_TINCTURE.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_AGILITY_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_BERSERKING_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_HARMONY_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_VANILLA_SCENT_TONIC.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_NEAPOLITAN_INSTANT_HEALTH_1.get());
				tabData.accept(FloralTonicsAndTincturesModItems.FTT_NEAPOLITAN_INSTANT_HEALTH_2.get());
			})

			.build());
}
