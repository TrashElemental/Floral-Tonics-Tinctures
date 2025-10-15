package net.trashelemental.floral_tonics_and_tinctures.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.HerbalismTableMenu;

public class HerbalismTableBlock extends Block {
    public HerbalismTableBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            MenuProvider provider = new SimpleMenuProvider((windowId, playerInv, p) ->
                    new HerbalismTableMenu(windowId, playerInv, ContainerLevelAccess.create(level, pos)),
                    Component.translatable("container.floral_tonics_and_tinctures.herbalism_table"));
            player.openMenu(provider);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
