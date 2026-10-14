package net.trashelemental.floral_tonics_and_tinctures.magic.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom.*;

public class ModMobEffects {

    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<MobEffect> PRICKLY = REGISTRY.register("prickly", PricklyEffect::new);
    public static final RegistryObject<MobEffect> PURIFYING = REGISTRY.register("purifying", PurifyingEffect::new);

    public static final RegistryObject<MobEffect> FIERY = REGISTRY.register("fiery", FieryEffect::new);
    public static final RegistryObject<MobEffect> FROSTY = REGISTRY.register("frosty", FrostyEffect::new);
    public static final RegistryObject<MobEffect> MAGIC_RESISTANCE = REGISTRY.register("magic_resistance", MagicResistanceEffect::new);
    public static final RegistryObject<MobEffect> VOLATILITY = REGISTRY.register("volatility", VolatilityEffect::new);
    public static final RegistryObject<MobEffect> GOLD_RUSH = REGISTRY.register("gold_rush", GoldRushEffect::new);
    public static final RegistryObject<MobEffect> FLORAL_SCENT = REGISTRY.register("floral_scent", FloralScentEffect::new);
    public static final RegistryObject<MobEffect> WAYFARING = REGISTRY.register("wayfaring", WayfaringEffect::new);

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
