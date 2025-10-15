package net.trashelemental.floral_tonics_and_tinctures.menu;

import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.HerbalismTableMenu;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.herbalism_kit.HerbalismKitMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<MenuType<HerbalismTableMenu>> HERBALISM_TABLE =
            MENUS.register("herbalism_table",
                    () -> IForgeMenuType.create((windowId, inv, data) ->
                            new HerbalismTableMenu(windowId, inv, ContainerLevelAccess.NULL))
            );

    public static final RegistryObject<MenuType<HerbalismKitMenu>> HERBALISM_KIT =
            ModMenuTypes.MENUS.register("herbalism_kit",
                    () -> IForgeMenuType.create(HerbalismKitMenu::new)
            );

    public static void register(IEventBus bus) {
        MENUS.register(bus);
    }
}
