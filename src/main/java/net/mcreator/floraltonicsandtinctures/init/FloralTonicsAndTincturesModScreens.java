
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.floraltonicsandtinctures.client.gui.HerbalismTableGUIScreen;
import net.mcreator.floraltonicsandtinctures.client.gui.HerbalismKitGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FloralTonicsAndTincturesModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(FloralTonicsAndTincturesModMenus.HERBALISM_TABLE_GUI.get(), HerbalismTableGUIScreen::new);
		event.register(FloralTonicsAndTincturesModMenus.HERBALISM_KIT_GUI.get(), HerbalismKitGUIScreen::new);
	}
}
