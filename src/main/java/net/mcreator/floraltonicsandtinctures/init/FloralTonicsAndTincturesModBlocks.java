
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.floraltonicsandtinctures.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.floraltonicsandtinctures.block.HerbalismTableBlock;
import net.mcreator.floraltonicsandtinctures.FloralTonicsAndTincturesMod;

public class FloralTonicsAndTincturesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, FloralTonicsAndTincturesMod.MODID);
	public static final DeferredHolder<Block, Block> HERBALISM_TABLE = REGISTRY.register("herbalism_table", () -> new HerbalismTableBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
