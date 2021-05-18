package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * This capability interface allows to prevent the next death of an entity
 * by default, only abstract villager & minecolonies citizen have this capability
 */
public interface IProtectedEntity extends INBTSerializable<NBTTagCompound> {
    /**
     * set active or not the protection
     *
     * @param entity entity affected
     * @param active protected if true
     */
    void apply(EntityLivingBase entity, boolean active);

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
    ILocation getSafeLocation(EntityLivingBase entity);
}
