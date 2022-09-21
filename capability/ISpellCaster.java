package ovh.corail.tombstone.api.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;

public interface ISpellCaster {

    boolean isCasting();

    void startCasting(MobEntity caster, int castingTime, int castingColor);

    void stopCasting(MobEntity caster);

    int getCastingColor();

    @OnlyIn(Dist.CLIENT)
    void setCastingColor(int castingColor);

    int getCastingTime();

    boolean hasSpellCooldown();

    void setSpellCooldown();

    Optional<Entity> getSpecialTarget();

    void setSpecialTarget(@Nullable Entity specialTarget);

    void tick(MobEntity mob);

    SoundEvent getCastingSoundEvent();
}
