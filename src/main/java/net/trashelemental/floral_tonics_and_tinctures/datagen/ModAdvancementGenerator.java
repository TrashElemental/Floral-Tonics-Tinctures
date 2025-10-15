package net.trashelemental.floral_tonics_and_tinctures.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> writer, ExistingFileHelper existingFileHelper) {

        Advancement HerbalismTableGet = Advancement.Builder.advancement()
                .display(
                        ModBlocks.HERBALISM_TABLE.get(), // Icon
                        Component.translatable("advancements.floral_tonics_and_tinctures.herbalism_table_get.title"), // Title
                        Component.translatable("advancements.floral_tonics_and_tinctures.herbalism_table_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        false // Hidden
                )
                .parent(new ResourceLocation("minecraft:husbandry/root"))
                .addCriterion("has_herbalism_table", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.HERBALISM_TABLE.get()))
                .save(writer, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "herbalism_kit_table"), existingFileHelper);


        Advancement HerbalismKitGet = Advancement.Builder.advancement()
                .display(
                        ModItems.HERBALISM_KIT.get(), // Icon
                        Component.translatable("advancements.floral_tonics_and_tinctures.herbalism_kit_get.title"), // Title
                        Component.translatable("advancements.floral_tonics_and_tinctures.herbalism_kit_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        false // Hidden
                )
                .parent(HerbalismTableGet)
                .addCriterion("has_herbalism_kit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HERBALISM_KIT.get()))
                .save(writer, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "herbalism_kit_get"), existingFileHelper);


        Advancement PurifyingTonicDrink = Advancement.Builder.advancement()
                .display(
                        Items.SPONGE,
                        Component.translatable("advancements.floral_tonics_and_tinctures.purifying_drink.title"),
                        Component.translatable("advancements.floral_tonics_and_tinctures.purifying_drink.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.GOAL,
                        true,  // show toast
                        true,  // announce to chat
                        false  // hidden
                )
                .parent(HerbalismTableGet)
                .addCriterion("impossible", new ImpossibleTrigger.TriggerInstance())
                .save(writer, new ResourceLocation("floral_tonics_and_tinctures","purifying_tonic_drink"), existingFileHelper);

        Advancement PricklyTonicDrink = Advancement.Builder.advancement()
                .display(
                        Items.CACTUS,
                        Component.translatable("advancements.floral_tonics_and_tinctures.prickly_drink.title"),
                        Component.translatable("advancements.floral_tonics_and_tinctures.prickly_drink.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.GOAL,
                        true,  // show toast
                        true,  // announce to chat
                        false  // hidden
                )
                .parent(HerbalismTableGet)
                .addCriterion("impossible", new ImpossibleTrigger.TriggerInstance())
                .save(writer, new ResourceLocation("floral_tonics_and_tinctures","prickly_tonic_drink"), existingFileHelper);

        Advancement WitherTonicDrink = Advancement.Builder.advancement()
                .display(
                        Items.WITHER_ROSE,
                        Component.translatable("advancements.floral_tonics_and_tinctures.wither_drink.title"),
                        Component.translatable("advancements.floral_tonics_and_tinctures.wither_drink.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.CHALLENGE,
                        true,  // show toast
                        true,  // announce to chat
                        true  // hidden
                )
                .parent(HerbalismTableGet)
                .addCriterion("impossible", new ImpossibleTrigger.TriggerInstance())
                .save(writer, new ResourceLocation("floral_tonics_and_tinctures","wither_tonic_drink"), existingFileHelper);

        Advancement NauseaTonicDrink = Advancement.Builder.advancement()
                .display(
                        Items.WARPED_FUNGUS,
                        Component.translatable("advancements.floral_tonics_and_tinctures.nausea_drink.title"),
                        Component.translatable("advancements.floral_tonics_and_tinctures.nausea_drink.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.CHALLENGE,
                        true,  // show toast
                        true,  // announce to chat
                        true  // hidden
                )
                .parent(HerbalismTableGet)
                .addCriterion("impossible", new ImpossibleTrigger.TriggerInstance())
                .save(writer, new ResourceLocation("floral_tonics_and_tinctures","nausea_tonic_drink"), existingFileHelper);

    }
}
