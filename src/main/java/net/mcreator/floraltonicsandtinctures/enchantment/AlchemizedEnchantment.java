
package net.mcreator.floraltonicsandtinctures.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class AlchemizedEnchantment extends Enchantment {
	public AlchemizedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}
}
