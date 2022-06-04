package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

/**
 * This interface allows a player to interact a grave with an itemstack
 */
public interface ISoulConsumer {
    /**
     * @param stack the stack implementing this interface
     * @return return true if the stack is already enchanted
     */
    boolean isEnchanted(ItemStack stack);

    /**
     * Set the result of the interaction, consuming the grave's soul or not
     *
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the stack implementing this interface
     * @return if the return is true, the grave's soul will be consumed
     */
    @Deprecated
    default boolean setEnchant(World world, BlockPos gravePos, EntityPlayer player, ItemStack stack) {
        return false;
    }

    default int setEnchant(World world, BlockPos gravePos, EntityPlayerMP player, ItemStack stack, boolean hasStrongSoul) {
        return setEnchant(world, gravePos, player, stack) ? 1 : 0;
    }

    /**
     * @param player the player interacting
     * @return the ITextComponent to display on success
     */
    ITextComponent getEnchantSuccessMessage(EntityPlayer player);

    /**
     * @param player the player interacting
     * @return the ITextComponent to display on fail
     */
    ITextComponent getEnchantFailedMessage(EntityPlayer player);

    /**
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the stack implementing this interface
     */
    default void onSneakGrave(World world, BlockPos gravePos, EntityPlayer player, ItemStack stack) {
    }

    /**
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player sneaking
     * @param stack the stack implementing this interface
     * @return true if the stack can be enchanted
     */
    default boolean canEnchant(World world, BlockPos gravePos, EntityPlayer player, ItemStack stack) {
        return true;
    }

    /**
     * @return the knowledge earned by the player when consuming the grave's soul
     */
    default int getKnowledge() {
        return 1;
    }
}
