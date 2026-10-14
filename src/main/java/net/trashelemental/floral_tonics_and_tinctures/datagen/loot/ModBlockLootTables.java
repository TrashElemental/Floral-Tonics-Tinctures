package net.trashelemental.floral_tonics_and_tinctures.datagen.loot;

import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.floral_tonics_and_tinctures.block.ModBlocks;
import net.trashelemental.floral_tonics_and_tinctures.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.HERBALISM_TABLE.get());

        this.dropSelf(ModBlocks.FIRE_LILY.get());
        this.add(ModBlocks.POTTED_FIRE_LILY.get(), createPotFlowerItemTable(ModBlocks.FIRE_LILY.get()));
        this.dropSelf(ModBlocks.HEATHER.get());
        this.add(ModBlocks.POTTED_HEATHER.get(), createPotFlowerItemTable(ModBlocks.HEATHER.get()));
        this.dropSelf(ModBlocks.MILKWEED.get());
        this.add(ModBlocks.POTTED_MILKWEED.get(), createPotFlowerItemTable(ModBlocks.MILKWEED.get()));
        this.dropSelf(ModBlocks.MOLY.get());
        this.add(ModBlocks.POTTED_MOLY.get(), createPotFlowerItemTable(ModBlocks.MOLY.get()));
        this.dropSelf(ModBlocks.LAVADROP.get());
        this.add(ModBlocks.POTTED_LAVADROP.get(), createPotFlowerItemTable(ModBlocks.LAVADROP.get()));
        this.dropSelf(ModBlocks.MIDAS_FINGERS.get());
        this.add(ModBlocks.POTTED_MIDAS_FINGERS.get(), createPotFlowerItemTable(ModBlocks.STELLA.get()));
        this.dropSelf(ModBlocks.STELLA.get());
        this.add(ModBlocks.POTTED_STELLA.get(), createPotFlowerItemTable(ModBlocks.STELLA.get()));

        this.add(ModBlocks.CLOVER_PATCH.get(), createShearsDispatchTable(ModBlocks.CLOVER_PATCH.get(), LootItem.lootTableItem(Items.AIR)));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
