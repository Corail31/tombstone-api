package ovh.corail.tombstone.api.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import ovh.corail.tombstone.api.TombstoneAPIProps;

import javax.annotation.Nullable;
import java.util.Optional;

public class TBCapabilityProvider implements ICapabilitySerializable<NBTTagCompound> {
    public static final ResourceLocation RL = new ResourceLocation(TombstoneAPIProps.OWNER, "cap_tombstone");
    @CapabilityInject(ITBCapability.class)
    public static Capability<ITBCapability> TB_CAPABILITY = TombstoneAPIProps.unsafeNullCast();
    private final ITBCapability cap;

    public TBCapabilityProvider(ITBCapability cap) {
        this.cap = cap;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == TB_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == TB_CAPABILITY ? TB_CAPABILITY.cast(this.cap) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return Optional.ofNullable((NBTTagCompound) TB_CAPABILITY.writeNBT(this.cap, null)).orElse(new NBTTagCompound());
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        TB_CAPABILITY.readNBT(this.cap, null, nbt);
    }
}
