
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.registries.Registries;

import net.mcreator.floraltonicsandtinctures.enchantment.FloralGiftEnchantment;
import net.mcreator.floraltonicsandtinctures.enchantment.AlchemizedEnchantment;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<Enchantment, Enchantment> FLORAL_GIFT = REGISTRY.register("floral_gift", () -> new FloralGiftEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> ALCHEMIZED = REGISTRY.register("alchemized", () -> new AlchemizedEnchantment());
}
