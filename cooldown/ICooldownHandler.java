package ovh.corail.tombstone.api.cooldown;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ICooldownHandler {
    int getCooldown(EntityPlayer player, CooldownType type);

    boolean hasCooldown(EntityPlayer player, CooldownType type);

    int resetCooldown(EntityPlayerMP player, CooldownType type);

    int setCooldown(EntityPlayerMP player, CooldownType type, int time);

    @SideOnly(Side.CLIENT)
    int getCooldown(CooldownType type);

    @SideOnly(Side.CLIENT)
    boolean hasCooldown(CooldownType type);
}
