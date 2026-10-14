package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.visual.particle.ParticleMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;
import net.trashelemental.floral_tonics_and_tinctures.particle.ModParticles;

import java.util.Map;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber
public class WayfaringEffectEvents {

    private static final Map<LivingEntity, BlockPos> lastBlockPos = new WeakHashMap<>();
    private static final RandomSource random = RandomSource.create();

    @SubscribeEvent
    public static void onMove(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (level.isClientSide()) return;
        if (!entity.hasEffect(ModMobEffects.WAYFARING.get())) return;
        if (!entity.onGround()) return;

        BlockPos currentPos = entity.blockPosition();
        BlockPos previousPos = lastBlockPos.get(entity);

        if (previousPos != null && previousPos.equals(currentPos)) {
            return;
        }

        lastBlockPos.put(entity, currentPos);

        if (random.nextFloat() < 0.5f) {
            ParticleMethods.ParticlesAroundServerSide(level, ModParticles.WAYFARER.get(),
                    entity.getX(), entity.getY() + 0.3, entity.getZ(), 1, 0.5);
        }
    }
}

