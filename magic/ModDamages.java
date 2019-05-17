package ovh.corail.tombstone.api.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class ModDamages {
    public static DamageSource BEYOND_THE_GRAVE = new DamageSource("beyond_the_grave").setDamageBypassesArmor().setDamageIsAbsolute();

    public class TombstoneDamageSource extends DamageSource {
        public TombstoneDamageSource(String damageType) {
            super(damageType);
        }

        @Override
        public ITextComponent getDeathMessage(EntityLivingBase entity) {
            return new TextComponentTranslation("tombstone.death." + damageType, entity.getDisplayName());
        }
    }
}
