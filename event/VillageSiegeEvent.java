package ovh.corail.tombstone.api.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@SuppressWarnings("WeakerAccess")
public class VillageSiegeEvent extends Event {
    private final ServerLevel level;

    public VillageSiegeEvent(ServerLevel world) {
        this.level = world;
    }

    public ServerLevel getLevel() {
        return this.level;
    }

    /**
     * Called when a siege happens in a village
     */
    @Cancelable
    public static final class Start extends VillageSiegeEvent {
        private final BlockPos spawnPos;

        public Start(ServerLevel world, BlockPos spawnPos) {
            super(world);
            this.spawnPos = spawnPos;
        }

        public BlockPos getSpawnPos() {
            return this.spawnPos;
        }
    }

    /**
     * Called when a village siege happens before a zombie spawn allowing to edit it before it spawns
     */
    @Cancelable
    public static final class SpawnZombie extends VillageSiegeEvent {
        private final Zombie entity;

        public SpawnZombie(ServerLevel world, Zombie entity) {
            super(world);
            this.entity = entity;
        }

        public Zombie getZombie() {
            return entity;
        }
    }
}
