package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.util.UtilMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.List;

@Mod.EventBusSubscriber
public class VolatilityEffectEvents {

    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        MobEffectInstance instance = event.getEffectInstance();
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (level.isClientSide) return;
        if (instance.getEffect() != ModMobEffects.VOLATILITY.get()) return;

        BlockPos pos = entity.blockPosition();

        level.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);
        ((ServerLevel) level).sendParticles(ParticleTypes.EXPLOSION_EMITTER,
                entity.getX(), entity.getY() + 0.5, entity.getZ(),
                1, 0.0, 0.0, 0.0, 0.0);
        ((ServerLevel) level).sendParticles(ParticleTypes.EXPLOSION,
                entity.getX(), entity.getY() + 0.5, entity.getZ(),
                30, 0.5, 0.5, 0.5, 0.05);

        double innerRadius = 4.0;
        double outerRadius = 7.0;

        UtilMethods.damageEntity(entity, DamageTypes.EXPLOSION, 8);

        RandomSource random = entity.getRandom();
        double randomX = (random.nextDouble() - 0.5D) * 0.6D;
        double randomZ = (random.nextDouble() - 0.5D) * 0.6D;
        double upward = 0.8D + random.nextDouble() * 0.4D;
        entity.push(randomX, upward, randomZ);
        entity.hurtMarked = true;

        AABB area = new AABB(
                pos.getX() - outerRadius, pos.getY() - outerRadius, pos.getZ() - outerRadius,
                pos.getX() + outerRadius, pos.getY() + outerRadius, pos.getZ() + outerRadius
        );

        List<Entity> nearby = level.getEntities(entity, area, e -> e instanceof LivingEntity && e.isAlive());

        for (Entity e : nearby) {
            if (e == entity) continue;

            double dx = e.getX() - entity.getX();
            double dy = (e.getY() + e.getBbHeight() / 2.0) - (entity.getY() + entity.getBbHeight() / 2.0);
            double dz = e.getZ() - entity.getZ();
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            if (distance > outerRadius) continue;

            float damage;
            if (distance <= innerRadius) {
                damage = 20.0F + random.nextFloat() * 4.0F;
            } else {
                damage = 10.0F + random.nextFloat() * 5.0F;
            }

            UtilMethods.damageEntity((LivingEntity) e, DamageTypes.EXPLOSION, damage);

            double strength = (1.0 - (distance / outerRadius)) * 1.5;
            Vec3 knockback = new Vec3(dx, dy + 0.5, dz).normalize().scale(strength);

            e.push(knockback.x, knockback.y, knockback.z);
            e.hurtMarked = true;
        }
    }
}
