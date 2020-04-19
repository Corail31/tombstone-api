package ovh.corail.tombstone.api.cooldown;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface ICooldownHandler {
    int getCooldown(PlayerEntity player, CooldownType type);

    boolean hasCooldown(PlayerEntity player, CooldownType type);

    int resetCooldown(ServerPlayerEntity player, CooldownType type);

    int setCooldown(ServerPlayerEntity player, CooldownType type, int time);

    @OnlyIn(Dist.CLIENT)
    int getCooldown(CooldownType type);

    @OnlyIn(Dist.CLIENT)
    boolean hasCooldown(CooldownType type);
}
