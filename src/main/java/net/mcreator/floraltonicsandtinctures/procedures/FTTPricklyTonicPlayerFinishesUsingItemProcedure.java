package net.mcreator.floraltonicsandtinctures.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.floraltonicsandtinctures.init.FloralTonicsAndTincturesModMobEffects;

public class FTTPricklyTonicPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(FloralTonicsAndTincturesModMobEffects.PRICKLY.get(), 1800, 0, false, true));
	}
}
