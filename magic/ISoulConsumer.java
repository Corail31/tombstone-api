package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

/**
 * This capability interface allows a player to interact a grave with an itemstack
 */
public interface ISoulConsumer {
    /**
     * @param stack the itemstack
     * @return return true if the stack is already enchanted
     */
    boolean isEnchanted(ItemStack stack);

    /**
     * Set the result of the interaction, consuming the grave's soul or not
     *
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the itemstack implementing this interface
     * @param soulStrenght the strenght of the soul to be consumed
     * @return return soul strenght to be consumed, 0 is a fail
     */
    default int setEnchant(World world, BlockPos gravePos, ServerPlayerEntity player, ItemStack stack, int soulStrenght) {
        return setEnchant(world, gravePos, player, stack) ? 1 : 0;
    }

    @Deprecated
    default boolean setEnchant(World world, BlockPos gravePos, PlayerEntity player, ItemStack stack) {
        // TODO remove in 1.17
        return false;
    }

    /**
     * @param player the player interacting
     * @return the ITextComponent to display on success
     */
    ITextComponent getEnchantSuccessMessage(PlayerEntity player);

    /**
     * @param player the player interacting
     * @return the ITextComponent to display on fail
     */
    ITextComponent getEnchantFailedMessage(PlayerEntity player);

    /**
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player sneaking
     * @param stack the itemstack
     */
    default void onSneakGrave(World world, BlockPos gravePos, PlayerEntity player, ItemStack stack) {
    }

    /**
     * @param world the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the itemstack implementing this interface
     * @return true if the itemstack can be enchanted
     */
    default boolean canEnchant(World world, BlockPos gravePos, PlayerEntity player, ItemStack stack) {
        return true;
    }

    /**
     * @return the knowledge earned by the player when consuming the grave's soul
     */
    default int getKnowledge() {
        return 1;
    }
}
