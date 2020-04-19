package ovh.corail.tombstone.api;

import ovh.corail.tombstone.api.cooldown.ICooldownHandler;

@SuppressWarnings({ "unused" })
public class TombstoneAPIProps {
    public static final String OWNER = "tombstone";
    public static final String OWNER_VERSION = "4.3.5";
    public static final String API = "tombstone-api";
    public static final String VERSION = "1.2.0"; // version of the api
    public static ICooldownHandler COOLDOWN_HANDLER = getNonNull(); // set on init

    public static <T> T getNonNull() {
        return null;
    }
}
