package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Mod.EventBusSubscriber
public class FloralScentEffectEvents {

    /**
     * While a non-player entity has the Floral Scent effect, they are pacified and will not target
     * or be targeted by other entities that have or target entities with the same effect.
     */
    @SubscribeEvent
    public static void onTargetSet(LivingChangeTargetEvent event) {
        LivingEntity entity = event.getEntity();
        LivingEntity originalTarget = event.getOriginalTarget();
        LivingEntity newTarget = event.getNewTarget();
        MobEffect effect = ModMobEffects.FLORAL_SCENT.get();

        if (entity.level().isClientSide) return;

        if (entity.hasEffect(effect)
                || (originalTarget != null && originalTarget.hasEffect(effect))
                || (newTarget != null && newTarget.hasEffect(effect))) {
            event.setCanceled(true);
        }
    }

    /**
     * If an entity with Floral Scent attacks or takes damage from another entity, the effect is removed.
     */
    @SubscribeEvent
    public static void onDamage(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        MobEffect effect = ModMobEffects.FLORAL_SCENT.get();

        if (target.level().isClientSide) return;

        if (target.hasEffect(effect)) {
            target.removeEffect(effect);
        }

        if (attacker instanceof LivingEntity livingAttacker && livingAttacker.hasEffect(effect)) {
            livingAttacker.removeEffect(effect);
        }
    }

    /**
     * When the effect is applied to an entity, it will stop targeting anything it was targeting, and
     * if any nearby entities are targeting it, they will stop doing so.
     */
    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = ModMobEffects.FLORAL_SCENT.get();

        if (entity.level().isClientSide) return;
        if (event.getEffectInstance().getEffect() != effect) return;

        Level level = entity.level();

        if (entity instanceof Mob mob) {
            mob.setTarget(null);
            mob.setLastHurtByMob(null);
            mob.setLastHurtMob(null);
            mob.setAggressive(false);
        }

        List<Mob> nearbyMobs = level.getEntitiesOfClass(Mob.class,
                entity.getBoundingBox().inflate(16.0D),
                mob -> mob.getTarget() == entity);

        for (Mob mob : nearbyMobs) {
            mob.setTarget(null);
            mob.setLastHurtByMob(null);
            mob.setLastHurtMob(null);
        }
    }
}
