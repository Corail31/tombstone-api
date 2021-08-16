package ovh.corail.tombstone.api.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;

@SuppressWarnings({ "WeakerAccess", "unused" })
public class PhantomSpawnerEvent extends Event {
    private final PlayerEntity player;
    protected int timeForCheck;

    public PhantomSpawnerEvent(PlayerEntity player, int timeForCheck) {
        this.player = player;
        this.timeForCheck = timeForCheck;
    }

    public PlayerEntity getPlayer() {
        return this.player;
    }

    public int getTimeForCheck() {
        return this.timeForCheck;
    }

    public static class TimeForCheck extends PhantomSpawnerEvent {

        public TimeForCheck(PlayerEntity player, int timeForCheck) {
            super(player, timeForCheck);
        }

        public void modifyTimeForCheck(int timeForCheck) {
            this.timeForCheck = timeForCheck;
        }
    }

    @HasResult
    public static class CheckPhantomSpawn extends PhantomSpawnerEvent {
        private final int timeSinceRest;

        public CheckPhantomSpawn(PlayerEntity player, int timeForCheck, int timeSinceRest) {
            super(player, timeForCheck);
            this.timeSinceRest = timeSinceRest;
        }

        public int getTimeSinceRest() {
            return this.timeSinceRest;
        }
    }
}
