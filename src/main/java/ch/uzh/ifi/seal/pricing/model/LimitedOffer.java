package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.currency.model.Currency;
import java.time.LocalDateTime;

public class LimitedOffer extends SalesOffer {

    private int quantity;

    private LocalDateTime endDate;

    /**
     * Purity: FieldModifier   <br>
     */
    public LimitedOffer(double priceExcl, double vatRateFraction, Currency currency, int quantity, LocalDateTime endDate) {
        super(priceExcl, vatRateFraction, currency);
        this.quantity = quantity;
        this.endDate = endDate;
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Field: this.quantity (int)      </li>
     * </ul>
     */
    @Override
    public boolean isValid() {
        return super.isValid() && this.endDate == null && this.quantity > 0;
    }
}
