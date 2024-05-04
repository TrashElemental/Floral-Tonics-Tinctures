
package net.mcreator.floraltonicsandtinctures.item.inventory;

import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;

import net.mcreator.floraltonicsandtinctures.init.FloralTonicsAndTincturesModItems;
import net.mcreator.floraltonicsandtinctures.client.gui.HerbalismKitGUIScreen;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class HerbalismKitInventoryCapability extends ItemStackHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == FloralTonicsAndTincturesModItems.HERBALISM_KIT.get()) {
			if (Minecraft.getInstance().screen instanceof HerbalismKitGUIScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public HerbalismKitInventoryCapability() {
		super(22);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != FloralTonicsAndTincturesModItems.HERBALISM_KIT.get();
	}

	@Override
	public void setSize(int size) {
	}
}
