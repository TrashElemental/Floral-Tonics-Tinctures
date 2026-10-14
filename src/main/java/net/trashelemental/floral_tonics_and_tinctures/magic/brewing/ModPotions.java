package net.trashelemental.floral_tonics_and_tinctures.magic.brewing;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, FloralTonicsAndTinctures.MOD_ID);

    public static int veryShortDuration = 20 * 20;
    public static int shortDuration = 45 * 20;
    public static int mediumDuration = 90 * 20;
    public static int longDuration = 180 * 20;

    public static int veryShortDurationLong = 40 * 20;
    public static int shortDurationLong = 90 * 20;
    public static int mediumDurationLong = 240 * 20;
    public static int longDurationLong = 480 * 20;

    public static int veryShortDurationStrong = 10 * 20;
    public static int shortDurationStrong = 23 * 20;
    public static int mediumDurationStrong = 45 * 20;
    public static int longDurationStrong = 90 * 20;

    public static final RegistryObject<Potion> WITHER_POTION = REGISTRY.register("wither_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, veryShortDuration, 0, false, true)));
    public static final RegistryObject<Potion> WITHER_POTION_LONG = REGISTRY.register("wither_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, veryShortDurationLong, 0, false, true)));
    public static final RegistryObject<Potion> WITHER_POTION_STRONG = REGISTRY.register("wither_potion_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.WITHER, veryShortDurationStrong, 1, false, true)));

    public static final RegistryObject<Potion> LEVITATION_POTION = REGISTRY.register("levitation_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.LEVITATION, veryShortDuration, 0, false, true)));
    public static final RegistryObject<Potion> LEVITATION_POTION_LONG = REGISTRY.register("levitation_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.LEVITATION, veryShortDurationLong, 0, false, true)));
    public static final RegistryObject<Potion> LEVITATION_POTION_STRONG = REGISTRY.register("levitation_potion_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.LEVITATION, veryShortDurationStrong, 1, false, true)));

    public static final RegistryObject<Potion> HASTE_POTION = REGISTRY.register("haste_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, shortDuration, 0, false, true)));
    public static final RegistryObject<Potion> HASTE_POTION_LONG = REGISTRY.register("haste_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, shortDurationLong, 0, false, true)));
    public static final RegistryObject<Potion> HASTE_POTION_STRONG = REGISTRY.register("haste_potion_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, shortDurationStrong, 1, false, true)));

    public static final RegistryObject<Potion> DOLPHINS_GRACE_POTION = REGISTRY.register("dolphins_grace_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, longDuration, 0, false, true)));
    public static final RegistryObject<Potion> DOLPHINS_GRACE_POTION_LONG = REGISTRY.register("dolphins_grace_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, longDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> GLOWING_POTION = REGISTRY.register("glowing_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.GLOWING, mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> GLOWING_POTION_LONG = REGISTRY.register("glowing_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.GLOWING, mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> BLINDNESS_POTION = REGISTRY.register("blindness_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.BLINDNESS, veryShortDuration, 0, false, true)));
    public static final RegistryObject<Potion> BLINDNESS_POTION_LONG = REGISTRY.register("blindness_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.BLINDNESS, veryShortDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> NAUSEA_POTION = REGISTRY.register("nausea_potion", () ->
            new Potion(new MobEffectInstance(MobEffects.CONFUSION, veryShortDuration, 0, false, true)));
    public static final RegistryObject<Potion> NAUSEA_POTION_LONG = REGISTRY.register("nausea_potion_long", () ->
            new Potion(new MobEffectInstance(MobEffects.CONFUSION, veryShortDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> RESISTANCE_POTION = REGISTRY.register("resistance", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> RESISTANCE_POTION_LONG = REGISTRY.register("resistance_long", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, mediumDurationLong, 0, false, true)));
    public static final RegistryObject<Potion> RESISTANCE_POTION_STRONG = REGISTRY.register("resistance_strong", () ->
            new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, mediumDurationStrong, 1, false, true)));


    //FTT Potions
    public static final RegistryObject<Potion> FIERY_POTION = REGISTRY.register("fiery", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FIERY.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> FIERY_LONG = REGISTRY.register("fiery_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FIERY.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> FLORAL_SCENT_POTION = REGISTRY.register("floral_scent", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FLORAL_SCENT.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> FLORAL_SCENT_LONG = REGISTRY.register("floral_scent_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FLORAL_SCENT.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> FROSTY_POTION = REGISTRY.register("frosty", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FROSTY.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> FROSTY_LONG = REGISTRY.register("frosty_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.FROSTY.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> GOLD_RUSH_POTION = REGISTRY.register("gold_rush", () ->
            new Potion(new MobEffectInstance(ModMobEffects.GOLD_RUSH.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> GOLD_RUSH_LONG = REGISTRY.register("gold_rush_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.GOLD_RUSH.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> MAGIC_RESISTANCE_POTION = REGISTRY.register("magic_resistance", () ->
            new Potion(new MobEffectInstance(ModMobEffects.MAGIC_RESISTANCE.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> MAGIC_RESISTANCE_LONG = REGISTRY.register("magic_resistance_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.MAGIC_RESISTANCE.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> PRICKLY_POTION = REGISTRY.register("prickly", () ->
            new Potion(new MobEffectInstance(ModMobEffects.PRICKLY.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> PRICKLY_POTION_LONG = REGISTRY.register("prickly_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.PRICKLY.get(), mediumDurationLong, 0, false, true)));
    public static final RegistryObject<Potion> PRICKLY_POTION_STRONG = REGISTRY.register("prickly_strong", () ->
            new Potion(new MobEffectInstance(ModMobEffects.PRICKLY.get(), mediumDurationStrong, 1, false, true)));

    public static final RegistryObject<Potion> PURIFYING_POTION = REGISTRY.register("purifying", () ->
            new Potion(new MobEffectInstance(ModMobEffects.PURIFYING.get(), mediumDuration, 0, false, true)));
    public static final RegistryObject<Potion> PURIFYING_LONG = REGISTRY.register("purifying_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.PURIFYING.get(), mediumDurationLong, 0, false, true)));

    public static final RegistryObject<Potion> VOLATILITY_POTION = REGISTRY.register("volatility", () ->
            new Potion(new MobEffectInstance(ModMobEffects.VOLATILITY.get(), veryShortDuration, 0, false, true)));

    public static final RegistryObject<Potion> WAYFARING_POTION = REGISTRY.register("wayfaring", () ->
            new Potion(new MobEffectInstance(ModMobEffects.WAYFARING.get(), longDuration, 0, false, true)));
    public static final RegistryObject<Potion> WAYFARING_LONG = REGISTRY.register("wayfaring_long", () ->
            new Potion(new MobEffectInstance(ModMobEffects.WAYFARING.get(), longDurationLong, 0, false, true)));




    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
