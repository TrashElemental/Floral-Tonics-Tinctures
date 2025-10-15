package net.trashelemental.floral_tonics_and_tinctures.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FloralTonicsAndTinctures.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FLORAL_TONICS_AND_TINCTURES_TAB = CREATIVE_MODE_TABS.register("floral_tonics_and_tinctures_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HERBALISM_KIT.get()))
                    .title(Component.translatable("creativetab.floral_tonics_and_tinctures_tab"))
                    .displayItems((params, output) -> {

                        output.accept(ModBlocks.HERBALISM_TABLE.get());
                        output.accept(ModItems.HERBALISM_KIT.get());


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
