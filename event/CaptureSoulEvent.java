package ovh.corail.tombstone.api.event;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * Called when a creature is going to be imprisoned by a player
 */
@Cancelable
public class CaptureSoulEvent extends Event {
    private final PlayerEntity player;
    private final LivingEntity capturedEntity;

    public CaptureSoulEvent(PlayerEntity player, LivingEntity capturedEntity) {
        this.player = player;
        this.capturedEntity = capturedEntity;
    }

    public PlayerEntity getPlayer() {
        return this.player;
    }

    public LivingEntity getCapturedEntity() {
        return this.capturedEntity;
    }
}
