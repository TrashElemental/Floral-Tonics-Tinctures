package net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.event.FieryEffectEvents;

public class FieryEffect extends MobEffect {
    public FieryEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF581F);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide) return;

        FieryEffectEvents.smeltItems(player);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {

    }

    public ResourceLocation getIcon() {
        return new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/mob_effect/fiery.png");
    }
}
