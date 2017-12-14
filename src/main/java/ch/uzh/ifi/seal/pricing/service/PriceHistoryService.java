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

    public PriceHistoryService() {
        logger = new Logger();
    }

    public void checkHistoryOfPrice(Price price) {
        Price newPrice = new Price(price.getValue());
        int currentPrice = price.getValue();
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
        if (futurePrice.getValue() > price.getValue()) {
            logger.log("Future price might be higher than right now");
        }
    }

    private boolean isHigherThanHistory(Price price) {
        for (Integer integer : priceHistory)
        {
            if (price.getValue() > integer) {
                return true;
            }
        }

        return false;
    }

    private boolean isLowerThanHistory(Price price) {
        for (Integer integer : priceHistory)
        {
            if (price.getValue() < integer) {
                return true;
            }
        }

        return false;
    }

    private Price calculateFuturePrice(Price price) {
        double newPrice = price.getValue() * TrendFactorHelper.calculateTrendFactor(price);
        price.setValue((int) newPrice);
        return price;
    }
}
