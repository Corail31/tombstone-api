package ovh.corail.tombstone.api.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * Called when a creature is going to be imprisoned by a player
 */
@Cancelable
public class CaptureSoulEvent extends Event {
    private final Player player;
    private final LivingEntity capturedEntity;

    public CaptureSoulEvent(Player player, LivingEntity capturedEntity) {
        this.player = player;
        this.capturedEntity = capturedEntity;
    }

    public Player getPlayer() {
        return this.player;
    }

    public LivingEntity getCapturedEntity() {
        return this.capturedEntity;
    }
}
