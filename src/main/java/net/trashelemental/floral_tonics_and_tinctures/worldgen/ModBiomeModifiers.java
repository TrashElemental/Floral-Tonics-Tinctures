package net.trashelemental.floral_tonics_and_tinctures.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.util.ModTags;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> FIRE_LILY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_fire_lily"));
    public static final ResourceKey<BiomeModifier> HEATHER =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_heather"));
    public static final ResourceKey<BiomeModifier> MILKWEED =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_milkweed"));
    public static final ResourceKey<BiomeModifier> MOLY =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_moly"));
    public static final ResourceKey<BiomeModifier> MIDAS =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_midas"));
    public static final ResourceKey<BiomeModifier> LAVADROP =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_lavadrop"));
    public static final ResourceKey<BiomeModifier> STELLA =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_stella"));
    public static final ResourceKey<BiomeModifier> CLOVER =
            ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                    new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, "add_clover"));



    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);


        context.register(FIRE_LILY,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.FIRE_LILY_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.FIRE_LILY_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(MILKWEED,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.MILKWEED_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.MILKWEED_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(HEATHER,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.HEATHER_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.HEATHER_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(MOLY,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.MOLY_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.MOLY_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(MIDAS,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.MIDAS_FINGERS_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.MIDAS_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(LAVADROP,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.LAVADROP_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.LAVADROP_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(STELLA,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.STELLA_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.STELLA_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(CLOVER,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModTags.Biomes.CLOVER_BIOMES),
                        HolderSet.direct(placed.getOrThrow(ModPlacedFeatures.CLOVER_PATCH)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));



    }
}
