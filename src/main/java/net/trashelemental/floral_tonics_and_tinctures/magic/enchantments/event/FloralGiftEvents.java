package net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.event;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.magic.enchantments.ModEnchantments;
import net.trashelemental.floral_tonics_and_tinctures.util.ModTags;

import java.util.List;
import java.util.Optional;

@Mod.EventBusSubscriber
public class FloralGiftEvents {

    /**
     * When an entity is killed by an attacker that is wielding a weapon enchanted with Floral Gift, the slain entity
     * has a chance to drop an item from the herbalism ingredients tag in addition to their normal loot. The base chance
     * is 40%, plus an additional 10% for each level of the enchantment above 1.
     */
    @SubscribeEvent
    public static void FloralGiftActivateEvent(LivingDeathEvent event) {

        if (!(event.getSource().getEntity() instanceof LivingEntity entity)) return;
        if (!(entity.level() instanceof ServerLevel level)) return;
        if (!(level.getGameRules().getRule(GameRules.RULE_DOMOBLOOT).get())) return;

        ItemStack weapon = entity.getItemBySlot(EquipmentSlot.MAINHAND);
        if (weapon.isEmpty() || (!(weapon.isEnchanted()))) return;

        int enchantmentLevel = weapon.getEnchantmentLevel(ModEnchantments.FLORAL_GIFT.get());
        if (enchantmentLevel <= 0) return;

        float activationChance = 0.4f + (0.1f * (enchantmentLevel - 1));

        if (entity.getRandom().nextFloat() > activationChance) return;

        Optional<Item> randomItem = getRandomItemFromTag(level, ModTags.Items.HERBALISM_INGREDIENTS);
        if (randomItem.isEmpty()) return;

        ItemStack drop = new ItemStack(randomItem.get());
        event.getEntity().spawnAtLocation(drop);
    }

    private static Optional<Item> getRandomItemFromTag(ServerLevel level, TagKey<Item> tagKey) {
        Registry<Item> itemRegistry = level.registryAccess().registryOrThrow(Registries.ITEM);
        HolderSet.Named<Item> tagSet = itemRegistry.getTag(tagKey).orElse(null);

        if (tagSet == null || tagSet.size() == 0) {
            System.out.println("Tag " + tagKey.location() + " is empty or missing.");
            return Optional.empty();
        }

        List<Item> items = tagSet.stream().map(Holder::value).toList();
        Item randomItem = items.get(level.random.nextInt(items.size()));
        return Optional.of(randomItem);
    }

}

