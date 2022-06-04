package ovh.corail.tombstone.api.capability;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

import javax.annotation.Nullable;

import java.util.Objects;

import static ovh.corail.tombstone.api.TombstoneAPIProps.OWNER;

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

    public int getCost(int level) {
        return level > 0 ? 1 : 0;
    }

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
        return OWNER + ".perk." + this.name + ".name";
    }

    @SideOnly(Side.CLIENT)
    public String getClientTranslation() {
        return I18n.format(getTranslationKey());
    }

    @SideOnly(Side.CLIENT)
    public String getDescription() {
        return I18n.format(OWNER + ".perk." + this.name + ".desc");
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
    public int compareTo(Perk perk) {
        return this.name.compareTo(perk.name);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o != null && getClass() == o.getClass() && this.name.equals(((Perk) o).name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
