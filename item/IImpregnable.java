package ovh.corail.tombstone.api.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public interface IImpregnable {
    String getEntityType(ItemStack stack);

    ItemStack impregnate(ItemStack stack, String entityType);

    boolean impregnate(ItemStack stack, @Nullable LivingEntity entity);

    boolean isImpregnated(ItemStack stack);

    @Nullable
    ITextComponent getTooltipDisplay(ItemStack stack);
}
