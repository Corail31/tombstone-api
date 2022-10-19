package ovh.corail.tombstone.api.event;

import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.eventbus.api.Event;

/**
 * Called when a Grave Guardian initiates its merchant offers (not cancelable)
 */
public final class MerchantOffersEvent extends Event {
    private final Merchant merchant;
    private final int merchantLevel;
    private final MerchantOffers merchantOffers;

    public MerchantOffersEvent(Merchant merchant, int merchantLevel, MerchantOffers merchantOffers) {
        this.merchant = merchant;
        this.merchantLevel = merchantLevel;
        this.merchantOffers = merchantOffers;
    }

    public Merchant getMerchant() {
        return this.merchant;
    }

    public int getMerchantLevel() {
        return this.merchantLevel;
    }

    public MerchantOffers getMerchantOffers() {
        return this.merchantOffers;
    }
}
