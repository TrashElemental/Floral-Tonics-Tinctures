package net.trashelemental.floral_tonics_and_tinctures.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.HerbalismKitItem;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.TonicItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FloralTonicsAndTinctures.MOD_ID);


    public static final RegistryObject<Item> TONIC = ITEMS.register("tonic",
            () -> new TonicItem(new Item.Properties()));

    public static final RegistryObject<Item> HERBALISM_KIT = ITEMS.register("herbalism_kit",
            () -> new HerbalismKitItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
