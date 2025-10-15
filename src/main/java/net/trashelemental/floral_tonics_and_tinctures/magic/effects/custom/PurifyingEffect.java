package net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

import java.util.List;

public class PurifyingEffect extends MobEffect {
    public PurifyingEffect() {
        super(MobEffectCategory.BENEFICIAL, 15259349);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        for (MobEffectInstance active : List.copyOf(entity.getActiveEffects())) {
            if (active.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                entity.removeEffect(active.getEffect());
            }
        }
    }




    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {

    }

    public ResourceLocation getIcon() {
        return new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/mob_effect/purifying.png");
    }
}
