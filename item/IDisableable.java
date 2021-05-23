package ovh.corail.tombstone.api.item;

import net.minecraft.item.ItemStack;

public interface IDisableable {
    boolean isEnabled();

    default boolean isEnabled(ItemStack stack) {
        return isEnabled();
    }
}
