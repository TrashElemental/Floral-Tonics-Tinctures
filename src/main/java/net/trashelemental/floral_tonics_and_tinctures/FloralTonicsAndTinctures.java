package net.trashelemental.floral_tonics_and_tinctures;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.entity.ModEntities;
import net.trashelemental.floral_tonics_and_tinctures.item.ModCreativeModeTabs;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.magic.brewing.ModPotions;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;
import net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.ModEnchantments;
import net.trashelemental.floral_tonics_and_tinctures.menu.ModMenuTypes;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.HerbalismTableScreen;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.herbalism_kit.HerbalismKitScreen;
import net.trashelemental.floral_tonics_and_tinctures.particle.ModParticles;
import net.trashelemental.floral_tonics_and_tinctures.util.ModItemProperties;
import net.trashelemental.floral_tonics_and_tinctures.util.event.AddTonicsToCreativeTabEvent;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipeTypes;
import net.trashelemental.floral_tonics_and_tinctures.util.recipe.ModRecipes;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(FloralTonicsAndTinctures.MOD_ID)
public class FloralTonicsAndTinctures
{
    public static final String MOD_ID = "floral_tonics_and_tinctures";

    private static final Logger LOGGER = LogUtils.getLogger();

    public FloralTonicsAndTinctures()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModPotions.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.SERIALIZERS.register(modEventBus);
        ModRecipeTypes.TYPES.register(modEventBus);
        ModParticles.PARTICLES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FIRE_LILY.getId(), ModBlocks.POTTED_FIRE_LILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HEATHER.getId(), ModBlocks.POTTED_HEATHER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MILKWEED.getId(), ModBlocks.POTTED_MILKWEED);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MOLY.getId(), ModBlocks.POTTED_MOLY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LAVADROP.getId(), ModBlocks.POTTED_LAVADROP);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MIDAS_FINGERS.getId(), ModBlocks.POTTED_MIDAS_FINGERS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.STELLA.getId(), ModBlocks.POTTED_STELLA);
        });

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
    
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            ModItemProperties.registerCustomItemProperties();
            MenuScreens.register(ModMenuTypes.HERBALISM_TABLE.get(), HerbalismTableScreen::new);
            MenuScreens.register(ModMenuTypes.HERBALISM_KIT.get(), HerbalismKitScreen::new);

        }
    }


    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tickDelay, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tickDelay));
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actionsToRun = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() <= 0) {
                    actionsToRun.add(work);
                }
            });
            actionsToRun.forEach(work -> work.getKey().run());
            workQueue.removeAll(actionsToRun);
        }
    }
}
