package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public interface IServantEntity extends INBTSerializable<CompoundNBT> {
    Optional<UUID> getOwnerId();

    void setOwnerId(@Nullable UUID owner);

    default boolean isActive() {
        return getOwnerId().isPresent();
    }

    boolean isSpellCaster();

    int getCasterType();

    void setSpellCaster(int casterType);

    void setAI(CreatureEntity servant);
}
