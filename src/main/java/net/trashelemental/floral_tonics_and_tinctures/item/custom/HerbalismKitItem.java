package net.trashelemental.floral_tonics_and_tinctures.item.custom;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import net.trashelemental.floral_tonics_and_tinctures.menu.custom.herbalism_kit.HerbalismKitMenu;

public class HerbalismKitItem extends Item {
    public HerbalismKitItem(Properties props) {
        super(props.stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            openMenu(serverPlayer, stack);
        }
        player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER, 1, 1.5f);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    // Menu-opening helper (unchanged API, just implemented)
    private void openMenu(ServerPlayer player, ItemStack stack) {
        NetworkHooks.openScreen(player, new SimpleMenuProvider(
                (id, inv, p) -> new HerbalismKitMenu(id, inv, stack),
                stack.getHoverName()
        ), buf -> buf.writeItem(stack));
    }
}