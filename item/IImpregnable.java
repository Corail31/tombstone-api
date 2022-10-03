package ovh.corail.tombstone.api.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public interface IImpregnable {
    String getEntityType(ItemStack stack);

    ItemStack impregnate(ItemStack stack, String entityType);

    boolean impregnate(ItemStack stack, @Nullable EntityLivingBase entity);

    boolean isImpregnated(ItemStack stack);

    @Nullable
    String getTooltipDisplay(ItemStack stack);
}
