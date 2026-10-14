package net.trashelemental.floral_tonics_and_tinctures.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FloralTonicsAndTinctures.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleFlower(ModBlocks.FIRE_LILY.get());
        simplePottedFlower(ModBlocks.POTTED_FIRE_LILY.get(), ModBlocks.FIRE_LILY.get());
        simpleFlower(ModBlocks.HEATHER.get());
        simplePottedFlower(ModBlocks.POTTED_HEATHER.get(), ModBlocks.HEATHER.get());
        simpleFlower(ModBlocks.MILKWEED.get());
        simplePottedFlower(ModBlocks.POTTED_MILKWEED.get(), ModBlocks.MILKWEED.get());
        simpleFlower(ModBlocks.MOLY.get());
        simplePottedFlower(ModBlocks.POTTED_MOLY.get(), ModBlocks.MOLY.get());
        simpleFlower(ModBlocks.LAVADROP.get());
        simplePottedFlower(ModBlocks.POTTED_LAVADROP.get(), ModBlocks.LAVADROP.get());
        simpleFlower(ModBlocks.MIDAS_FINGERS.get());
        simplePottedFlower(ModBlocks.POTTED_MIDAS_FINGERS.get(), ModBlocks.MIDAS_FINGERS.get());
        simpleFlower(ModBlocks.STELLA.get());
        simplePottedFlower(ModBlocks.POTTED_STELLA.get(), ModBlocks.STELLA.get());

    }

    private void blockItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(FloralTonicsAndTinctures.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void BlockWithItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void simpleFlower(Block flower) {
        simpleBlockWithItem(flower, models().cross(name(flower), blockTexture(flower)).renderType("cutout"));
    }

    private void simplePottedFlower(Block potted, Block flower) {
        simpleBlock(potted, models().singleTexture(name(potted), new ResourceLocation("flower_pot_cross"),
                "plant", blockTexture(flower)).renderType("cutout"));
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
