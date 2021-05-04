package ovh.corail.tombstone.api.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import ovh.corail.tombstone.api.TombstoneAPIProps;

import javax.annotation.Nullable;

import java.util.Optional;

public class TBCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
    public static final ResourceLocation RL = new ResourceLocation(TombstoneAPIProps.OWNER, "cap_tombstone");
    @CapabilityInject(ITBCapability.class)
    public static final Capability<ITBCapability> TB_CAPABILITY = TombstoneAPIProps.unsafeNullCast();
    private final LazyOptional<ITBCapability> holderCap;

    public TBCapabilityProvider(NonNullSupplier<ITBCapability> nonNullSupplier) {
        this.holderCap = LazyOptional.of(nonNullSupplier);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        return TB_CAPABILITY.orEmpty(cap, this.holderCap);
    }

    @Override
    public CompoundNBT serializeNBT() {
        return this.holderCap.map(cap -> Optional.ofNullable((CompoundNBT) TB_CAPABILITY.writeNBT(cap, null)).orElse(new CompoundNBT())).orElse(new CompoundNBT());
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.holderCap.ifPresent(cap -> TB_CAPABILITY.readNBT(cap, null, nbt));
    }
}
