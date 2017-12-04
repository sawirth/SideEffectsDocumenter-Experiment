package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.pricing.model.LimitedOffer;
import ch.uzh.ifi.seal.product.model.Product;
import java.time.LocalDateTime;

public class DealOfferService {
    public void makeDeal(double discount, int quantity, Product product) {
        double currentPrice = product.SalesOffer.getPriceExcl();
        double dealPrice = currentPrice * (1 - discount);
        product.SalesOffer = new LimitedOffer(dealPrice,
                                              product.SalesOffer.getVatRateFraction(),
                                              Currency.CHF,
                                              quantity,
                                              LocalDateTime.now().plusDays(10));

        product.SalesOffer.activateSalesOffer();
    }
}
