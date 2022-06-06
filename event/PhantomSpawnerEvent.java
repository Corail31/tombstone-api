package ovh.corail.tombstone.api.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;

@SuppressWarnings({ "WeakerAccess", "unused" })
public class PhantomSpawnerEvent extends Event {
    private final Player player;
    protected int timeForCheck;

    public PhantomSpawnerEvent(Player player, int timeForCheck) {
        this.player = player;
        this.timeForCheck = timeForCheck;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getTimeForCheck() {
        return this.timeForCheck;
    }

    public static final class TimeForCheck extends PhantomSpawnerEvent {

        public TimeForCheck(Player player, int timeForCheck) {
            super(player, timeForCheck);
        }

        public void modifyTimeForCheck(int timeForCheck) {
            this.timeForCheck = timeForCheck;
        }
    }

    @HasResult
    public static final class CheckPhantomSpawn extends PhantomSpawnerEvent {
        private final int timeSinceRest;

        public CheckPhantomSpawn(Player player, int timeForCheck, int timeSinceRest) {
            super(player, timeForCheck);
            this.timeSinceRest = timeSinceRest;
        }

        public int getTimeSinceRest() {
            return this.timeSinceRest;
        }
    }
}
