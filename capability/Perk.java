package ovh.corail.tombstone.api.capability;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import ovh.corail.tombstone.api.TombstoneAPIProps;

import javax.annotation.Nullable;

public abstract class Perk extends Impl<Perk> implements Comparable<Perk>, IStringSerializable {
    protected final String name;
    protected final ResourceLocation icon;

    public Perk(String name, @Nullable ResourceLocation icon) {
        this.name = name;
        this.icon = icon;
    }

    public abstract int getLevelMax();

    public boolean isDisabled(@Nullable EntityPlayer player) {
        return false;
    }

    public boolean isDisabled() {
        return isDisabled(null);
    }

    @SideOnly(Side.CLIENT)
    public abstract String getTooltip(int level, int actualLevel, int levelWithBonus);

    public abstract int getCost(int level);

    public boolean isEncrypted() {
        return false;
    }

    public int getLevelBonus(EntityPlayer player) {
        return 0;
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    public String getTranslationKey() {
        return TombstoneAPIProps.OWNER + ".perk." + this.name + ".name";
    }

    @SideOnly(Side.CLIENT)
    public String getClientTranslation() {
        return I18n.format(getTranslationKey());
    }

    @SideOnly(Side.CLIENT)
    public String getSpecialInfo(int levelWithBonus) {
        return "";
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        ResourceLocation registryName = getRegistryName();
        return registryName != null && object instanceof Perk && registryName.equals(((Perk) object).getRegistryName());
    }

    @Override
    public int compareTo(Perk perk) {
        ResourceLocation registryName = getRegistryName();
        ResourceLocation otherRegistryName = perk.getRegistryName();
        if (registryName != null && otherRegistryName != null) {
            return registryName.compareTo(otherRegistryName);
        }
        return registryName == otherRegistryName ? 0 : registryName == null ? -1 : 1;
    }
}
