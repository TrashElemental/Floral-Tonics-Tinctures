package net.trashelemental.floral_tonics_and_tinctures;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //Demo Related



    //Non-Demo
    public static final ForgeConfigSpec.IntValue TONIC_MAX_STACK_SIZE = BUILDER
            .comment("Control the max stack size of tonic and tincture items. Defaults to 3.")
            .defineInRange("Tonic/Tincture max stack size:", 3, 1, 64);

    public static final ForgeConfigSpec.BooleanValue TONIC_USE_FAST = BUILDER
            .comment("Controls whether tonics and tinctures should be consumed quickly, like sweet berries. Defaults to false.")
            .define("Consume tonics/tinctures quickly:", false);

    public static final ForgeConfigSpec.BooleanValue TONIC_REDUCED_DURATION = BUILDER
            .comment("Controls whether tonics and tinctures should have a reduced duration compared to their potion counterparts. Defaults to true.")
            .define("Tonics/tinctures have a reduced duration:", true);




    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        if (event.getConfig().getSpec() == Config.SPEC) {
        }

    }
}
