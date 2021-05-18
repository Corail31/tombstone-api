package ovh.corail.tombstone.api.magic;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import ovh.corail.tombstone.api.TombstoneAPIProps;

import javax.annotation.Nullable;

public class ProtectedEntityProvider implements ICapabilitySerializable<NBTBase> {
    public static final ResourceLocation RL = new ResourceLocation(TombstoneAPIProps.OWNER, "cap_protected_entity");
    @CapabilityInject(IProtectedEntity.class)
    public static final Capability<IProtectedEntity> PROTECTED_ENTITY_CAPABILITY = TombstoneAPIProps.unsafeNullCast();
    private final IProtectedEntity cap;

    public ProtectedEntityProvider(IProtectedEntity cap) {
        this.cap = cap;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == PROTECTED_ENTITY_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == PROTECTED_ENTITY_CAPABILITY ? PROTECTED_ENTITY_CAPABILITY.cast(this.cap) : null;
    }

    @Override
    @Nullable
    public NBTBase serializeNBT() {
        return PROTECTED_ENTITY_CAPABILITY.writeNBT(this.cap, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        PROTECTED_ENTITY_CAPABILITY.readNBT(this.cap, null, nbt);
    }
}
