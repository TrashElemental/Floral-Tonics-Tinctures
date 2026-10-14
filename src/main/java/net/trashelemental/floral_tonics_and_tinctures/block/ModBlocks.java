package net.trashelemental.floral_tonics_and_tinctures.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.custom.*;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FloralTonicsAndTinctures.MOD_ID);


    public static final RegistryObject<Block> HERBALISM_TABLE = registerblock("herbalism_table",
            () -> new HerbalismTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    //Flowers
    public static final RegistryObject<Block> FIRE_LILY = registerblock("fire_lily",
            () -> new FlowerBlock(() -> ModMobEffects.FIERY.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_FIRE_LILY = BLOCKS.register("potted_fire_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.FIRE_LILY,
                     BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> HEATHER = registerblock("heather",
            () -> new FlowerBlock(() -> ModMobEffects.FROSTY.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_HEATHER = BLOCKS.register("potted_heather",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.HEATHER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> MILKWEED = registerblock("milkweed",
            () -> new FlowerBlock(() -> ModMobEffects.PURIFYING.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_MILKWEED = BLOCKS.register("potted_milkweed",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MILKWEED,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> MOLY = registerblock("moly",
            () -> new FlowerBlock(() -> ModMobEffects.MAGIC_RESISTANCE.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_MOLY = BLOCKS.register("potted_moly",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MOLY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> MIDAS_FINGERS = registerblock("midas_fingers",
            () -> new MidasFlowerBlock(() -> ModMobEffects.GOLD_RUSH.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_MIDAS_FINGERS = BLOCKS.register("potted_midas_fingers",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MIDAS_FINGERS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> LAVADROP = registerblock("lavadrop",
            () -> new LavadropFlowerBlock(() -> ModMobEffects.VOLATILITY.get(), 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_LAVADROP = BLOCKS.register("potted_lavadrop",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.LAVADROP,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion().lightLevel(state -> 15)));

    public static final RegistryObject<Block> STELLA = registerblock("stella",
            () -> new EndFlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 10,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));
    public static final RegistryObject<Block> POTTED_STELLA = BLOCKS.register("potted_stella",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.STELLA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion().lightLevel(state -> 15)));

    //Other Foliage
    public static final RegistryObject<Block> CLOVER_PATCH = registerblock("clover_patch",
            () -> new CloverPatchBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).noOcclusion().noCollission()));


    private static <T extends Block>RegistryObject<T> registerblock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerblockitem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerblockitem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
