package ovh.corail.tombstone.api.event;

import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@SuppressWarnings("WeakerAccess")
public class VillageSiegeEvent extends Event {
    private final ServerWorld world;

    public VillageSiegeEvent(ServerWorld world) {
        this.world = world;
    }

    public ServerWorld getWorld() {
        return this.world;
    }

    /**
     * Called when a siege happens in a village
     */
    @Cancelable
    public static class Start extends VillageSiegeEvent {
        private final BlockPos spawnPos;

        public Start(ServerWorld world, BlockPos spawnPos) {
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
    public static class SpawnZombie extends VillageSiegeEvent {
        private final ZombieEntity entity;

        public SpawnZombie(ServerWorld world, ZombieEntity entity) {
            super(world);
            this.entity = entity;
        }

        public ZombieEntity getZombie() {
            return entity;
        }
    }
}
