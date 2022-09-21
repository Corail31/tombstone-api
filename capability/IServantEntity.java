package ovh.corail.tombstone.api.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public interface IServantEntity extends INBTSerializable<CompoundTag> {
    Optional<UUID> getOwnerId();

    void setOwnerId(@Nullable UUID owner);

    default boolean isActive() {
        return getOwnerId().isPresent();
    }

    boolean isSpellCaster();

    int getCasterType();

    void setSpellCaster(int casterType);

    void setAI(PathfinderMob servant);
}
