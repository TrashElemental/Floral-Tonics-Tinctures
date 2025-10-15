package net.trashelemental.floral_tonics_and_tinctures.item.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.trashelemental.floral_tonics_and_tinctures.Config;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TonicItem extends Item {

    public TonicItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return Config.TONIC_USE_FAST.get() ? 16 : 32;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return Config.TONIC_MAX_STACK_SIZE.get();
    }


    @Override
    public Component getName(ItemStack stack) {
        List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);

        final String modID = FloralTonicsAndTinctures.MOD_ID;
        final String tonicKey = "item." + modID + ".tonic";
        final String tinctureKey = "item." + modID + ".tincture";

        if (effects.isEmpty()) {
            return Component.translatable(tonicKey + ".empty");
        }

        MobEffectInstance firstEffect = effects.get(0);
        MobEffect effect = firstEffect.getEffect();

        boolean isNegative = effect.getCategory() == MobEffectCategory.HARMFUL;
        Component effectName = Component.translatable(firstEffect.getDescriptionId());

        return Component.translatable(isNegative ? tinctureKey : tonicKey, effectName);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        if (!level.isClientSide) {
            for (MobEffectInstance effect : PotionUtils.getMobEffects(stack)) {
                int duration = effect.getDuration();

                if (Config.TONIC_REDUCED_DURATION.get()) {
                    duration = Math.max(duration / 2, 1);
                }

                MobEffectInstance finalEffect = new MobEffectInstance(
                        effect.getEffect(),
                        duration,
                        effect.getAmplifier(),
                        effect.isAmbient(),
                        effect.isVisible(),
                        effect.showIcon()
                );
                user.addEffect(finalEffect);
            }
        }

        if (user instanceof Player player) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(bottle)) {
                    player.drop(bottle, false);
                }
            }
        }

        user.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        List<MobEffectInstance> effects = new ArrayList<>();
        for (MobEffectInstance effect : PotionUtils.getMobEffects(stack)) {
            int halfDuration = Math.max(effect.getDuration() / 2, 1);
            effects.add(new MobEffectInstance(
                    effect.getEffect(),
                    halfDuration,
                    effect.getAmplifier(),
                    effect.isAmbient(),
                    effect.isVisible(),
                    effect.showIcon()
            ));
        }

        PotionUtils.addPotionTooltip(effects, tooltip, 1.0F);
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        Potion potion = PotionUtils.getPotion(stack);
        if (potion != Potions.EMPTY) {
            return this.getDescriptionId() + "." + BuiltInRegistries.POTION.getKey(potion).getPath();
        }
        return this.getDescriptionId();
    }

    //Can be used to create a tonic with a single effect.
    public static ItemStack withEffect(Potion potion) {
        ItemStack stack = new ItemStack(ModItems.TONIC.get());
        return PotionUtils.setPotion(stack, potion);
    }

    //Can be used to create a tonic with multiple effects.
    public static ItemStack withEffects(Collection<MobEffectInstance> effects) {
        ItemStack stack = new ItemStack(ModItems.TONIC.get());
        return PotionUtils.setCustomEffects(stack, effects);
    }
}

