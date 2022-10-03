package ovh.corail.tombstone.api.capability;

import net.minecraft.util.math.BlockPos;

public interface ILocation {
    BlockPos getPos();

    int getDim();
}
