
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<Potion, Potion> BLINDNESS = REGISTRY.register("blindness", () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> DECAY = REGISTRY.register("decay", () -> new Potion(new MobEffectInstance(MobEffects.WITHER, 600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> NAUSEA = REGISTRY.register("nausea", () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 1000, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LEVITATION = REGISTRY.register("levitation", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> HASTE = REGISTRY.register("haste", () -> new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> DOLPHINS_GRACE = REGISTRY.register("dolphins_grace", () -> new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 3600, 0, false, true)));
}
