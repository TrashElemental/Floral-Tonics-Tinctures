package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.visual.particle.ParticleMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.List;

@Mod.EventBusSubscriber
public class PurifyingEffectEvents {

    /**
     * When an entity affected by the Purifying effect damages another entity, it will remove any potion effects
     * from them.
     */
    @SubscribeEvent
    public static void PurifyingEffectAttackEvent(LivingDamageEvent event) {

        LivingEntity target = event.getEntity();
        MobEffect purifying = ModMobEffects.PURIFYING.get();
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;
        if (attacker.level().isClientSide) return;
        if (!attacker.hasEffect(purifying)) return;
        if (target.getActiveEffects().isEmpty()) return;

        for (MobEffectInstance effect : List.copyOf(target.getActiveEffects())) {
            target.removeEffect(effect.getEffect());
        }

        ParticleMethods.ParticlesAroundServerSide(target.level(), ParticleTypes.BUBBLE_POP,
                target.getX(), target.getEyeY(), target.getZ(), 20, 1.5);
        target.level().playSound(null, target.blockPosition(),
                SoundEvents.GENERIC_SPLASH, SoundSource.PLAYERS, 0.5F, 1.5F);
    }

    /**
     * When an entity affected by the Purifying effect interacts with another entity, it will remove any potion effects
     * from them. For tamed entities and allies, it will only remove harmful effects.
     */
    @SubscribeEvent
    public static void PurifyingEffectInteractEvent(PlayerInteractEvent.EntityInteract event) {

        Player player = event.getEntity();
        MobEffect purifying = ModMobEffects.PURIFYING.get();
        if (!player.hasEffect(purifying)) return;
        if (player.level().isClientSide) return;
        if (!(event.getTarget() instanceof LivingEntity target)) return;
        if (target.getActiveEffects().isEmpty()) return;

        boolean didCleanse = false;

        if ((target instanceof TamableAnimal pet && pet.isOwnedBy(player)) || target.isAlliedTo(player)) {
            for (MobEffectInstance effect : List.copyOf(target.getActiveEffects())) {
                if (effect.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                    target.removeEffect(effect.getEffect());
                    didCleanse = true;
                }
            }
        } else {
            for (MobEffectInstance effect : List.copyOf(target.getActiveEffects())) {
                target.removeEffect(effect.getEffect());
                didCleanse = true;
            }
        }

        if (didCleanse) {
            ParticleMethods.ParticlesAroundServerSide(target.level(), ParticleTypes.BUBBLE_POP,
                    target.getX(), target.getEyeY(), target.getZ(), 20, 1.5);
            target.level().playSound(null, target.blockPosition(),
                    SoundEvents.GENERIC_SPLASH, SoundSource.PLAYERS, 0.5F, 1.5F);
        }

    }



}