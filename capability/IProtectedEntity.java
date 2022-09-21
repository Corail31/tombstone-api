package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.GlobalPos;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * This capability interface allows to prevent the next death of an entity
 * by default, only abstract villager & minecolonies citizen have this capability
 */
public interface IProtectedEntity extends INBTSerializable<CompoundNBT> {
    /**
     * set active or not the protection
     *
     * @param entity entity affected
     * @param active protected if true
     */
    void apply(LivingEntity entity, boolean active);

    /**
     * get if the protection is active
     *
     * @return true if protected
     */
    boolean isActive();

    /**
     * provide a safe location to teleport
     *
     * @return the location
     */
    GlobalPos getSafeLocation(LivingEntity entity);
}
