package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.player.PlayerEntity;

import javax.annotation.Nullable;

public class DummyPerk extends Perk {
    DummyPerk() {
        super("dummy", null);
    }

    @Override
    public int getLevelMax() {
        return 0;
    }

    @Override
    public boolean isDisabled(@Nullable PlayerEntity player) {
        return true;
    }

    @Override
    public String getTooltip(int level, int actualLevel, int levelWithBonus) {
        return "";
    }

    @Override
    public int getCost(int level) {
        return 0;
    }
}
