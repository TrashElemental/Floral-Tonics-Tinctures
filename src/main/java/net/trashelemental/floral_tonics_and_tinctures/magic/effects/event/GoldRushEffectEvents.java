package net.trashelemental.floral_tonics_and_tinctures.magic.effects.event;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.util.List;

@Mod.EventBusSubscriber
public class GoldRushEffectEvents {

    private static final RandomSource random = RandomSource.create();

    /**
     * Slows armor durability loss when taking damage.
     */
    @SubscribeEvent
    public static void onArmorDamaged(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        MobEffect effect = ModMobEffects.GOLD_RUSH.get();

        if (!entity.hasEffect(effect)) return;
        if (entity.level().isClientSide) return;

        int amplifier = entity.getEffect(effect).getAmplifier();

        for (ItemStack armor : entity.getArmorSlots()) {
            if (armor.getItem() instanceof ArmorItem ai && ai.getMaterial() == ArmorMaterials.GOLD) {
                slowDurabilityLoss(armor, entity, amplifier);
            }
        }
    }

    /**
     * Slow tool durability loss when attacking.
     */
    @SubscribeEvent
    public static void onToolUse(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        MobEffect effect = ModMobEffects.GOLD_RUSH.get();
        if (!player.hasEffect(effect)) return;
        if (player.level().isClientSide) return;

        int amplifier = player.getEffect(effect).getAmplifier();

        ItemStack tool = player.getMainHandItem();
        if (tool.is(ItemTags.PIGLIN_LOVED)) {
            slowDurabilityLoss(tool, player, amplifier);
        }
    }

    /**
     * Deal bonus damage with gold tools and increase damage negation with gold armor.
     */
    @SubscribeEvent
    public static void onDamage(LivingDamageEvent event) {

        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof  LivingEntity attacker)) return;
        MobEffect effect = ModMobEffects.GOLD_RUSH.get();
        if ((!target.hasEffect(effect)) && !(attacker.hasEffect(effect))) return;
        if (target.level().isClientSide) return;

        if (target.hasEffect(effect)) {
            int amplifier = target.getEffect(effect).getAmplifier();
            boolean hasGoldArmor = false;

            for (ItemStack armor : target.getArmorSlots()) {
                if (armor.getItem() instanceof ArmorItem ai && ai.getMaterial() == ArmorMaterials.GOLD) {
                    hasGoldArmor = true;
                    break;
                }
            }

            if (hasGoldArmor) {
                float reduction = 0.8f - (0.1f * amplifier);
                reduction = Math.max(0.0f, reduction);
                event.setAmount(event.getAmount() * reduction);
            }
        }

        if (attacker.hasEffect(effect)) {
            int amplifier = attacker.getEffect(effect).getAmplifier();
            boolean hasGoldTool = false;

            ItemStack tool = attacker.getMainHandItem();
            if (tool.is(ItemTags.PIGLIN_LOVED)) {
                hasGoldTool = true;
            }

            if (hasGoldTool) {
                float increase = 1.5f + (0.25f * amplifier);
                event.setAmount(event.getAmount() * increase);
            }
        }
    }

    /**
     * Slow durability loss when mining, and add a virtual level of looting for gold tools.
     */
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;
        MobEffect effect = ModMobEffects.GOLD_RUSH.get();
        if (!player.hasEffect(effect)) return;
        if (player.level().isClientSide) return;


        int amplifier = player.getEffect(effect).getAmplifier();
        ItemStack tool = player.getMainHandItem();
        if (!tool.is(ItemTags.PIGLIN_LOVED)) return;
        BlockState state = event.getState();


        slowDurabilityLoss(tool, player, amplifier);

        if (!state.is(Tags.Blocks.ORES)) return;

        if (random.nextFloat() < 0.33f) {
            int multiplier = 2 * (1 + amplifier);

            Level world = player.level();
            if (!(world instanceof ServerLevel serverWorld)) return;

            BlockPos pos = event.getPos();

            LootParams.Builder paramsBuilder = new LootParams.Builder(serverWorld)
                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                    .withParameter(LootContextParams.TOOL, tool)
                    .withOptionalParameter(LootContextParams.BLOCK_ENTITY, world.getBlockEntity(pos));

            for (int i = 0; i < multiplier; i++) {
                List<ItemStack> drops = state.getDrops(paramsBuilder);
                for (ItemStack drop : drops) {
                    Block.popResource(world, pos, drop);
                }
            }
        }
    }

    /**
     * Give one free looting level while this effect is active while using gold tools.
     */
    @SubscribeEvent
    public static void onKilledEntity(LivingDeathEvent event) {
        Entity attackerEntity = event.getSource().getEntity();
        if (!(attackerEntity instanceof LivingEntity attacker)) return;

        MobEffect effect = ModMobEffects.GOLD_RUSH.get();
        if (!attacker.hasEffect(effect)) return;

        int amplifier = attacker.getEffect(effect).getAmplifier();
        RandomSource random = attacker.getRandom();

        ItemStack weapon = attacker instanceof Player player ? player.getMainHandItem() : ItemStack.EMPTY;
        if (!weapon.is(ItemTags.PIGLIN_LOVED)) return;

        LivingEntity target = event.getEntity();
        if (random.nextFloat() >= 0.33f) return;

        int multiplier = 2 * (1 + amplifier);
        ServerLevel serverLevel = (ServerLevel) attacker.level();

        for (int i = 0; i < multiplier; i++) {
            ResourceLocation lootTableKey = target.getLootTable();
            LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(lootTableKey);

            LootParams.Builder lootParamsBuilder = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.THIS_ENTITY, target)
                    .withParameter(LootContextParams.ORIGIN, target.position())
                    .withParameter(LootContextParams.KILLER_ENTITY, attacker)
                    .withOptionalParameter(LootContextParams.DAMAGE_SOURCE, event.getSource());

            LootParams lootParams = lootParamsBuilder.create(LootContextParamSets.ENTITY);
            lootTable.getRandomItems(lootParams, target.getLootTableSeed(), target::spawnAtLocation);
        }
    }


    private static void slowDurabilityLoss(ItemStack itemStack, LivingEntity entity, int amplifier) {
        RandomSource random = entity.getRandom();

        if (random.nextFloat() < (0.5f + (0.15 * (amplifier + 1)))) {
            int currentDamage = itemStack.getDamageValue();
            itemStack.setDamageValue(Math.max(0, currentDamage - 1));
        }
    }
}
