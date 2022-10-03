package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
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
     * @param soulStrength the strenght of the soul to be consumed
     * @return return soul strenght to be consumed, 0 is a fail
     */
    ConsumeResult setEnchant(World world, BlockPos gravePos, EntityPlayerMP player, ItemStack stack, int soulStrength);

    /**
     * @return return if the offhand is used to enchant (mainhand being the default)
     */
    default boolean isUsingOffhandToEnchant() {
        return false;
    }

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

    final class ConsumeResult {
        private final Result result;
        private final ITextComponent message;
        private final int soulStrength;

        public ConsumeResult(Result result, ITextComponent message, int soulStrength) {
            this.result = result;
            this.message = message;
            this.soulStrength = soulStrength;
        }

        public enum Result {
            SUCCESS, FAIL;

            public boolean success() {
                return this == SUCCESS;
            }

            public boolean fail() {
                return this == FAIL;
            }
        }

        public static ConsumeResult success(int soulStrength) {
            return new ConsumeResult(Result.SUCCESS, MESSAGE_ENCHANT_ITEM_SUCCESS, soulStrength);
        }

        public static ConsumeResult success(ITextComponent message, int soulStrength) {
            return new ConsumeResult(Result.SUCCESS, message, soulStrength);
        }

        public static ConsumeResult fail() {
            return new ConsumeResult(Result.FAIL, MESSAGE_ENCHANT_ITEM_FAILED, 0);
        }

        public static ConsumeResult fail(ITextComponent message) {
            return new ConsumeResult(Result.FAIL, message, 0);
        }

        public Result result() {
            return result;
        }

        public ITextComponent message() {
            return message;
        }

        public int soulStrength() {
            return soulStrength;
        }
    }

    ITextComponent MESSAGE_ENCHANT_ITEM_SUCCESS = new TextComponentTranslation("tombstone.message.enchant_item.success");
    ITextComponent MESSAGE_ENCHANT_ITEM_FAILED = new TextComponentTranslation("tombstone.message.enchant_item.failed");
}
