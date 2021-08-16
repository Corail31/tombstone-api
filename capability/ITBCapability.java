package ovh.corail.tombstone.api.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.Map;

public interface ITBCapability extends INBTSerializable<CompoundTag> {
    int getKnowledge();

    void setKnowledge(int points);

    void reward(ServerPlayer player, int knowledge, int alignment);

    void loseKnowledge(ServerPlayer player, int points);

    int getKnowledgeForLevel(int level);

    int getKnowledgeToReachNextLevel(int level);

    void setAlignment(int value);

    int getAlignmentValue();

    int getAlignmentMinValue();

    int getAlignmentMaxValue();

    int getAlignmentLevel();

    void onAlignmentLevelChange(int oldAlignment, int newAlignment);

    int getUsedPerkPoints(Player player);

    int getTotalPerkPoints();

    Map<Perk, Integer> getPerks();

    void setPerks(Map<Perk, Integer> perks);

    void setPerk(Perk perk, int level);

    void removePerk(Perk perk);

    int getPerkLevel(Player player, Perk perk);

    int getPerkLevelWithBonus(Player player, @Nullable Perk perk);

    boolean canResetPerks(Player player);

    boolean resetPerks(ServerPlayer player);

    void syncAll(ServerPlayer player);
}
