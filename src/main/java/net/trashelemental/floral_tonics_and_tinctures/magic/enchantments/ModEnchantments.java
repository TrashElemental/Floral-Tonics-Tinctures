package net.trashelemental.floral_tonics_and_tinctures.magic.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.custom.AlchemizedEnchantment;
import net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.custom.FloralGiftEnchantment;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<Enchantment> FLORAL_GIFT = REGISTRY.register("floral_gift", FloralGiftEnchantment::new);
    public static final RegistryObject<Enchantment> ALCHEMIZED = REGISTRY.register("alchemized", AlchemizedEnchantment::new);


    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
