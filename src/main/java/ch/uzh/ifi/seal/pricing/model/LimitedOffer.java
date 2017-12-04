package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.currency.model.Currency;
import java.time.LocalDateTime;

public class LimitedOffer extends SalesOffer {
    private int quantity;
    private LocalDateTime endDate;

    public LimitedOffer(double priceExcl,
                        double vatRateFraction,
                        Currency currency,
                        int quantity, LocalDateTime endDate)
    {
        super(priceExcl, vatRateFraction, currency);
        this.quantity = quantity;
        this.endDate = endDate;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && this.endDate == null && this.quantity > 0;
    }
}
