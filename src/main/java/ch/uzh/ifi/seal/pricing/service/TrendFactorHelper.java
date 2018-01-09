package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;

public class TrendFactorHelper {

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * </ul>
     */
    public static double calculateTrendFactor(Price price) {
        double worstPercentagePrice = percentage(price.value, 0.01);
        double middlePercentagePrice = percentage(price.value, 0.025);
        double bestPercentagePrice = percentage(price.value, 0.045);

        return (3 * worstPercentagePrice + 2 * middlePercentagePrice + 4 * bestPercentagePrice) / 9;
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: value (int)      </li>
     * <li>      Argument: fraction (double)      </li>
     * </ul>
     */
    private static double percentage(int value, double fraction) {
        return value * fraction;
    }
}
