package ovh.corail.tombstone.api.capability;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static ovh.corail.tombstone.api.TombstoneAPIProps.OWNER;

public abstract class Perk implements Comparable<Perk>, StringRepresentable {
    protected final String name;
    protected final ResourceLocation icon;
    private Component translation, description;

    public Perk(String name, ResourceLocation icon) {
        this.name = name;
        this.icon = icon;
    }

    public abstract int getLevelMax();

    public boolean isDisabled(@Nullable Player player) {
        return false;
    }

    public abstract Component getTooltip(int level, int actualLevel, int levelWithBonus);

    public int getCost(int level) {
        return level > 0 ? 1 : 0;
    }

    public boolean isEncrypted() {
        return false;
    }

    public int getLevelBonus(Player player) {
        return 0;
    }

    public ResourceLocation getIcon() {
        return this.icon;
    }

    public String getTranslationKey() {
        return OWNER + ".perk." + this.name;
    }

    public Component getTranslation() {
        if (this.translation == null) {
            this.translation = Component.translatable(getTranslationKey());
        }
        return this.translation;
    }

    public Component getDescription() {
        if (this.description == null) {
            this.description = Component.translatable(OWNER + ".perk." + this.name + ".desc");
        }
        return this.description;
    }

    public Component getSpecialInfo(int levelWithBonus) {
        return Component.empty();
    }

    @Override
    public String getSerializedName() {
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
