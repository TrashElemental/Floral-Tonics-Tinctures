package net.trashelemental.floral_tonics_and_tinctures.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FloralTonicsAndTinctures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.FIRE_LILY.get())
                .add(ModBlocks.MOLY.get())
                .add(ModBlocks.HEATHER.get())
                .add(ModBlocks.MILKWEED.get())
                .add(ModBlocks.LAVADROP.get())
                .add(ModBlocks.MIDAS_FINGERS.get())
                .add(ModBlocks.STELLA.get())
        ;

        this.tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_FIRE_LILY.get())
                .add(ModBlocks.POTTED_MOLY.get())
                .add(ModBlocks.POTTED_HEATHER.get())
                .add(ModBlocks.POTTED_MILKWEED.get())
                .add(ModBlocks.POTTED_LAVADROP.get())
                .add(ModBlocks.POTTED_MIDAS_FINGERS.get())
                .add(ModBlocks.POTTED_STELLA.get())
        ;

        this.tag(BlockTags.GUARDED_BY_PIGLINS)
                .add(ModBlocks.MIDAS_FINGERS.get())
                .add(ModBlocks.POTTED_MIDAS_FINGERS.get())
        ;


    }
}
