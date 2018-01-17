package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;

public class PricingHelper {
    public static void doStuff(Price price) {
        int number = 0;
        for (int i = 0; i < price.value; i++) {
            number += i;
            Price newPrice = new Price(1);
            newPrice.value = 1;
        }
    }
}
