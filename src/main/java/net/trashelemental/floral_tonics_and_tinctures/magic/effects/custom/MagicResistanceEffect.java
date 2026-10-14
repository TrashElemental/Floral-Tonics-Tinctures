package net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class MagicResistanceEffect extends MobEffect {
    public MagicResistanceEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x4AECD9);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {

    }

    public ResourceLocation getIcon() {
        return new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/mob_effect/magic_resistance.png");
    }
}
