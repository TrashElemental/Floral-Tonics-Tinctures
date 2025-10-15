package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.util.UtilMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

@Mod.EventBusSubscriber
public class PricklyEffectEvents {

    /**
     * When an entity affected by the Prickly effect takes damage from an attack, the attacker will take
     * damage equal to the level of the effect as retaliation.
     */
    @SubscribeEvent
    public static void PricklyRetaliateDamageEvent(LivingDamageEvent event) {

        LivingEntity target = event.getEntity();
        Entity source = event.getSource().getEntity();
        MobEffect prickly = ModMobEffects.PRICKLY.get();

        if (target.level().isClientSide) return;
        if (!(source instanceof LivingEntity attacker)) return;
        if (!target.hasEffect(prickly)) return;

        MobEffectInstance targetPrickly = target.getEffect(prickly);
        float effectLevel = targetPrickly.getAmplifier() + 1;

        UtilMethods.damageEntity(attacker, DamageTypes.THORNS, effectLevel);

        target.level().playSound(null, target.getX(), target.getY(), target.getZ(),
                SoundEvents.PLAYER_HURT_SWEET_BERRY_BUSH, SoundSource.PLAYERS, 1.0F, 1.0F);

    }

}
