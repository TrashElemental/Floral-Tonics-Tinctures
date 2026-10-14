package net.trashelemental.floral_tonics_and_tinctures.util.event;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.ModCreativeModeTabs;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipeTypes;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddTonicsToCreativeTabEvent {

    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() != ModCreativeModeTabs.FLORAL_TONICS_AND_TINCTURES_TAB.get()) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.getConnection() == null) return;
        if (mc.level.registryAccess() == null) return;
        RecipeManager manager = mc.getConnection().getRecipeManager();

        manager.getAllRecipesFor(ModRecipeTypes.HERBALISM.get()).forEach(r -> {
            ItemStack output = r.getResultItem(mc.level.registryAccess());
            if (output.getItem() == ModItems.TONIC.get()) {
                event.accept(output);
            }
        });
    }

}
