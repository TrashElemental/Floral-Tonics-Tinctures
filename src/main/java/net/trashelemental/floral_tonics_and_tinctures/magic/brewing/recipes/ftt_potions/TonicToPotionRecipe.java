package net.trashelemental.floral_tonics_and_tinctures.magic.brewing.recipes.ftt_potions;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;
import net.trashelemental.floral_tonics_and_tinctures.magic.brewing.ModPotions;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TonicToPotionRecipe implements IBrewingRecipe {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> BrewingRecipeRegistry.addRecipe(new TonicToPotionRecipe()));
    }

    @Override
    public boolean isInput(ItemStack input) {
        if (!input.is(ModItems.TONIC.get())) return false;

        Potion potion = PotionUtils.getPotion(input);
        return potion != Potions.EMPTY;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.is(Items.NETHER_WART);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if (!isInput(input) || !isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        Potion potion = PotionUtils.getPotion(input);

        ItemStack result = new ItemStack(Items.POTION);
        PotionUtils.setPotion(result, potion);

        return result;
    }
}

