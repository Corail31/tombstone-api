package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModDamages {
    public static DamageSource BEYOND_THE_GRAVE = new TombstoneDamageSource("beyond_the_grave").bypassArmor().bypassInvul().bypassMagic();

    public static class TombstoneDamageSource extends DamageSource {

        TombstoneDamageSource(String damageType) {
            super(damageType);
        }

        @Override
        public ITextComponent getLocalizedDeathMessage(LivingEntity entity) {
            return new TranslationTextComponent("tombstone.death." + this.msgId, entity.getDisplayName());
        }
    }
}
