package net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.entity.event;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.floral_tonics_and_tinctures.FloralTonicsAndTinctures;
import net.trashelemental.floral_tonics_and_tinctures.junkyard_lib.entity.MinionEntity;


/**
 * Prevents minions from sending death messages when killed, since they're
 * designed to be summoned at low health and sometimes in large numbers.
 */

@Mod.EventBusSubscriber(modid = FloralTonicsAndTinctures.MOD_ID)
public class MinionDeathEvent {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {

            if (event.getEntity() instanceof MinionEntity minionEntity && minionEntity.isTame()) {
                minionEntity.setOwnerUUID(null);
            }

        }
    }

}
