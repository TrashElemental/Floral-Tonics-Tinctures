package net.trashelemental.floral_tonics_and_tinctures.util.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.List;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID)
public class AdvancementEventHandler {

    @SubscribeEvent
    public static void onTonicConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        ItemStack stack = event.getItem();
        if (stack.getItem() != ModItems.TONIC.get()) return;

        List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);

        for (MobEffectInstance effectInstance : effects) {
            if (effectInstance.getEffect() == ModMobEffects.PURIFYING.get()) {
                grantAdvancement(player, new ResourceLocation("floral_tonics_and_tinctures", "purifying_tonic_drink"));
                break;
            }

            if (effectInstance.getEffect() == ModMobEffects.PRICKLY.get()) {
                grantAdvancement(player, new ResourceLocation("floral_tonics_and_tinctures", "prickly_tonic_drink"));
                break;
            }

            if (effectInstance.getEffect() == MobEffects.WITHER) {
                grantAdvancement(player, new ResourceLocation("floral_tonics_and_tinctures", "wither_tonic_drink"));
                break;
            }

            if (effectInstance.getEffect() == MobEffects.CONFUSION) {
                grantAdvancement(player, new ResourceLocation("floral_tonics_and_tinctures", "nausea_tonic_drink"));
                break;
            }
        }
    }

    private static void grantAdvancement(ServerPlayer player, ResourceLocation advancementId) {
        var advancement = player.server.getAdvancements().getAdvancement(advancementId);
        if (advancement != null) {
            var progress = player.getAdvancements().getOrStartProgress(advancement);
            if (!progress.isDone()) {
                for (String criterion : progress.getRemainingCriteria()) {
                    player.getAdvancements().award(advancement, criterion);
                }
            }
        }
    }


}
