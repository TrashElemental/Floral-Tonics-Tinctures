
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.floraltonicsandtinctures.item.inventory.HerbalismKitInventoryCapability;
import net.mcreator.floraltonicsandtinctures.item.HerbalismKitItem;
import net.mcreator.floraltonicsandtinctures.item.FTTWeaknessTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTWaterBreathingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTVibingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTVanillaScentItem;
import net.mcreator.floraltonicsandtinctures.item.FTTToxicTouchItem;
import net.mcreator.floraltonicsandtinctures.item.FTTThirdEyeTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTSwiftnessItem;
import net.mcreator.floraltonicsandtinctures.item.FTTSunscreenTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTStrengthTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTSpellDamageTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTSlownessTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTSlowFallingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTRepellenceTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTRegenItem;
import net.mcreator.floraltonicsandtinctures.item.FTTRampageTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTRageTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTPurifyingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTProtectionOfTheHiveItem;
import net.mcreator.floraltonicsandtinctures.item.FTTPricklyTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTPoisonTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTPintCharismaItem;
import net.mcreator.floraltonicsandtinctures.item.FTTParalyzedTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTNightVisionTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTNeapolitanInstantHealth2Item;
import net.mcreator.floraltonicsandtinctures.item.FTTNeapolitanInstantHealth1Item;
import net.mcreator.floraltonicsandtinctures.item.FTTNauseaTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTManaRegenTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTLuckTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTLevitationTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTLeapingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTKnockbackResistanceTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTInvisibilityItem;
import net.mcreator.floraltonicsandtinctures.item.FTTIntoxicationTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTHealingTouchItem;
import net.mcreator.floraltonicsandtinctures.item.FTTHasteTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTHarmonyTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTGlowingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTFireResistanceTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTDolphinsGraceTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTDeepsightTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTDecayTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTDamageTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTBugPheromonesTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTBlindnessTinctureItem;
import net.mcreator.floraltonicsandtinctures.item.FTTBerserkingTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTArmorTonicItem;
import net.mcreator.floraltonicsandtinctures.item.FTTAgilityTonicItem;
import net.mcreator.floraltonicsandtinctures.item.CompatIconItem;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FloralTonicsAndTincturesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<Item, Item> FTT_FIRE_RESISTANCE_TONIC = REGISTRY.register("ftt_fire_resistance_tonic", () -> new FTTFireResistanceTonicItem());
	public static final DeferredHolder<Item, Item> FTT_INVISIBILITY_TONIC = REGISTRY.register("ftt_invisibility_tonic", () -> new FTTInvisibilityItem());
	public static final DeferredHolder<Item, Item> FTT_SWIFTNESS_TONIC = REGISTRY.register("ftt_swiftness_tonic", () -> new FTTSwiftnessItem());
	public static final DeferredHolder<Item, Item> FTT_REGENERATION_TONIC = REGISTRY.register("ftt_regeneration_tonic", () -> new FTTRegenItem());
	public static final DeferredHolder<Item, Item> FTT_NIGHT_VISION_TONIC = REGISTRY.register("ftt_night_vision_tonic", () -> new FTTNightVisionTonicItem());
	public static final DeferredHolder<Item, Item> FTT_LEAPING_TONIC = REGISTRY.register("ftt_leaping_tonic", () -> new FTTLeapingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_WATER_BREATHING_TONIC = REGISTRY.register("ftt_water_breathing_tonic", () -> new FTTWaterBreathingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_WEAKNESS_TINCTURE = REGISTRY.register("ftt_weakness_tincture", () -> new FTTWeaknessTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_SLOWNESS_TINCTURE = REGISTRY.register("ftt_slowness_tincture", () -> new FTTSlownessTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_POISON_TINCTURE = REGISTRY.register("ftt_poison_tincture", () -> new FTTPoisonTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_DECAY_TINCTURE = REGISTRY.register("ftt_decay_tincture", () -> new FTTDecayTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_BLINDNESS_TINCTURE = REGISTRY.register("ftt_blindness_tincture", () -> new FTTBlindnessTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_LUCK_TONIC = REGISTRY.register("ftt_luck_tonic", () -> new FTTLuckTonicItem());
	public static final DeferredHolder<Item, Item> FTT_STRENGTH_TONIC = REGISTRY.register("ftt_strength_tonic", () -> new FTTStrengthTonicItem());
	public static final DeferredHolder<Item, Item> FTT_SLOW_FALLING_TONIC = REGISTRY.register("ftt_slow_falling_tonic", () -> new FTTSlowFallingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_LEVITATION_TINCTURE = REGISTRY.register("ftt_levitation_tincture", () -> new FTTLevitationTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_DOLPHINS_GRACE_TONIC = REGISTRY.register("ftt_dolphins_grace_tonic", () -> new FTTDolphinsGraceTonicItem());
	public static final DeferredHolder<Item, Item> FTT_GLOWING_TONIC = REGISTRY.register("ftt_glowing_tonic", () -> new FTTGlowingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_HASTE_TONIC = REGISTRY.register("ftt_haste_tonic", () -> new FTTHasteTonicItem());
	public static final DeferredHolder<Item, Item> FTT_PRICKLY_TONIC = REGISTRY.register("ftt_prickly_tonic", () -> new FTTPricklyTonicItem());
	public static final DeferredHolder<Item, Item> FTT_NAUSEA_TINCTURE = REGISTRY.register("ftt_nausea_tincture", () -> new FTTNauseaTinctureItem());
	public static final DeferredHolder<Item, Item> HERBALISM_KIT = REGISTRY.register("herbalism_kit", () -> new HerbalismKitItem());
	public static final DeferredHolder<Item, Item> HERBALISM_TABLE = block(FloralTonicsAndTincturesModBlocks.HERBALISM_TABLE);
	public static final DeferredHolder<Item, Item> FTT_SPELL_DAMAGE_TONIC = REGISTRY.register("ftt_spell_damage_tonic", () -> new FTTSpellDamageTonicItem());
	public static final DeferredHolder<Item, Item> FTT_MANA_REGEN_TONIC = REGISTRY.register("ftt_mana_regen_tonic", () -> new FTTManaRegenTonicItem());
	public static final DeferredHolder<Item, Item> FTT_DEEPSIGHT_TONIC = REGISTRY.register("ftt_deepsight_tonic", () -> new FTTDeepsightTonicItem());
	public static final DeferredHolder<Item, Item> FTT_BUG_PHEROMONES_TONIC = REGISTRY.register("ftt_bug_pheromones_tonic", () -> new FTTBugPheromonesTonicItem());
	public static final DeferredHolder<Item, Item> FTT_RAGE_TONIC = REGISTRY.register("ftt_rage_tonic", () -> new FTTRageTonicItem());
	public static final DeferredHolder<Item, Item> FTT_KNOCKBACK_RESISTANCE_TONIC = REGISTRY.register("ftt_knockback_resistance_tonic", () -> new FTTKnockbackResistanceTonicItem());
	public static final DeferredHolder<Item, Item> FTT_INTOXICATION_TINCTURE = REGISTRY.register("ftt_intoxication_tincture", () -> new FTTIntoxicationTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_RAMPAGE_TONIC = REGISTRY.register("ftt_rampage_tonic", () -> new FTTRampageTonicItem());
	public static final DeferredHolder<Item, Item> FTT_ARMOR_TONIC = REGISTRY.register("ftt_armor_tonic", () -> new FTTArmorTonicItem());
	public static final DeferredHolder<Item, Item> FTT_DAMAGE_TONIC = REGISTRY.register("ftt_damage_tonic", () -> new FTTDamageTonicItem());
	public static final DeferredHolder<Item, Item> FTT_PINT_CHARISMA = REGISTRY.register("ftt_pint_charisma", () -> new FTTPintCharismaItem());
	public static final DeferredHolder<Item, Item> FTT_HEALING_TOUCH = REGISTRY.register("ftt_healing_touch", () -> new FTTHealingTouchItem());
	public static final DeferredHolder<Item, Item> FTT_TOXIC_TOUCH = REGISTRY.register("ftt_toxic_touch", () -> new FTTToxicTouchItem());
	public static final DeferredHolder<Item, Item> FTT_PROTECTION_OF_THE_HIVE = REGISTRY.register("ftt_protection_of_the_hive", () -> new FTTProtectionOfTheHiveItem());
	public static final DeferredHolder<Item, Item> COMPAT_ICON = REGISTRY.register("compat_icon", () -> new CompatIconItem());
	public static final DeferredHolder<Item, Item> FTT_PURIFYING_TONIC = REGISTRY.register("ftt_purifying_tonic", () -> new FTTPurifyingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_SUNSCREEN_TONIC = REGISTRY.register("ftt_sunscreen_tonic", () -> new FTTSunscreenTonicItem());
	public static final DeferredHolder<Item, Item> FTT_THIRD_EYE_TONIC = REGISTRY.register("ftt_third_eye_tonic", () -> new FTTThirdEyeTonicItem());
	public static final DeferredHolder<Item, Item> FTT_VIBING_TONIC = REGISTRY.register("ftt_vibing_tonic", () -> new FTTVibingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_REPELLENCE_TINCTURE = REGISTRY.register("ftt_repellence_tincture", () -> new FTTRepellenceTinctureItem());
	public static final DeferredHolder<Item, Item> FTT_AGILITY_TONIC = REGISTRY.register("ftt_agility_tonic", () -> new FTTAgilityTonicItem());
	public static final DeferredHolder<Item, Item> FTT_BERSERKING_TONIC = REGISTRY.register("ftt_berserking_tonic", () -> new FTTBerserkingTonicItem());
	public static final DeferredHolder<Item, Item> FTT_HARMONY_TONIC = REGISTRY.register("ftt_harmony_tonic", () -> new FTTHarmonyTonicItem());
	public static final DeferredHolder<Item, Item> FTT_VANILLA_SCENT_TONIC = REGISTRY.register("ftt_vanilla_scent_tonic", () -> new FTTVanillaScentItem());
	public static final DeferredHolder<Item, Item> FTT_NEAPOLITAN_INSTANT_HEALTH_1 = REGISTRY.register("ftt_neapolitan_instant_health_1", () -> new FTTNeapolitanInstantHealth1Item());
	public static final DeferredHolder<Item, Item> FTT_NEAPOLITAN_INSTANT_HEALTH_2 = REGISTRY.register("ftt_neapolitan_instant_health_2", () -> new FTTNeapolitanInstantHealth2Item());
	public static final DeferredHolder<Item, Item> FTT_PARALYZED_TINCTURE = REGISTRY.register("ftt_paralyzed_tincture", () -> new FTTParalyzedTinctureItem());
	// Start of user code block custom items
	// End of user code block custom items
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<HerbalismKitInventoryCapability>> HERBALISM_KIT_INVENTORY = ATTACHMENT_TYPES.register("herbalism_kit_inventory",
			() -> AttachmentType.serializable(HerbalismKitInventoryCapability::new).build());

	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
		ATTACHMENT_TYPES.register(bus);
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> stack.getData(HERBALISM_KIT_INVENTORY), HERBALISM_KIT.get());
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
