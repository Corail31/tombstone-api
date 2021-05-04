package ovh.corail.tombstone.api;

import ovh.corail.tombstone.api.cooldown.ICooldownHandler;

public class TombstoneAPIProps {
    public static final String OWNER = "tombstone";
    public static final String OWNER_VERSION = "4.3.0";
    public static final String API = "tombstone-api";
    public static final String VERSION = "1.1.0"; // version of the api
    public static ICooldownHandler COOLDOWN_HANDLER = unsafeNullCast(); // set on init

    @SuppressWarnings("ConstantConditions")
    public static <T> T unsafeNullCast() {
        return null;
    }
}
