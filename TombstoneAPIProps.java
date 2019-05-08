package ovh.corail.tombstone.api;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.versioning.DefaultArtifactVersion;

@SuppressWarnings("WeakerAccess")
public class TombstoneAPIProps {
    public static final String OWNER = "tombstone";
    public static final boolean IS_OWNER_LOADED;

    static {
        IS_OWNER_LOADED = Loader.instance().getActiveModList().stream().anyMatch(mod -> mod.getModId().equals(OWNER) && mod.getProcessedVersion().compareTo(new DefaultArtifactVersion("3.4.0")) >= 0);
    }

    public static final String API = "tombstone-api";
    public static final String VERSION = "1.0.0";
}
