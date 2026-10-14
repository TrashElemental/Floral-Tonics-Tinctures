package net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.event.FrostyEffectEvents;

public class FrostyEffect extends MobEffect {
    public FrostyEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x99F9FB);
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
        return new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/mob_effect/frosty.png");
    }
}
