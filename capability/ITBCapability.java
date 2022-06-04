package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.Map;

@SuppressWarnings({ "UnusedReturnValue" })
public interface ITBCapability extends INBTSerializable<NBTTagCompound> {
    long getKnowledge();

    ITBCapability setKnowledge(long points);

    default void reward(EntityPlayerMP player, int knowledge, int alignment) {
    }

    @Deprecated
    default ITBCapability addKnowledgeAndSync(EntityPlayerMP player, long points) {
        reward(player, (int) points, 0);
        return this;
    }

    default void loseKnowledge(EntityPlayerMP player, int points) {
    }

    @Deprecated
    default ITBCapability removeKnowledgeAndSync(EntityPlayerMP player, long points) {
        loseKnowledge(player, (int) points);
        return this;
    }

    long getKnowledgeForLevel(int level);

    long getKnowledgeToReachNextLevel(int level);

    int getUsedPerkPoints(EntityPlayer player);

    int getTotalPerkPoints();

    Map<Perk, Integer> getPerks();

    ITBCapability setPerks(Map<Perk, Integer> perks);

    ITBCapability setPerk(Perk perk, int level);

    boolean removePerk(Perk perk);

    int getPerkLevel(EntityPlayer player, Perk perk);

    int getPerkLevelWithBonus(EntityPlayer player, @Nullable Perk perk);

    boolean canResetPerks(EntityPlayer player);

    boolean resetPerks(EntityPlayerMP player);

    ITBCapability copyCapability(ITBCapability otherTBCapability);

    ITBCapability syncAll(EntityPlayerMP player);

    int getAlignmentValue();

    int getAlignmentMinValue();

    int getAlignmentMaxValue();

    int getAlignmentLevel();

    ITBCapability setAlignment(int value);

    @Deprecated
    default ITBCapability addAlignmentAndSync(EntityPlayerMP player, int value) {
        reward(player, 0, value);
        return this;
    }

    ITBCapability onAlignmentLevelChange(int oldAlignment, int newAlignment);
}
