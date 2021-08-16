package ovh.corail.tombstone.api.capability;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
     * @param level the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the itemstack implementing this interface
     * @param soulStrength the strenght of the soul to be consumed
     * @return return soul strenght to be consumed, 0 is a fail
     */
    ConsumeResult setEnchant(Level level, BlockPos gravePos, ServerPlayer player, ItemStack stack, int soulStrength);

    /**
     * @param level the world of the grave
     * @param gravePos the position of the grave
     * @param player the player sneaking
     * @param stack the itemstack
     */
    default void onSneakGrave(Level level, BlockPos gravePos, Player player, ItemStack stack) {
    }

    /**
     * @param level the world of the grave
     * @param gravePos the position of the grave
     * @param player the player interacting
     * @param stack the itemstack implementing this interface
     * @return true if the itemstack can be enchanted
     */
    default boolean canEnchant(Level level, BlockPos gravePos, Player player, ItemStack stack) {
        return true;
    }

    /**
     * @return the knowledge earned by the player when consuming the grave's soul
     */
    default int getKnowledge() {
        return 1;
    }

    record ConsumeResult(Result result, Component message, int soulStrength) {
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

        public static ConsumeResult success(Component message, int soulStrength) {
            return new ConsumeResult(Result.SUCCESS, message, soulStrength);
        }

        public static ConsumeResult fail() {
            return new ConsumeResult(Result.FAIL, MESSAGE_ENCHANT_ITEM_FAILED, 0);
        }

        public static ConsumeResult fail(Component message) {
            return new ConsumeResult(Result.FAIL, message, 0);
        }
    }

    Component MESSAGE_ENCHANT_ITEM_SUCCESS = new TranslatableComponent("tombstone.message.enchant_item.success");
    Component MESSAGE_ENCHANT_ITEM_FAILED = new TranslatableComponent("tombstone.message.enchant_item.failed");
}
