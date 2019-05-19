package ovh.corail.tombstone.api.capability;

public class DummyPerk extends Perk {
    DummyPerk() {
        super("dummy", null);
    }

    @Override
    public int getLevelMax() {
        return 0;
    }

    @Override
    public boolean isDisabled() {
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
