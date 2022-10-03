package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.registries.IForgeRegistryEntry.Impl;

import javax.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static ovh.corail.tombstone.api.TombstoneAPIProps.OWNER;

public abstract class Perk extends Impl<Perk> implements Comparable<Perk>, IStringSerializable {
    protected final String name;
    protected final ResourceLocation icon;
    protected ITextComponent translation, description;

    public Perk(String name, @Nullable ResourceLocation icon) {
        this.name = name;
        this.icon = icon;
    }

    public abstract int getLevelMax();

    public boolean isDisabled(@Nullable EntityPlayer player) {
        return false;
    }

    public int getCost(int level) {
        return level > 0 ? 1 : 0;
    }

    public int getLevelBonus(EntityPlayer player) {
        return 0;
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    public final String getTranslationKey() {
        return OWNER + ".perk." + this.name;
    }

    public final ITextComponent getTranslation() {
        if (this.translation == null) {
            this.translation = new TextComponentTranslation(getTranslationKey());
        }
        return this.translation;
    }

    public ITextComponent getDescription() {
        if (this.description == null) {
            this.description = new TextComponentTranslation(getTranslationKey() + ".desc");
        }
        return this.description;
    }

    public List<ITextComponent> getCurrentBonusInfo(int level) {
        return Collections.emptyList();
    }

    public List<ITextComponent> getNextBonusInfo(int nextLevel) {
        return getCurrentBonusInfo(nextLevel);
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
