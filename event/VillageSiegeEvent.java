package ovh.corail.tombstone.api.event;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.Village;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

public class VillageSiegeEvent extends Event {
    private final Village village;

    private VillageSiegeEvent(Village village) {
        this.village = village;
    }

    public Village getVillage() {
        return village;
    }

    /**
     * Called when a siege happens in a village
     */
    @Cancelable
    public static class Start extends VillageSiegeEvent {
        private final BlockPos spawnPos;

        public Start(Village village, BlockPos spawnPos) {
            super(village);
            this.spawnPos = spawnPos;
        }

        public BlockPos getSpawnPos() {
            return spawnPos;
        }
    }

    /**
     * Called when a village siege happens before a zombie spawn allowing to edit it before it spawns
     */
    @Cancelable
    public static class SpawnZombie extends VillageSiegeEvent {
        private final EntityZombie entity;

        public SpawnZombie(Village village, EntityZombie entity) {
            super(village);
            this.entity = entity;
        }

        public EntityZombie getZombie() {
            return entity;
        }
    }
}
