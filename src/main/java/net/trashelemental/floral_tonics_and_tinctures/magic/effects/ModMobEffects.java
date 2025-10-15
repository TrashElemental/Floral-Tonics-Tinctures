package net.trashelemental.floral_tonics_and_tinctures.magic.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom.PricklyEffect;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.custom.PurifyingEffect;

public class ModMobEffects {

    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<MobEffect> PRICKLY = REGISTRY.register("prickly", PricklyEffect::new);
    public static final RegistryObject<MobEffect> PURIFYING = REGISTRY.register("purifying", PurifyingEffect::new);

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
