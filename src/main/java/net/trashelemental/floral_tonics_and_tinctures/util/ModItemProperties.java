package net.trashelemental.floral_tonics_and_tinctures.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.List;

public class ModItemProperties {

    public static void registerCustomItemProperties() {

        ItemProperties.register(ModItems.TONIC.get(),
                new ResourceLocation("floral_tonics_and_tinctures", "is_negative"),
                (stack, level, entity, seed) -> {

                    Potion potion = PotionUtils.getPotion(stack);
                    List<MobEffectInstance> effects = potion.getEffects();
                    if (effects.isEmpty()) {
                        return 0f;
                    }

                    boolean hasNegative = effects.stream()
                            .anyMatch(e -> e.getEffect().getCategory() == MobEffectCategory.HARMFUL);
                    return hasNegative ? 1f : 0f;
                });


    }
}