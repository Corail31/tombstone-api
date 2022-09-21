package ovh.corail.tombstone.api.cooldown;

import net.minecraft.entity.player.PlayerEntity;

import java.util.function.Function;

public enum CooldownType {
    NEXT_PRAY(true), RESET_PERKS(true), TELEPORT_DEATH, TELEPORT_BIND, REQUEST_TELEPORT;
    private final boolean isSync;
    private Function<PlayerEntity, Integer> maxCooldown = player -> 0; // set on init

    CooldownType() {
        this(false);
    }

    CooldownType(boolean isSync) {
        this.isSync = isSync;
    }

    public boolean isSync() {
        return this.isSync;
    }

    public int getMaxCooldown(PlayerEntity player) {
        return this.maxCooldown.apply(player);
    }

    public void setMaxCooldown(Function<PlayerEntity, Integer> maxCooldown) {
        this.maxCooldown = maxCooldown;
    }
}
