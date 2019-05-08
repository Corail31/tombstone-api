package ovh.corail.tombstone.api.capability;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;
import ovh.corail.tombstone.api.TombstoneAPIProps;

public abstract class Perk extends Impl<Perk> implements Comparable<Perk>, IStringSerializable {
    protected final String name;
    protected final ResourceLocation icon;

    public Perk(String name, ResourceLocation icon) {
        this.name = name;
        this.icon = icon;
    }

    public abstract int getLevelMax();

    public abstract boolean isDisabled();

    public abstract String getTooltip(int level, int actualLevel, int levelWithBonus);

    public abstract int getCost(int level);

    public boolean isEncrypted() {
        return false;
    }

    public int getLevelBonus(EntityPlayer player) {
        return 0;
    }

    public ResourceLocation getIcon() {
        return icon;
    }

    public String getTranslationKey() {
        return TombstoneAPIProps.OWNER + ".perk." + name + ".name";
    }

    @SideOnly(Side.CLIENT)
    public String getClientTranslation() {
        return I18n.format(getTranslationKey());
    }

    public String getSpecialInfo(int levelWithBonus) {
        return "";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        assert getRegistryName() != null;
        return object instanceof Perk && getRegistryName().equals(((Perk) object).getRegistryName());
    }

    @Override
    public int compareTo(Perk perk) {
        assert getRegistryName() != null && perk.getRegistryName() != null;
        return getRegistryName().compareTo(perk.getRegistryName());
    }
}
