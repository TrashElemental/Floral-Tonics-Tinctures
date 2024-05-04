package net.mcreator.floraltonicsandtinctures.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.NonNullList;

import net.mcreator.floraltonicsandtinctures.jei_recipes.JEIHerbalismRecipeTypeRecipe;

import java.util.stream.Collectors;
import java.util.function.Supplier;
import java.util.Map;
import java.util.List;

public class HerbalismTableGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double outputslot = 0;
		ItemStack result = ItemStack.EMPTY;
		outputslot = 21;
		result = (new Object() {
			public ItemStack getResult() {
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<JEIHerbalismRecipeTypeRecipe> recipes = rm.getAllRecipesFor(JEIHerbalismRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
					for (JEIHerbalismRecipeTypeRecipe recipe : recipes) {
						NonNullList<Ingredient> ingredients = recipe.getIngredients();
						if (!ingredients.get(0).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(19)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(1).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(18)).getItem() : ItemStack.EMPTY)))
							continue;
						if (!ingredients.get(2).test((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(20)).getItem() : ItemStack.EMPTY)))
							continue;
						return recipe.getResultItem(null);
					}
				}
				return ItemStack.EMPTY;
			}
		}.getResult());
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = result.copy();
			_setstack.setCount(1);
			((Slot) _slots.get((int) outputslot)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}
