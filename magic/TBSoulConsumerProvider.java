package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import ovh.corail.tombstone.api.TombstoneAPIProps;

import javax.annotation.Nullable;

public class TBSoulConsumerProvider implements ICapabilityProvider {
    @CapabilityInject(ISoulConsumer.class)
    public static final Capability<ISoulConsumer> CAP_SOUL_CONSUMER = TombstoneAPIProps.unsafeNullCast();
    private final ISoulConsumer cap;

    public TBSoulConsumerProvider(ISoulConsumer soulConsumer) {
        this.cap = soulConsumer;
    }

    @Override
    public boolean hasCapability(Capability<?> cap, @Nullable EnumFacing facing) {
        return cap == CAP_SOUL_CONSUMER;
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> cap, @Nullable EnumFacing facing) {
        return cap == CAP_SOUL_CONSUMER ? CAP_SOUL_CONSUMER.cast(this.cap) : null;
    }

    public static ISoulConsumer getDefault() {
        return new ISoulConsumer() {
            @Override
            public boolean isEnchanted(ItemStack stack) {
                return false;
            }

            @Override
            public boolean setEnchant(World world, BlockPos gravePos, EntityPlayer player, ItemStack stack) {
                return false;
            }

            @Override
            public ITextComponent getEnchantSuccessMessage(EntityPlayer player) {
                return new TextComponentTranslation("tombstone.message.enchant_item.success");
            }

            @Override
            public ITextComponent getEnchantFailedMessage(EntityPlayer player) {
                return new TextComponentTranslation("tombstone.message.enchant_item.failed");
            }
        };
    }

    public static final Capability.IStorage<ISoulConsumer> NULL_STORAGE = new Capability.IStorage<ISoulConsumer>() {
        @Override
        @Nullable
        public NBTBase writeNBT(Capability<ISoulConsumer> capability, ISoulConsumer instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<ISoulConsumer> capability, ISoulConsumer instance, EnumFacing side, NBTBase nbt) {
        }
    };
}
