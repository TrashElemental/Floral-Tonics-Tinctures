package net.trashelemental.floral_tonics_and_tinctures.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModTags {

    public static class Blocks {




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, name));
        }
    }

    public static class Biomes {

        public static final TagKey<Biome> FIRE_LILY_BIOMES = tag("fire_lily_biomes");
        public static final TagKey<Biome> HEATHER_BIOMES = tag("heather_biomes");
        public static final TagKey<Biome> MILKWEED_BIOMES = tag("milkweed_biomes");
        public static final TagKey<Biome> CLOVER_BIOMES = tag("clover_biomes");
        public static final TagKey<Biome> MOLY_BIOMES = tag("moly_biomes");
        public static final TagKey<Biome> MIDAS_FINGERS_BIOMES = tag("midas_fingers_biomes");
        public static final TagKey<Biome> LAVADROP_BIOMES = tag("lavadrop_biomes");
        public static final TagKey<Biome> STELLA_BIOMES = tag("stella_biomes");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, name));
        }
    }

    public static class Entities {

        public static final TagKey<EntityType<?>> MAGIC_RESISTANCE_DISPELS = tag("magic_resistance_dispels");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, name));
        }
    }


    public static class Items {

        public static final TagKey<Item> TULIPS = tag("tulips");
        public static final TagKey<Item> HERBALISM_INGREDIENTS = tag("herbalism_ingredients");
        public static final TagKey<Item> HERBALISM_GUI_ALLOWED = tag("herbalism_gui_allowed");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, name));
        }
    }

}
