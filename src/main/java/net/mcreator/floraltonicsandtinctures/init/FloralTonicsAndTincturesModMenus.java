
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.floraltonicsandtinctures.world.inventory.HerbalismTableGUIMenu;
import net.mcreator.floraltonicsandtinctures.world.inventory.HerbalismKitGUIMenu;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<HerbalismTableGUIMenu>> HERBALISM_TABLE_GUI = REGISTRY.register("herbalism_table_gui", () -> IMenuTypeExtension.create(HerbalismTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HerbalismKitGUIMenu>> HERBALISM_KIT_GUI = REGISTRY.register("herbalism_kit_gui", () -> IMenuTypeExtension.create(HerbalismKitGUIMenu::new));
}
