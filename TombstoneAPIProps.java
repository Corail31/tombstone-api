package ovh.corail.tombstone.api;

import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

@SuppressWarnings({ "WeakerAccess", "unused" })
public class TombstoneAPIProps {
    public static final String OWNER = "tombstone";
    public static final boolean IS_OWNER_LOADED;

    static {
        IS_OWNER_LOADED = FMLLoader.getLoadingModList().getMods().stream().filter(mod -> mod.getModId().equals(OWNER)).findFirst().map(mod -> mod.getVersion().compareTo(new DefaultArtifactVersion("3.5.0")) >= 0).orElse(false);
    }

    public static final String API = "tombstone-api";
    public static final String VERSION = "1.0.1";
}
