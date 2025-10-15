package net.trashelemental.floral_tonics_and_tinctures.util.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemTintHandler {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
            if (tintIndex == 1) {
                List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);
                if (!effects.isEmpty()) {
                    return effects.get(0).getEffect().getColor();
                }
                return 0xFFFFFF;
            }
            return 0xFFFFFF;
        }, ModItems.TONIC.get());
    }

}
