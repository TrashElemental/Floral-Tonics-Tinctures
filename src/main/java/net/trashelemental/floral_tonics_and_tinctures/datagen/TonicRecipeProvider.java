package net.trashelemental.floral_tonics_and_tinctures.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.floral_tonics_and_tinctures.magic.brewing.ModPotions;
import net.trashelemental.floral_tonics_and_tinctures.magic.effects.ModMobEffects;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class TonicRecipeProvider implements DataProvider {

    private final PackOutput output;
    private final String modid;

    public static int veryShortDuration = 20 * 20;
    public static int shortDuration = 45 * 20;
    public static int mediumDuration = 90 * 20;
    public static int longDuration = 180 * 20;

    public TonicRecipeProvider(PackOutput output, String modid) {
        this.output = output;
        this.modid = modid;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        CompletableFuture<?>[] tasks = new CompletableFuture<?>[] {

                //Vanilla Effect Recipes
                saveRecipe(cache, "invisibility", tonicFromPositivePotion(Items.PEONY, Potions.INVISIBILITY)),
                saveRecipe(cache, "leaping", tonicFromPositivePotion(Items.CORNFLOWER, Potions.LEAPING)),
                saveRecipe(cache, "luck", tonicFromPositivePotion(Items.ROSE_BUSH, Potions.LUCK)),
                saveRecipe(cache, "night_vision", tonicFromPositivePotion(Items.POPPY, Potions.NIGHT_VISION)),
                saveRecipe(cache, "regeneration", tonicFromPositivePotion(Items.OXEYE_DAISY, Potions.REGENERATION)),
                saveRecipe(cache, "slow_falling", tonicFromPositivePotion(Items.LILAC, Potions.SLOW_FALLING)),
                saveRecipe(cache, "strength", tonicFromPositivePotion(Items.CRIMSON_FUNGUS, Potions.STRENGTH)),
                saveRecipe(cache, "swiftness", tonicFromPositivePotion(Items.DANDELION, Potions.SWIFTNESS)),
                saveRecipe(cache, "water_breathing", tonicFromPositivePotion(Items.LILY_PAD, Potions.WATER_BREATHING)),
                saveRecipe(cache, "fire_resistance", tonicFromPositivePotion(Items.ALLIUM, Potions.FIRE_RESISTANCE)),
                saveRecipe(cache, "dolphins_grace", tonicFromPositivePotion(Items.SEA_PICKLE, ModPotions.DOLPHINS_GRACE_POTION.get())),
                saveRecipe(cache, "glowing", tonicFromPositivePotion(Items.GLOW_BERRIES, ModPotions.GLOWING_POTION.get())),
                saveRecipe(cache, "haste", tonicFromPositivePotion(Items.GOLDEN_APPLE, ModPotions.HASTE_POTION.get())),

                saveRecipe(cache, "slowness", tonicFromNegativePotion(Items.BLUE_ORCHID, Potions.SLOWNESS)),
                saveRecipe(cache, "poison", tonicFromNegativePotion(Items.LILY_OF_THE_VALLEY, Potions.POISON)),
                saveRecipe(cache, "blindness", tonicFromNegativePotion(Items.AZURE_BLUET, ModPotions.BLINDNESS_POTION.get())),
                saveRecipe(cache, "wither", tonicFromNegativePotion(Items.WITHER_ROSE, ModPotions.WITHER_POTION.get())),
                saveRecipe(cache, "levitation", tonicFromNegativePotion(Items.CHORUS_FLOWER, ModPotions.LEVITATION_POTION.get())),
                saveRecipe(cache, "nausea", tonicFromNegativePotion(Items.WARPED_FUNGUS, ModPotions.NAUSEA_POTION.get())),
                saveRecipe(cache, "weakness_orange", tonicFromNegativePotion(Items.ORANGE_TULIP, Potions.WEAKNESS)),
                saveRecipe(cache, "weakness_pink", tonicFromNegativePotion(Items.PINK_TULIP, Potions.WEAKNESS)),
                saveRecipe(cache, "weakness_white", tonicFromNegativePotion(Items.WHITE_TULIP, Potions.WEAKNESS)),
                saveRecipe(cache, "weakness_red", tonicFromNegativePotion(Items.RED_TULIP, Potions.WEAKNESS)),

                //FTT Effect Recipes
                saveRecipe(cache, "prickly", tonicFromPositiveEffect(Items.CACTUS, ModMobEffects.PRICKLY.get(), longDuration)),
                saveRecipe(cache, "purifying", tonicFromPositiveEffect(Items.SPONGE, ModMobEffects.PURIFYING.get(), longDuration)),

                //Compat Recipes
                saveRecipe(cache, "paralyzed", moddedNegativeTonic(
                        "the_bumblezone", "pollen_puff", "paralyzed", shortDuration)),
                saveRecipe(cache, "protection_of_the_hive", moddedPositiveTonic(
                        "the_bumblezone", "pollen_puff", "protection_of_the_hive", longDuration)),

                saveRecipe(cache, "protection_of_the_hive", moddedPositiveTonic("the_bumblezone",
                        "pollen_puff", "protection_of_the_hive", longDuration)),
                saveRecipe(cache, "protection_of_the_hive", moddedPositiveTonic("the_bumblezone",
                        "pollen_puff", "protection_of_the_hive", longDuration)),

                saveRecipe(cache, "agility", moddedPositiveTonic("neapolitan",
                        "banana", "agility", longDuration)),
                saveRecipe(cache, "berserking", moddedPositiveTonic("neapolitan",
                        "mint_leaves", "berserking", longDuration)),
                saveRecipe(cache, "harmony", moddedPositiveTonic("neapolitan",
                        "adzuki_beans", "harmony", longDuration)),
                saveRecipe(cache, "vanilla_scent", moddedPositiveTonic("neapolitan",
                        "vanilla_pods", "vanilla_scent", longDuration)),

                saveRecipe(cache, "healing_touch", moddedPositiveTonic("brewery",
                        "dried_corn", "healingtouch", mediumDuration)),
                saveRecipe(cache, "toxic_touch", moddedNegativeTonic("brewery",
                        "dried_barley", "toxictouch", mediumDuration)),
                saveRecipe(cache, "pint_charisma", moddedPositiveTonic("brewery",
                        "dried_barley", "pintcharisma", longDuration)),
                saveRecipe(cache, "pacify", moddedPositiveTonic("brewery",
                        "hops", "pacify", longDuration)),
                saveRecipe(cache, "explosions", moddedNegativeTonic("brewery",
                        "dried_corn", "explosion", mediumDuration)),
                saveRecipe(cache, "combustion", moddedNegativeTonic("brewery",
                        "dried_oat", "combustion", mediumDuration)),
                saveRecipe(cache, "protective_touch", moddedPositiveTonic("brewery",
                        "dried_oat", "protectivetouch", mediumDuration)),
                saveRecipe(cache, "party_starter", moddedNegativeTonic("brewery",
                        "hops", "partystarter", mediumDuration)),
                saveRecipe(cache, "renewing_touch", moddedPositiveTonic("brewery",
                        "dried_wheat", "renewingtouch", longDuration)),

                saveRecipe(cache, "bug_pheromones", moddedPositiveTonic("alexsmobs",
                        "gongylidia", "bug_pheromones", longDuration)),
                saveRecipe(cache, "knockback_resistance", moddedPositiveTonic("alexsmobs",
                        "acacia_blossom", "knockback_resistance", longDuration)),

                saveRecipe(cache, "deepsight", moddedPositiveTonic("alexscaves",
                        "ping_pong_sponge", "deepsight", longDuration)),
                saveRecipe(cache, "rage", moddedPositiveTonic("alexscaves",
                        "tree_star", "rage", veryShortDuration)),
                saveRecipe(cache, "sugar_rush", moddedPositiveTonic("alexscaves",
                        "lollipop_bunch", "sugar_rush", veryShortDuration)),

                saveRecipe(cache, "rampage", moddedPositiveTonic("born_in_chaos_v1",
                        "marigolds", "rampant_rampage", veryShortDuration)),
                saveRecipe(cache, "intoxication", moddedNegativeTonic("born_in_chaos_v1",
                        "marigolds", "intoxication", veryShortDuration)),
                saveRecipe(cache, "ice_barrier", moddedPositiveTonic("born_in_chaos_v1",
                        "river_mint", "ice_barrier", longDuration)),
                saveRecipe(cache, "stimulation", moddedNegativeTonic("born_in_chaos_v1",
                        "river_mint", "stimulation", veryShortDuration)),

                saveRecipe(cache, "mana_regen", moddedPositiveTonic("ars_nouveau",
                        "sourceberry_bush", "mana_regen", longDuration)),
                saveRecipe(cache, "spell_damage", moddedPositiveTonic("ars_nouveau",
                        "magebloom", "spell_damage", longDuration)),
                saveRecipe(cache, "blasting", moddedPositiveTonic("ars_nouveau",
                        "bombegranate_pod", "blasting", mediumDuration)),
                saveRecipe(cache, "shielding", moddedPositiveTonic("ars_nouveau",
                        "bastion_pod", "shielding", mediumDuration)),
                saveRecipe(cache, "freezing", moddedPositiveTonic("ars_nouveau",
                        "frostaya_pod", "freezing", mediumDuration)),
                saveRecipe(cache, "recovery", moddedPositiveTonic("ars_nouveau",
                        "mendosteen_pod", "recovery", mediumDuration)),

                saveRecipe(cache, "repellence", moddedPositiveTonic("upgrade_aquatic",
                        "pickerelweed", "repellence", longDuration)),
                saveRecipe(cache, "vibing", moddedNegativeTonic("upgrade_aquatic",
                        "pickerelweed", "vibing", longDuration)),

                saveRecipe(cache, "sunscreen", moddedPositiveTonic("vampirism",
                        "vampire_orchid", "sunscreen", longDuration)),

                saveRecipe(cache, "third_eye", moddedPositiveTonic("occultism",
                        "datura", "third_eye", longDuration)),

                saveRecipe(cache, "bonding", moddedPositiveTonic("herbalbrews",
                        "hibiscus", "bonding", longDuration)),
                saveRecipe(cache, "lifeleech", moddedNegativeTonic("herbalbrews",
                        "hibiscus", "lifeleech", mediumDuration)),
                saveRecipe(cache, "tough", moddedPositiveTonic("herbalbrews",
                        "lavender", "tough", longDuration)),
                saveRecipe(cache, "feral", moddedNegativeTonic("herbalbrews",
                        "lavender", "feral", mediumDuration)),
        };

        return CompletableFuture.allOf(tasks);
    }


    public JsonObject tonicFromPositivePotion(Item ingredient, Potion potion) {
        return basePotionRecipe(Items.SUGAR, ingredient, Items.GLASS_BOTTLE, potion);
    }

    public JsonObject tonicFromNegativePotion(Item ingredient, Potion potion) {
        return basePotionRecipe(Items.SPIDER_EYE, ingredient, Items.GLASS_BOTTLE, potion);
    }

    public JsonObject tonicFromPositiveEffect(Item ingredient, MobEffect effect, int duration) {
        return baseEffectRecipe(Items.SUGAR, ingredient, Items.GLASS_BOTTLE, effect, duration);
    }

    public JsonObject tonicFromNegativeEffect(Item ingredient, MobEffect effect, int duration) {
        return baseEffectRecipe(Items.SPIDER_EYE, ingredient, Items.GLASS_BOTTLE, effect, duration);
    }

    public JsonObject moddedPositiveTonic(String modNamespace, String ingredientName, String effectName, int duration) {
        ResourceLocation additive = new ResourceLocation("minecraft", "sugar");
        ResourceLocation ingredient = new ResourceLocation(modNamespace, ingredientName);
        ResourceLocation bottle = new ResourceLocation("minecraft", "glass_bottle");
        ResourceLocation effect = new ResourceLocation(modNamespace, effectName);
        return baseModdedEffectRecipe(additive, ingredient, bottle, effect, duration);
    }

    public JsonObject moddedNegativeTonic(String modNamespace, String ingredientName, String effectName, int duration) {
        ResourceLocation additive = new ResourceLocation("minecraft", "spider_eye");
        ResourceLocation ingredient = new ResourceLocation(modNamespace, ingredientName);
        ResourceLocation bottle = new ResourceLocation("minecraft", "glass_bottle");
        ResourceLocation effect = new ResourceLocation(modNamespace, effectName);
        return baseModdedEffectRecipe(additive, ingredient, bottle, effect, duration);
    }

    private JsonObject basePotionRecipe(Item additive, Item ingredient, Item bottle, Potion potion) {
        JsonObject json = new JsonObject();
        json.addProperty("type", modid + ":herbalism");

        json.add("additive", item(additive));
        json.add("ingredient", item(ingredient));
        json.add("bottle", item(bottle));

        JsonObject result = new JsonObject();
        result.addProperty("item", modid + ":tonic");
        result.addProperty("count", 1);
        result.addProperty("nbt", "{Potion:\"" + ForgeRegistries.POTIONS.getKey(potion) + "\"}");
        json.add("result", result);

        return json;
    }

    private JsonObject baseEffectRecipe(Item additive, Item ingredient, Item bottle, MobEffect effect, int duration) {
        JsonObject json = new JsonObject();
        json.addProperty("type", modid + ":herbalism");

        json.add("additive", item(additive));
        json.add("ingredient", item(ingredient));
        json.add("bottle", item(bottle));

        JsonObject result = new JsonObject();
        result.addProperty("item", modid + ":tonic");

        JsonArray effects = new JsonArray();
        JsonObject effectObj = new JsonObject();
        effectObj.addProperty("id", ForgeRegistries.MOB_EFFECTS.getKey(effect).toString());
        effectObj.addProperty("duration", duration);
        effectObj.addProperty("amplifier", 0);
        effectObj.addProperty("ambient", false);
        effectObj.addProperty("visible", true);
        effectObj.addProperty("show_icon", true);
        effects.add(effectObj);

        result.add("effects", effects);
        json.add("result", result);

        return json;
    }

    private JsonObject baseModdedEffectRecipe(ResourceLocation additive, ResourceLocation ingredient, ResourceLocation bottle, ResourceLocation effect, int duration) {
        JsonObject json = new JsonObject();
        json.addProperty("type", modid + ":herbalism");

        json.add("additive", item(additive));
        json.add("ingredient", item(ingredient));
        json.add("bottle", item(bottle));

        JsonObject result = new JsonObject();
        result.addProperty("item", modid + ":tonic");

        JsonArray effects = new JsonArray();
        JsonObject effectObj = new JsonObject();
        effectObj.addProperty("id", effect.toString());
        effectObj.addProperty("duration", duration);
        effectObj.addProperty("amplifier", 0);
        effectObj.addProperty("ambient", false);
        effectObj.addProperty("visible", true);
        effectObj.addProperty("show_icon", true);
        effects.add(effectObj);

        result.add("effects", effects);
        json.add("result", result);

        return json;
    }

    private JsonObject item(Item item) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", ForgeRegistries.ITEMS.getKey(item).toString());
        return obj;
    }

    private JsonObject item(ResourceLocation id) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", id.toString());
        return obj;
    }

    private CompletableFuture<?> saveRecipe(CachedOutput cache, String name, JsonObject json) {
        Path path = this.output.getOutputFolder()
                .resolve("data/" + modid + "/recipes/tonic_" + name + ".json");
        return DataProvider.saveStable(cache, json, path);
    }

    @Override
    public String getName() {
        return "Tonic Recipes: " + modid;
    }
}