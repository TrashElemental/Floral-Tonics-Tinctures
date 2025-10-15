package net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.event;

import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;
import net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.ModEnchantments;

import java.util.List;

@Mod.EventBusSubscriber
public class AlchemizedEvents {

    /**
     * When an entity wearing a helmet enchanted with Alchemized is damaged, they have a chance to receive a random
     * beneficial potion effect. Base chance is 50%, +15% for each level of the enchantment above 1.
     */
    @SubscribeEvent
    public static void AlchemizedApplyEffectEvent(LivingDamageEvent event) {

        LivingEntity target = event.getEntity();
        if (target.level().isClientSide) return;

        ItemStack headArmor = target.getItemBySlot(EquipmentSlot.HEAD);
        if (headArmor.isEmpty() || (!(headArmor.isEnchanted()))) return;

        int enchantmentLevel = headArmor.getEnchantmentLevel(ModEnchantments.ALCHEMIZED.get());
        if (enchantmentLevel <= 0) return;

        float activationChance = 0.5f + (0.15f * (enchantmentLevel - 1));

        if (target.getRandom().nextFloat() > activationChance) return;

        MobEffectInstance chosenEffect = getRandomPositiveEffect(target.getRandom());
        if (chosenEffect == null) return;

        target.addEffect(new MobEffectInstance(
                chosenEffect.getEffect(),
                chosenEffect.getDuration(),
                chosenEffect.getAmplifier(),
                false,
                true
        ));

    }

    private static MobEffectInstance getRandomPositiveEffect(RandomSource random) {
        List<MobEffectInstance> effects = List.of(
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200),
                new MobEffectInstance(ModMobEffects.PRICKLY.get(), 200),
                new MobEffectInstance(MobEffects.JUMP, 200),
                new MobEffectInstance(MobEffects.DIG_SPEED, 100),
                new MobEffectInstance(MobEffects.REGENERATION, 100),
                new MobEffectInstance(MobEffects.ABSORPTION, 100)
        );

        return effects.get(random.nextInt(effects.size()));
    }
}
