package net.trashelemental.floral_tonics_and_tinctures.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FloralTonicsAndTinctures.MOD_ID);






    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
