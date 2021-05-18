package ovh.corail.tombstone.api.magic;

import net.minecraft.util.math.BlockPos;

public interface ILocation {
    BlockPos getPos();

    int getDim();
}
