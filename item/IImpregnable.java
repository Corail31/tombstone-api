package ovh.corail.tombstone.api.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

public interface IImpregnable {
    String getEntityType(ItemStack stack);

    ItemStack impregnate(ItemStack stack, String entityType);

    boolean impregnate(ItemStack stack, @Nullable LivingEntity entity);

    boolean isImpregnated(ItemStack stack);

    @Nullable
    Component getTooltipDisplay(ItemStack stack);
}
