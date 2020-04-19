package ovh.corail.tombstone.api.capability;

import com.google.common.annotations.Beta;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import ovh.corail.tombstone.api.TombstoneAPIProps;
import ovh.corail.tombstone.api.cooldown.CooldownType;

import javax.annotation.Nullable;
import java.util.Map;

@SuppressWarnings({ "UnusedReturnValue" })
public interface ITBCapability extends INBTSerializable<CompoundNBT> {
    long getKnowledge();

    ITBCapability setKnowledge(long points);

    ITBCapability addKnowledgeAndSync(ServerPlayerEntity player, long points);

    ITBCapability removeKnowledgeAndSync(ServerPlayerEntity player, long points);

    long getKnowledgeForLevel(int level);

    long getKnowledgeToReachNextLevel(int level);

    int getUsedPerkPoints(PlayerEntity player);

    int getTotalPerkPoints();

    Map<Perk, Integer> getPerks();

    ITBCapability setPerks(Map<Perk, Integer> perks);

    ITBCapability setPerk(Perk perk, int level);

    boolean removePerk(Perk perk);

    int getPerkLevel(PlayerEntity player, Perk perk);

    int getPerkLevelWithBonus(PlayerEntity player, @Nullable Perk perk);

    boolean canResetPerks(PlayerEntity player);

    boolean resetPerks(ServerPlayerEntity player);

    ITBCapability copyCapability(ITBCapability otherTBCapability);

    ITBCapability syncAll(ServerPlayerEntity player);

    @Beta
    ITBCapability increaseAlignment(int amount);

    @Beta
    ITBCapability decreaseAlignment(int amount);

    @Beta
    int getAlignmentValue();

    @Beta
    int getAlignmentMinValue();

    @Beta
    int getAlignmentMaxValue();

    @Beta
    int getAlignmentLevel();

    @Beta
    ITBCapability setAlignment(int value);

    @Beta
    ITBCapability addAlignmentAndSync(ServerPlayerEntity player, int value);

    @Beta
    ITBCapability onAlignmentLevelChange(int oldAlignment, int newAlignement);

    @Deprecated
    default boolean canPray(PlayerEntity player) {
        return !TombstoneAPIProps.COOLDOWN_HANDLER.hasCooldown(player, CooldownType.NEXT_PRAY);
    }

    @Deprecated
    default int getCooldownToPray(PlayerEntity player) {
        return TombstoneAPIProps.COOLDOWN_HANDLER.getCooldown(player, CooldownType.NEXT_PRAY);
    }

    @Deprecated
    default int getMaxPrayTime(PlayerEntity player) {
        return CooldownType.NEXT_PRAY.getMaxCooldown(player);
    }

    @Deprecated
    default ITBCapability resetNextPray(PlayerEntity player) {
        if (!player.world.isRemote) {
            TombstoneAPIProps.COOLDOWN_HANDLER.resetCooldown((ServerPlayerEntity) player, CooldownType.NEXT_PRAY);
        }
        return this;
    }

    @Deprecated
    default long getCooldownToResetPerks(PlayerEntity player) {
        return TombstoneAPIProps.COOLDOWN_HANDLER.getCooldown(player, CooldownType.RESET_PERKS);
    }

    @Deprecated
    default boolean resetPerksAndSync(ServerPlayerEntity player) {
        return resetPerks(player);
    }
}
