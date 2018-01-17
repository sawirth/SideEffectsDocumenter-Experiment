package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;

public class TrendFactorHelper {
    public static double calculateTrendFactor(Price price) {
        double worstPercentagePrice = percentage(price.value, 0.01);
        double middlePercentagePrice = percentage(price.value, 0.025);
        double bestPercentagePrice = percentage(price.value, 0.045);

        return (3 * worstPercentagePrice + 2 * middlePercentagePrice + 4 * bestPercentagePrice) / 9;
    }

    private static double percentage(int value, double fraction) {
        return value * fraction;
    }
}
