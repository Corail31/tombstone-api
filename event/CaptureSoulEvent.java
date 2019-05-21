package ovh.corail.tombstone.api.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * Called when a creature is going to be imprisoned by a player
 */
@Cancelable
public class CaptureSoulEvent extends Event {
    private final EntityPlayer player;
    private final EntityLivingBase capturedEntity;

    public CaptureSoulEvent(EntityPlayer player, EntityLivingBase capturedEntity) {
        this.player = player;
        this.capturedEntity = capturedEntity;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public EntityLivingBase getCapturedEntity() {
        return this.capturedEntity;
    }
}
