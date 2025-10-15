package net.trashelemental.floral_tonics_and_tinctures.menu.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class HerbalismTableScreen extends AbstractContainerScreen<HerbalismTableMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_table_gui.png");

    private static final ResourceLocation BOWL_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_bowl_icon.png");
    private static final ResourceLocation ARROW_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/arrow.png");
    private static final ResourceLocation BOTTLE_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_bottle_icon.png");
    private static final ResourceLocation FLOWER_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_flower_icon.png");

    public HerbalismTableScreen(HerbalismTableMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        guiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

        //Bowl
        guiGraphics.blit(BOWL_TEXTURE, leftPos + 63, topPos + 17, 0, 0, 60, 60, 60, 60);

        //Arrow
        guiGraphics.blit(ARROW_TEXTURE, leftPos + 117, topPos + 36, 0, 0, 20, 20, 20, 20);
        guiGraphics.blit(ARROW_TEXTURE, leftPos + 51, topPos + 35, 0, 0, 20, 20, 20, 20);

        if (menu.getSlot(1).getItem().isEmpty()) {
            int slotX = leftPos + 32;
            int slotY = topPos + 26;
            guiGraphics.blit(FLOWER_ICON_TEXTURE, slotX, slotY, 0, 0, 16, 16, 16, 16);
        }

        if (menu.getSlot(2).getItem().isEmpty()) {
            guiGraphics.blit(BOTTLE_ICON_TEXTURE, leftPos + 20, topPos + 51, 0, 0, 16, 16, 16, 16);
        }

        RenderSystem.disableBlend();
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(font, this.title, 4, 5, 0xFF404040, false);
        guiGraphics.drawString(font, Component.translatable("container.inventory"), 8, 72, 0xFF404040, false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
    }
}