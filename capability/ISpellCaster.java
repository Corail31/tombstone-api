package ovh.corail.tombstone.api.capability;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface ISpellCaster {

    boolean isCasting();

    void startCasting(Mob caster, int castingTime, int castingColor);

    void stopCasting(Mob caster);

    int getCastingColor();

    @OnlyIn(Dist.CLIENT)
    void setCastingColor(int castingColor);

    boolean hasSpellCooldown();

    void setSpellCooldown();

    Optional<Entity> getSpecialTarget();

    void setSpecialTarget(@Nullable Entity specialTarget);

    void tick(Mob caster);

    SoundEvent getCastingSoundEvent();
}
