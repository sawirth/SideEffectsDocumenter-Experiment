package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.currency.model.Currency;

public class RelativeOffer extends SalesOffer {

    private double purchasePrice;

    private double fraction;

    /**
     * Purity: FieldModifier   <br>
     */
    public RelativeOffer(double purchasePrice, double fraction, double vatRateFraction, Currency currency) {
        super(purchasePrice * fraction, vatRateFraction, currency);
        this.purchasePrice = purchasePrice;
        this.fraction = fraction;
    }
}
