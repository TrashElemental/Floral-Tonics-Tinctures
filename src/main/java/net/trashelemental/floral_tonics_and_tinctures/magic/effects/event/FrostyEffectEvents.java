package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.Map;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber
public class FrostyEffectEvents {

    private static int minFreezeTicks = 300;
    private static int extraFreezeTicksPerLevel = 60;
    private static int maxFreezeTicks = 1000;

    /**
     * When an entity with the Frosty effect deals or takes damage to or from a living entity, it will build up
     * frostbite on it, inflicting 300 ticks of freeze, plus 60 for each level of the effect above one.
     * When triggered for an entity that already has frostbite, increases the frostbite amount.
     */
    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event) {

        boolean targetHasEffect = false;
        boolean attackerHasEffect = false;

        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        MobEffect frosty = ModMobEffects.FROSTY.get();

        if (attacker == null) return;
        if (target.level().isClientSide) return;

        if (target.hasEffect(frosty)) targetHasEffect = true;
        if (attacker instanceof LivingEntity entity && entity.hasEffect(frosty)) attackerHasEffect = true;

        if (!targetHasEffect && !attackerHasEffect) return;

        if (targetHasEffect && attacker instanceof LivingEntity livingAttacker) {
            int frostyLevel = target.getEffect(frosty).getAmplifier();
            applyFrost(livingAttacker, frostyLevel);
        }

        if (attackerHasEffect && attacker instanceof LivingEntity livingAttacker2) {
            int frostyLevel = livingAttacker2.getEffect(frosty).getAmplifier();
            applyFrost(target, frostyLevel);
        }
    }

    private static void applyFrost(LivingEntity entity, int frostyLevel) {
        int currentTicks = entity.getTicksFrozen();
        int addedTicks = minFreezeTicks + extraFreezeTicksPerLevel * frostyLevel;

        if (currentTicks > 0) {
            addedTicks += extraFreezeTicksPerLevel;
        }

        entity.setTicksFrozen(Math.min(currentTicks + addedTicks, maxFreezeTicks));
    }


    private static final Map<LivingEntity, BlockPos> lastBlockPos = new WeakHashMap<>();

    @SubscribeEvent
    public static void onMove(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity.level().isClientSide()) return;
        if (!entity.hasEffect(ModMobEffects.FROSTY.get())) return;
        if (!entity.onGround()) return;

        BlockPos currentPos = entity.blockPosition();
        BlockPos previousPos = lastBlockPos.get(entity);

        if (previousPos != null && previousPos.equals(currentPos)) {
            return;
        }

        lastBlockPos.put(entity, currentPos);
        freezeWater(entity);
    }

    /**
     * Freezes nearby water as if the player had Frost Walker.
     */
    public static void freezeWater(LivingEntity entity) {
        Level world = entity.level();
        BlockPos entityPos = entity.blockPosition();

        int radius = 5;
        BlockState iceBlock = Blocks.FROSTED_ICE.defaultBlockState();
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                mutablePos.set(entityPos.getX() + dx, entityPos.getY() - 1, entityPos.getZ() + dz);

                int ex = mutablePos.getX() - entityPos.getX();
                int ez = mutablePos.getZ() - entityPos.getZ();
                if (ex * ex + ez * ez > radius * radius) continue;

                BlockState state = world.getBlockState(mutablePos);
                if (state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8) {
                    BlockPos above = mutablePos.above();
                    if (world.getBlockState(above).isAir()) {
                        world.setBlock(mutablePos, iceBlock, 3);
                        world.scheduleTick(mutablePos, Blocks.FROSTED_ICE, 60 + entity.getRandom().nextInt(61));
                    }
                }
            }
        }
    }


}
