package net.trashelemental.floral_tonics_and_tinctures.menu.custom.herbalism_kit;


import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class HerbalismKitScreen extends AbstractContainerScreen<HerbalismKitMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE =
            new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "textures/gui/herbalism_kit_gui.png");
    private static final ResourceLocation BOWL_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_bowl_icon.png");
    private static final ResourceLocation ARROW_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/arrow.png");
    private static final ResourceLocation BOTTLE_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_bottle_icon.png");
    private static final ResourceLocation FLOWER_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_flower_icon.png");
    private static final ResourceLocation SUGAR_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_sugar_icon.png");
    private static final ResourceLocation SPIDER_EYE_ICON_TEXTURE =
            new ResourceLocation("floral_tonics_and_tinctures:textures/gui/herbalism_spider_eye_icon.png");

    public HerbalismKitScreen(HerbalismKitMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
        this.imageWidth = 178;
        this.imageHeight = 193;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        guiGraphics.blit(BACKGROUND_TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.disableBlend();

        guiGraphics.blit(BOWL_TEXTURE, this.leftPos + 78, this.topPos + 70, 0, 0, 30, 30, 30, 30);

        guiGraphics.blit(ARROW_TEXTURE, this.leftPos + 58, this.topPos + 76, 0, 0, 20, 20, 20, 20);

        guiGraphics.blit(ARROW_TEXTURE, this.leftPos + 108, this.topPos + 74, 0, 0, 20, 20, 20, 20);

        //Ingredient
        if (menu.getSlot(1).getItem().isEmpty()) {
            guiGraphics.blit(FLOWER_ICON_TEXTURE, this.leftPos + 35, this.topPos + 66, 0, 0, 16, 16, 16, 16);
        }

        //Bottle
        if (menu.getSlot(2).getItem().isEmpty()) {
            guiGraphics.blit(BOTTLE_ICON_TEXTURE, this.leftPos + 26, this.topPos + 84, 0, 0, 16, 16, 16, 16);
        }

        //Storage
        if (menu.getSlot(4).getItem().isEmpty()) {
            guiGraphics.blit(FLOWER_ICON_TEXTURE, this.leftPos + 8, this.topPos + 21, 0, 0, 16, 16, 16, 16);
        }
        if (menu.getSlot(13).getItem().isEmpty()) {
            guiGraphics.blit(BOTTLE_ICON_TEXTURE, this.leftPos + 8, this.topPos + 39, 0, 0, 16, 16, 16, 16);
        }
        if (menu.getSlot(20).getItem().isEmpty()) {
            guiGraphics.blit(SUGAR_ICON_TEXTURE, this.leftPos + 134, this.topPos + 40, 0, 0, 16, 16, 16, 16);
        }
        if (menu.getSlot(21).getItem().isEmpty()) {
            guiGraphics.blit(SPIDER_EYE_ICON_TEXTURE, this.leftPos + 152, this.topPos + 39, 0, 0, 16, 16, 16, 16);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(font, Component.translatable( "gui.floral_tonics_and_tinctures.herbalism_kit_gui.herbalism_kit"),
                7, 6, 0x303030, false);
        guiGraphics.drawString(font, Component.translatable("container.inventory"),
                7, 102, 0x303030, false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}