package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.visual.particle.ParticleMethods;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class FieryEffectEvents {

    /**
     * When an entity with the Fiery effect deals or takes damage to or from a living entity, it will set it on fire
     * for four seconds plus one additional second for each level of the effect above one.
     */
    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event) {

        boolean targetHasFiery = false;
        boolean attackerHasFiery = false;

        int minBurnSeconds = 4;

        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        MobEffect fiery = ModMobEffects.FIERY.get();

        if (attacker == null) return;
        if (target.level().isClientSide) return;

        if (target.hasEffect(fiery)) targetHasFiery = true;
        if (attacker instanceof LivingEntity entity && entity.hasEffect(fiery)) attackerHasFiery = true;

        if (!targetHasFiery && !attackerHasFiery) return;

        if (targetHasFiery) {
            int fieryLevel = target.getEffect(fiery).getAmplifier();
            attacker.setSecondsOnFire(minBurnSeconds + fieryLevel);
        }

        if (attackerHasFiery) {
            int fieryLevel = ((LivingEntity) attacker).getEffect(fiery).getAmplifier();
            target.setSecondsOnFire(minBurnSeconds + fieryLevel);
        }
    }

    private static final Map<UUID, Map<InteractionHand, SmeltProgress>> progressMap = new HashMap<>();
    private static final int SMELT_TIME = 60;

    public static void smeltItems(Player player) {
        UUID id = player.getUUID();
        Map<InteractionHand, SmeltProgress> handMap = progressMap.computeIfAbsent(id, k -> new EnumMap<>(InteractionHand.class));

        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack stack = player.getItemInHand(hand);

            if (stack.isEmpty() || stack.getItem() instanceof TieredItem || stack.getItem() instanceof ArmorItem) {
                handMap.remove(hand);
                continue;
            }

            ItemStack result = getSmeltingResult(player, stack);
            if (result.isEmpty()) {
                handMap.remove(hand);
                continue;
            }

            SmeltProgress progress = handMap.get(hand);

            if (progress == null || !ItemStack.isSameItemSameTags(stack, progress.stack)) {
                progress = new SmeltProgress(stack.copy(), 0);
                handMap.put(hand, progress);

                ParticleMethods.ParticlesAroundServerSide(player.level(), ParticleTypes.SMOKE,
                        player.getX(), player.getEyeY() - 0.3, player.getZ(), 5, 1.5);

                continue;
            }

            progress.ticks++;

            if (progress.ticks >= SMELT_TIME) {
                smeltItem(player, hand, stack, result);
                handMap.remove(hand);
            }
        }
    }

    private static ItemStack getSmeltingResult(Player player, ItemStack stack) {
        RecipeManager recipeManager = player.level().getRecipeManager();
        return recipeManager
                .getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack.copyWithCount(1)), player.level())
                .map(recipe -> recipe.getResultItem(player.level().registryAccess()).copy())
                .orElse(ItemStack.EMPTY);
    }

    private static void smeltItem(Player player, InteractionHand hand, ItemStack input, ItemStack output) {
        input.shrink(1);

        if (input.isEmpty()) {
            player.setItemInHand(hand, output);
        } else {
            if (!player.addItem(output)) {
                player.drop(output, false);
            }
        }

        ParticleMethods.ParticlesAroundServerSide(player.level(), ParticleTypes.FLAME,
                player.getX(), player.getEyeY() - 0.3, player.getZ(), 5, 1.5);

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.CAMPFIRE_CRACKLE, SoundSource.PLAYERS, 1.0F, 1.0F);
    }

    private static class SmeltProgress {
        final ItemStack stack;
        int ticks;

        SmeltProgress(ItemStack stack, int ticks) {
            this.stack = stack;
            this.ticks = ticks;
        }
    }

}
