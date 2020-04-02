package ovh.corail.tombstone.api.capability;

import com.google.common.annotations.Beta;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

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

    default boolean canPray(PlayerEntity player) {
        return getCooldownToPray(player) <= 0;
    }

    int getCooldownToPray(PlayerEntity player);

    long getNextPray();

    int getMaxPrayTime(PlayerEntity player);

    ITBCapability resetNextPray(PlayerEntity player);

    ITBCapability setNextPray(long worldTime);

    boolean canResetPerks(PlayerEntity player);

    long getCooldownToResetPerks(PlayerEntity player);

    boolean resetPerksAndSync(ServerPlayerEntity player);

    ITBCapability setNextResetPerks(long worldTime);

    ITBCapability copyCapability(ITBCapability otherTBCapability);

    ITBCapability syncAll(ServerPlayerEntity player);

    ITBCapability setCooldownToRequestTeleport(long worldTime);

    int getCooldownToRequestTeleport(ServerPlayerEntity player);

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
}
