package ovh.corail.tombstone.api.capability;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

import static ovh.corail.tombstone.api.TombstoneAPIProps.OWNER;

public abstract class Perk extends ForgeRegistryEntry<Perk> implements Comparable<Perk>, StringRepresentable {
    protected final String name;
    protected final ResourceLocation icon;
    private Component translation, description;

    public Perk(String name, @Nullable ResourceLocation icon) {
        this.name = name;
        this.icon = icon;
    }

    public abstract int getLevelMax();

    public boolean isDisabled(@Nullable Player player) {
        return false;
    }

    public abstract Component getTooltip(int level, int actualLevel, int levelWithBonus);

    public abstract int getCost(int level);

    public boolean isEncrypted() {
        return false;
    }

    public int getLevelBonus(Player player) {
        return 0;
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    public String getTranslationKey() {
        return OWNER + ".perk." + this.name;
    }

    public Component getTranslation() {
        if (this.translation == null) {
            this.translation = new TranslatableComponent(getTranslationKey());
        }
        return this.translation;
    }

    public Component getDescription() {
        if (this.description == null) {
            this.description = new TranslatableComponent(OWNER + ".perk." + this.name + ".desc");
        }
        return this.description;
    }

    public Component getSpecialInfo(int levelWithBonus) {
        return TextComponent.EMPTY;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
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
