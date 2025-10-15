package net.trashelemental.floral_tonics_and_tinctures.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.block.custom.HerbalismTableBlock;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FloralTonicsAndTinctures.MOD_ID);


    public static final RegistryObject<Block> HERBALISM_TABLE = registerblock("herbalism_table",
            () -> new HerbalismTableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));



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
