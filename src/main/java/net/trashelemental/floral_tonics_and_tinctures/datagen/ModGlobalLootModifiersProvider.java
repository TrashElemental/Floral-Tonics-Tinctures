package net.trashelemental.floral_tonics_and_tinctures.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FloralTonicsAndTinctures.MOD_ID);
    }


    @Override
    protected void start() {


    }
}
