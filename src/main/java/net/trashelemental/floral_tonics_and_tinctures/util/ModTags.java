package net.trashelemental.floral_tonics_and_tinctures.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModTags {

    public static class Blocks {




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FloralTonicsAndTinctures.MOD_ID, name));
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
