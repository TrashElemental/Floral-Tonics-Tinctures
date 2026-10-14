package net.trashelemental.floral_tonics_and_tinctures.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FIRE_LILY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_fire_lily"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HEATHER =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_heather"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MILKWEED =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_milkweed"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MOLY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_moly"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MIDAS =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_midas"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LAVADROP =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_lavadrop"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STELLA =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_stella"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CLOVER =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_clover"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        BlockStateProvider fireLily = BlockStateProvider.simple(ModBlocks.FIRE_LILY.get());
        SimpleBlockConfiguration blockConfig = new SimpleBlockConfiguration(fireLily);
        RandomPatchConfiguration patchConfig = new RandomPatchConfiguration(
                12, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, blockConfig));
        FeatureUtils.register(context, PATCH_FIRE_LILY, Feature.FLOWER, patchConfig);

        BlockStateProvider milkweed = BlockStateProvider.simple(ModBlocks.MILKWEED.get());
        SimpleBlockConfiguration milkweedConfig = new SimpleBlockConfiguration(milkweed);
        RandomPatchConfiguration milkweedPatch = new RandomPatchConfiguration(
                12, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, milkweedConfig));
        FeatureUtils.register(context, PATCH_MILKWEED, Feature.FLOWER, milkweedPatch);

        BlockStateProvider heather = BlockStateProvider.simple(ModBlocks.HEATHER.get());
        SimpleBlockConfiguration heatherConfig = new SimpleBlockConfiguration(heather);
        RandomPatchConfiguration heatherPatch = new RandomPatchConfiguration(
                12, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, heatherConfig));
        FeatureUtils.register(context, PATCH_HEATHER, Feature.FLOWER, heatherPatch);

        BlockStateProvider moly = BlockStateProvider.simple(ModBlocks.MOLY.get());
        SimpleBlockConfiguration molyConfig = new SimpleBlockConfiguration(moly);
        RandomPatchConfiguration molyPatch = new RandomPatchConfiguration(
                3, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, molyConfig));
        FeatureUtils.register(context, PATCH_MOLY, Feature.FLOWER, molyPatch);

        BlockStateProvider midas = BlockStateProvider.simple(ModBlocks.MIDAS_FINGERS.get());
        SimpleBlockConfiguration midasConfig = new SimpleBlockConfiguration(midas);
        RandomPatchConfiguration midasPatch = new RandomPatchConfiguration(
                16, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, midasConfig));
        FeatureUtils.register(context, PATCH_MIDAS, Feature.FLOWER, midasPatch);

        BlockStateProvider lavadrop = BlockStateProvider.simple(ModBlocks.LAVADROP.get());
        SimpleBlockConfiguration lavadropConfig = new SimpleBlockConfiguration(lavadrop);
        RandomPatchConfiguration lavadropPatch = new RandomPatchConfiguration(
                6, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, lavadropConfig));
        FeatureUtils.register(context, PATCH_LAVADROP, Feature.FLOWER, lavadropPatch);

        BlockStateProvider stella = BlockStateProvider.simple(ModBlocks.STELLA.get());
        SimpleBlockConfiguration stellaConfig = new SimpleBlockConfiguration(stella);
        RandomPatchConfiguration stellaPatch = new RandomPatchConfiguration(
                8, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, stellaConfig));
        FeatureUtils.register(context, PATCH_STELLA, Feature.FLOWER, stellaPatch);

        BlockStateProvider clover = BlockStateProvider.simple(ModBlocks.CLOVER_PATCH.get());
        SimpleBlockConfiguration cloverConfig = new SimpleBlockConfiguration(clover);
        RandomPatchConfiguration cloverPatch = new RandomPatchConfiguration(
                10, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, cloverConfig));
        FeatureUtils.register(context, PATCH_CLOVER, Feature.FLOWER, cloverPatch);
    }
}
