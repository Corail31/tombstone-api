package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.Map;

public interface ITBCapability extends INBTSerializable<CompoundNBT> {
    int getKnowledge();

    void setKnowledge(int points);

    void reward(ServerPlayerEntity player, int knowledge, int alignment);

    void loseKnowledge(ServerPlayerEntity player, int points);

    int getKnowledgeForLevel(int level);

    void setAlignment(int value);

    int getAlignmentValue();

    int getAlignmentMinValue();

    int getAlignmentMaxValue();

    int getAlignmentLevel();

    void onAlignmentLevelChange(int oldAlignment, int newAlignment);

    int getUsedPerkPoints(PlayerEntity player);

    int getTotalPerkPoints();

    Map<Perk, Integer> getPerks();

    void setPerks(Map<Perk, Integer> perks);

    void setPerk(Perk perk, int level);

    void removePerk(Perk perk);

    int getPerkLevel(PlayerEntity player, Perk perk);

    int getPerkLevelWithBonus(PlayerEntity player, @Nullable Perk perk);

    boolean canResetPerks(PlayerEntity player);

    boolean resetPerks(ServerPlayerEntity player);

    void syncAll(ServerPlayerEntity player);
}
