package net.mcreator.floraltonicsandtinctures.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.floraltonicsandtinctures.world.inventory.HerbalismKitGUIMenu;
import net.mcreator.floraltonicsandtinctures.procedures.SugarIconSlot16Procedure;
import net.mcreator.floraltonicsandtinctures.procedures.SpiderEyeIconSlot17Procedure;
import net.mcreator.floraltonicsandtinctures.procedures.FlowerIconSlot0Procedure;
import net.mcreator.floraltonicsandtinctures.procedures.BottleIconSlot9Procedure;
import net.mcreator.floraltonicsandtinctures.procedures.BottleIconGUIDisplayProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HerbalismKitGUIScreen extends AbstractContainerScreen<HerbalismKitGUIMenu> {
	private final static HashMap<String, Object> guistate = HerbalismKitGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HerbalismKitGUIScreen(HerbalismKitGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 193;
	}

	private static final ResourceLocation texture = new ResourceLocation("floral_tonics_and_tinctures:textures/screens/herbalism_kit_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/bowl2.png"), this.leftPos + 78, this.topPos + 70, 0, 0, 30, 30, 30, 30);

		guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/arrow.png"), this.leftPos + 58, this.topPos + 76, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/arrow.png"), this.leftPos + 108, this.topPos + 74, 0, 0, 20, 20, 20, 20);

		if (BottleIconGUIDisplayProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/bottle.png"), this.leftPos + 26, this.topPos + 85, 0, 0, 16, 16, 16, 16);
		}
		if (BottleIconSlot9Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/bottle.png"), this.leftPos + 8, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (SugarIconSlot16Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/sugaricon.png"), this.leftPos + 134, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (SpiderEyeIconSlot17Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/spidereyeicon.png"), this.leftPos + 153, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		}
		if (FlowerIconSlot0Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("floral_tonics_and_tinctures:textures/screens/flowericon.png"), this.leftPos + 8, this.topPos + 21, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.floral_tonics_and_tinctures.herbalism_kit_gui.label_herbalism_kit"), 7, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.floral_tonics_and_tinctures.herbalism_kit_gui.label_inventory"), 7, 102, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
