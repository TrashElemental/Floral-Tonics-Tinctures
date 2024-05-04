
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.floraltonicsandtinctures.potion.PurifyingMobEffect;
import net.mcreator.floraltonicsandtinctures.potion.PricklyMobEffect;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> PRICKLY = REGISTRY.register("prickly", () -> new PricklyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PURIFYING = REGISTRY.register("purifying", () -> new PurifyingMobEffect());
}
