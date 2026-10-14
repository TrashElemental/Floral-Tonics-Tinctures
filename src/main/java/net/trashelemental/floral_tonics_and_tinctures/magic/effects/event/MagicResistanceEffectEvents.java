package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.visual.particle.ParticleMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;
import net.trashelemental.floral_tonics_and_tinctures.util.ModTags;

@Mod.EventBusSubscriber
public class MagicResistanceEffectEvents {

    /**
     * When an entity with the Magic Resistance effect takes damage from or deals damage to a 'magical' entity, it will
     * dispel it. This is handled by tag. Entities under this effect are also immune to magical damage types.
     */
    @SubscribeEvent
    public static void onDamage(LivingAttackEvent event) {

        boolean targetHasEffect = false;
        boolean attackerHasEffect = false;

        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        MobEffect effect = ModMobEffects.MAGIC_RESISTANCE.get();
        DamageSource source = event.getSource();

        if (target.level().isClientSide) return;

        if (target.hasEffect(effect)) targetHasEffect = true;
        if (attacker instanceof LivingEntity entity && entity.hasEffect(effect)) attackerHasEffect = true;

        if (!targetHasEffect && !attackerHasEffect) return;

        if (targetHasEffect && isMagicalDamageTypes(source)) {
            event.setCanceled(true);
        }

        if (attacker != null) {
            if (targetHasEffect && attacker.getType().is(ModTags.Entities.MAGIC_RESISTANCE_DISPELS)) {
                event.setCanceled(true);
                ParticleMethods.ParticlesBurst(attacker.level(), ParticleTypes.FIREWORK,
                        target.getX(), target.getEyeY(), target.getZ(), 7, 0.1);
                attacker.discard();
            }

            if (attackerHasEffect && target.getType().is(ModTags.Entities.MAGIC_RESISTANCE_DISPELS)) {
                ParticleMethods.ParticlesBurst(attacker.level(), ParticleTypes.FIREWORK,
                        target.getX(), target.getEyeY(), target.getZ(), 7, 0.1);
                target.discard();
            }
        }
    }

    private static boolean isMagicalDamageTypes(DamageSource source) {
        return source.is(DamageTypes.MAGIC) || source.is(DamageTypes.INDIRECT_MAGIC);
    }
}
