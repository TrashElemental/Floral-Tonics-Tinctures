package net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class FloralGiftEnchantment extends Enchantment {

    public FloralGiftEnchantment(EquipmentSlot... slots) {super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);}

    @Override
    public int getMaxLevel() {
        return 3;
    }


}
