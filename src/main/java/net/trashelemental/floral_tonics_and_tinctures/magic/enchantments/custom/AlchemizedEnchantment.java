package net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AlchemizedEnchantment extends Enchantment {

    public AlchemizedEnchantment(EquipmentSlot... slots) {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
