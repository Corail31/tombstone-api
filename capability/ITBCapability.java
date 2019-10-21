package ovh.corail.tombstone.api.capability;

import com.google.common.annotations.Beta;
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

    ITBCapability addKnowledgeAndSync(EntityPlayerMP player, long points);

    ITBCapability removeKnowledgeAndSync(EntityPlayerMP player, long points);

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

    boolean canPray(EntityPlayer player);

    long getNextPray();

    int getMaxPrayTime(EntityPlayer player);

    ITBCapability resetNextPray(EntityPlayer player);

    ITBCapability setNextPray(long time);

    boolean canResetPerks(EntityPlayer player);

    long getCooldownToResetPerks(EntityPlayer player);

    boolean resetPerksAndSync(EntityPlayerMP player);

    ITBCapability setNextResetPerks(long time);

    ITBCapability copyCapability(ITBCapability otherTBCapability);

    ITBCapability syncAll(EntityPlayerMP player);

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
    ITBCapability addAlignmentAndSync(EntityPlayerMP player, int value);

    @Beta
    ITBCapability onAlignmentLevelChange(int oldAlignment, int newAlignement);
}
