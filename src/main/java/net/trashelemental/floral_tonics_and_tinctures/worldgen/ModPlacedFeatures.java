package net.trashelemental.floral_tonics_and_tinctures.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.data.worldgen.BootstapContext;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FIRE_LILY_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_fire_lily_placed"));
    public static final ResourceKey<PlacedFeature> HEATHER_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_heather_placed"));
    public static final ResourceKey<PlacedFeature> MILKWEED_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_milkweed_placed"));
    public static final ResourceKey<PlacedFeature> MOLY_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_moly_placed"));

    public static final ResourceKey<PlacedFeature> MIDAS_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_midas_placed"));
    public static final ResourceKey<PlacedFeature> LAVADROP_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_lavadrop_placed"));

    public static final ResourceKey<PlacedFeature> STELLA_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_stella_placed"));

    public static final ResourceKey<PlacedFeature> CLOVER_PATCH =
            ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "patch_clover_placed"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(
                context, FIRE_LILY_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_FIRE_LILY),
                List.of(
                        RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, MILKWEED_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_MILKWEED),
                List.of(
                        RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, HEATHER_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_HEATHER),
                List.of(
                        RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, MOLY_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_MOLY),
                List.of(
                        RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, MIDAS_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_MIDAS),
                List.of(
                        CountPlacement.of(5),
                        InSquarePlacement.spread(),
                        PlacementUtils.FULL_RANGE,
                        BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, LAVADROP_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_LAVADROP),
                List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.FULL_RANGE,
                        BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, STELLA_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_STELLA),
                List.of(
                        RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()
                )
        );

        PlacementUtils.register(
                context, CLOVER_PATCH, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_CLOVER),
                List.of(
                        RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
                )
        );
    }
}
