package ovh.corail.tombstone.api.cooldown;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface ICooldownHandler {
    int getCooldown(Player player, CooldownType type);

    boolean hasCooldown(Player player, CooldownType type);

    int resetCooldown(ServerPlayer player, CooldownType type);

    int setCooldown(ServerPlayer player, CooldownType type, int time);

    @OnlyIn(Dist.CLIENT)
    int getCooldown(CooldownType type);

    @OnlyIn(Dist.CLIENT)
    boolean hasCooldown(CooldownType type);
}
