package net.trashelemental.floral_tonics_and_tinctures.util.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

@Mod.EventBusSubscriber
public class CloverDropHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        BlockState state = event.getState();

        if (!state.is(ModBlocks.CLOVER_PATCH.get())) return;
        if (event.getLevel().isClientSide()) return;

        LevelAccessor level = event.getLevel();
        BlockPos pos = event.getPos();

        if (level.getRandom().nextInt(20) == 0) {
            ItemStack drop = new ItemStack(ModItems.FOUR_LEAF_CLOVER.get());
            Block.popResource((Level) level, pos, drop);
        }
    }
}
