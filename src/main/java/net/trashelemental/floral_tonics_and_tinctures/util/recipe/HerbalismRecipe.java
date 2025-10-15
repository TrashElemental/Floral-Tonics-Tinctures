package net.trashelemental.floral_tonics_and_tinctures.util.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.trashelemental.floral_tonics_and_tinctures.item.custom.TonicItem;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class HerbalismRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final List<MobEffectInstance> customEffects;

    public HerbalismRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack result, List<MobEffectInstance> customEffects) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
        this.customEffects = customEffects;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (level.isClientSide()) return false;
        if (ingredients.size() != 3) return false;

        return ingredients.get(0).test(container.getItem(0)) &&
                ingredients.get(1).test(container.getItem(1)) &&
                ingredients.get(2).test(container.getItem(2));
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        ItemStack output = result.copy();
        if (output.getItem() instanceof TonicItem) {
            if (!customEffects.isEmpty()) {
                PotionUtils.setCustomEffects(output, customEffects);
            }
        }
        return output;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        ItemStack output = result.copy();
        if (output.getItem() instanceof TonicItem && !customEffects.isEmpty()) {
            PotionUtils.setCustomEffects(output, customEffects);
        }
        return output;
    }

    public ItemStack getResultItem() {
        ItemStack output = result.copy();
        if (output.getItem() instanceof TonicItem && !customEffects.isEmpty()) {
            PotionUtils.setCustomEffects(output, customEffects);
        }
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) { return true; }
    @Override
    public ResourceLocation getId() { return id; }
    @Override
    public RecipeSerializer<?> getSerializer() { return ModRecipes.HERBALISM.get(); }
    @Override
    public RecipeType<?> getType() { return ModRecipeTypes.HERBALISM.get(); }
    public NonNullList<Ingredient> getIngredients() { return ingredients; }


    public static class Serializer implements RecipeSerializer<HerbalismRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public HerbalismRecipe fromJson(ResourceLocation id, JsonObject json) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
            ingredients.set(0, Ingredient.fromJson(json.getAsJsonObject("additive")));
            ingredients.set(1, Ingredient.fromJson(json.getAsJsonObject("ingredient")));
            ingredients.set(2, Ingredient.fromJson(json.getAsJsonObject("bottle")));

            JsonObject resultObj = json.getAsJsonObject("result");
            ItemStack result = ShapedRecipe.itemStackFromJson(resultObj);

            List<MobEffectInstance> customEffects = new ArrayList<>();
            if (resultObj.has("effects")) {
                JsonArray arr = GsonHelper.getAsJsonArray(resultObj, "effects");
                for (JsonElement el : arr) {
                    JsonObject effectObj = el.getAsJsonObject();
                    ResourceLocation effectId = new ResourceLocation(GsonHelper.getAsString(effectObj, "id"));
                    MobEffect effect = BuiltInRegistries.MOB_EFFECT.get(effectId);
                    if (effect == null) continue;

                    int duration = GsonHelper.getAsInt(effectObj, "duration", 200);
                    int amplifier = GsonHelper.getAsInt(effectObj, "amplifier", 0);
                    boolean ambient = GsonHelper.getAsBoolean(effectObj, "ambient", false);
                    boolean visible = GsonHelper.getAsBoolean(effectObj, "visible", true);
                    boolean showIcon = GsonHelper.getAsBoolean(effectObj, "show_icon", true);

                    customEffects.add(new MobEffectInstance(effect, duration, amplifier, ambient, visible, showIcon));
                }
            }

            return new HerbalismRecipe(id, ingredients, result, customEffects);
        }

        @Override
        public @Nullable HerbalismRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(3, Ingredient.EMPTY);
            for (int i = 0; i < 3; i++) {
                ingredients.set(i, Ingredient.fromNetwork(buf));
            }
            ItemStack result = buf.readItem();

            int size = buf.readVarInt();
            List<MobEffectInstance> effects = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ResourceLocation effectId = buf.readResourceLocation();
                int duration = buf.readVarInt();
                int amplifier = buf.readVarInt();
                boolean ambient = buf.readBoolean();
                boolean visible = buf.readBoolean();
                boolean showIcon = buf.readBoolean();
                MobEffect effect = BuiltInRegistries.MOB_EFFECT.get(effectId);
                if (effect != null)
                    effects.add(new MobEffectInstance(effect, duration, amplifier, ambient, visible, showIcon));
            }

            return new HerbalismRecipe(id, ingredients, result, effects);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, HerbalismRecipe recipe) {
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItem(recipe.result);

            buf.writeVarInt(recipe.customEffects.size());
            for (MobEffectInstance inst : recipe.customEffects) {
                buf.writeResourceLocation(BuiltInRegistries.MOB_EFFECT.getKey(inst.getEffect()));
                buf.writeVarInt(inst.getDuration());
                buf.writeVarInt(inst.getAmplifier());
                buf.writeBoolean(inst.isAmbient());
                buf.writeBoolean(inst.isVisible());
                buf.writeBoolean(inst.showIcon());
            }
        }
    }
}