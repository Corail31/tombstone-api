package ovh.corail.tombstone.api;

import ovh.corail.tombstone.api.cooldown.ICooldownHandler;

@SuppressWarnings({ "unused" })
public final class TombstoneAPIProps {
    public static final String OWNER = "tombstone";
    public static final String OWNER_VERSION = "8.1.5";
    public static final String API = "tombstone-api";
    public static final String VERSION = "2.2.0"; // version of the api
    public static ICooldownHandler COOLDOWN_HANDLER = unsafeNullCast(); // set on init

    @SuppressWarnings("ConstantConditions")
    public static <T> T unsafeNullCast() {
        return null;
    }
}
