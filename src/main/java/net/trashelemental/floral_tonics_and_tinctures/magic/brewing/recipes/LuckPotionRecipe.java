package net.trashelemental.floral_tonics_and_tinctures.magic.brewing.recipes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.TonicItem;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LuckPotionRecipe implements IBrewingRecipe {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new LuckPotionRecipe()));
    }

    @Override
    public boolean isInput(ItemStack input) {
        Item inputItem = input.getItem();
        return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION)
                && PotionUtils.getPotion(input) == Potions.AWKWARD;
    }

    private final ItemStack tonicOfLuck = TonicItem.withEffect(Potions.LUCK);

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ItemStack.isSameItemSameTags(ingredient, tonicOfLuck);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (isInput(input) && isIngredient(ingredient)) {
            return PotionUtils.setPotion(new ItemStack(input.getItem()), Potions.LUCK);
        }
        return ItemStack.EMPTY;
    }
}