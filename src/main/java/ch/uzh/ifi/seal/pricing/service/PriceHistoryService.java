package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.pricing.model.Price;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriceHistoryService {

    private final Logger logger;

    private static final int UPPER_LIMIT = 8000;

    private static final int LOWER_LIMIT = 0;

    private final List<Integer> priceHistory = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 1, 2, 3, 1));

    /**
     * Purity: FieldModifier   <br>
     */
    public PriceHistoryService() {
        logger = new Logger();
    }

    /**
     * Purity: Stateless   <br>
     */
    public void checkHistoryOfPrice(Price price) {
        Price newPrice = new Price(price.value);
        int currentPrice = price.value;
        boolean isHigherThanHistory = isHigherThanHistory(price);
        if (isHigherThanHistory) {
            logger.log("New highest price");
        }
        boolean isLowerThanHistory = isLowerThanHistory(price);
        if (isLowerThanHistory) {
            logger.log("New lowest price");
        }
        if (!isLowerThanHistory && !isHigherThanHistory) {
            logger.log("Price within range of price history");
        }
        if (currentPrice > UPPER_LIMIT) {
            logger.log("Price above upper limit which is not allowed");
        }
        if (currentPrice < LOWER_LIMIT) {
            logger.log("Price below lower limit which is not allowed");
        }
        Price futurePrice = calculateFuturePrice(newPrice);
        futurePrice.value *= 1.001;
        if (futurePrice.value > price.value) {
            logger.log("Future price might be higher than right now");
        }
    }

    /**
     * Purity: OO Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price.priceHistory (List;)      </li>
     * </ul>
     */
    private boolean isHigherThanHistory(Price price) {
        for (Integer integer : priceHistory)
        {
            if (price.value > integer) {
                return true;
            }
        }
        return false;
    }

    /**
     * Purity: OO Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price.priceHistory (List;)      </li>
     * </ul>
     */
    private boolean isLowerThanHistory(Price price) {
        for (Integer integer : priceHistory)
        {
            if (price.value < integer) {
                return true;
            }
        }
        return false;
    }

    /**
     * Purity: ArgumentModifier   <br>
     * 
     * Modifies the following arguments:
     * <ul>
     * <li>      price (via Price.setValue)      </li>
     * </ul>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * </ul>
     */
    private Price calculateFuturePrice(Price price) {
        double newPrice = price.value * TrendFactorHelper.calculateTrendFactor(price);
        price.value = (int) newPrice;
        return price;
    }
}
