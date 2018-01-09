package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.advertisement.service.SpamService;
import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.pricing.model.Price;
import ch.uzh.ifi.seal.pricing.model.PriceController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PricingService {

    private final PriceHistoryService priceHistoryService;

    private final StatisticsService statisticsService;

    private final Logger logger;

    /**
     * Purity: FieldModifier, Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link PriceHistoryService#PriceHistoryService()} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    public PricingService() {
        priceHistoryService = new PriceHistoryService();
        logger = new Logger();
        statisticsService = new StatisticsService();
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link PriceController#controlPrices} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link SpamService#sendSpam} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * <li>      {@link PricingService#comparePrices} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    public void verifyPrice(Price price, List<Price> prices) {
        for (Price p : prices) {
            verify(p);
        }
        double proportionToAveragePrice = calculateProportionToAveragePrice(price, prices);
        if (proportionToAveragePrice < 0) {
            logger.log("Price is smaller than the average price");
        } else if (proportionToAveragePrice > 0) {
            logger.log("Price is higher than the average price");
        } else {
            logger.log("Price is equals to the average price");
        }
        PriceController priceController = new PriceController(prices);
        priceController.controlPrices();
        double profit = ProfitService.calculateProfit(price);
        if (profit > 0) {
            logger.log("Profit made, yay :) ");
        } else if (profit < 0) {
            logger.log("We are losing money :( ");
        }
        Price lowestPrice = getLowestPrice(prices);
        if (lowestPrice != null) {
            if (lowestPrice.value < price.value) {
                logger.log("Price is higher than the lowest price");
            } else if (lowestPrice.value > price.value) {
                logger.log("Price is lower than the lowest price");
            }
        }
        Price highestPrice = getHighestPrice(prices);
        if (highestPrice != null) {
            if (highestPrice.value > price.value) {
                logger.log("Price is lower than the highest price");
            } else if (highestPrice.value < price.value) {
                logger.log("Price is higher than the highest price");
            }
        }
        comparePrices(price, prices);
        SpamService spamService = new SpamService();
        spamService.sendSpam(prices);
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     */
    private double calculateProportionToAveragePrice(Price price, List<Price> prices) {
        int sum = 0;
        for (Price p : prices) {
            sum += p.value;
        }
        return getProportionToAverage(price, prices, sum);
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * <li>      Argument: sum (int)      </li>
     * </ul>
     */
    private double getProportionToAverage(Price price, List<Price> prices, int sum) {
        double averagePrice = sum / prices.size();
        return price.value / averagePrice;
    }

    /**
     * Purity: Stateless   <br>
     */
    private void verify(Price price) {
        logger.log("Checking price history");
        priceHistoryService.checkHistoryOfPrice(price);
        PricingHelper.doStuff(price);
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     */
    private Price getHighestPrice(List<Price> prices) {
        if (prices.size() <= 0) {
            return null;
        }
        Price highestPrice = prices.get(0);
        for (Price price : prices) {
            if (price.value > highestPrice.value) {
                highestPrice = price;
            }
        }
        return highestPrice;
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link PricingService#comparePriceToOutlier} (origin: {@link java.util.Collection#toArray})      </li>
     * <li>      {@link PricingService#comparePriceToMedian} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    private void comparePrices(Price price, List<Price> prices) {
        comparePriceToMedian(price, prices);
        comparePriceToOutlier(price, prices);
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link StatisticsService#getMedian} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    private void comparePriceToMedian(Price price, List<Price> prices) {
        int size = prices.size();
        if (size <= 0) {
            return;
        }
        double median = statisticsService.getMedian(prices);

        if (price.value < median) {
            logger.log("Price is below median");
        } else if (price.value > median) {
            logger.log("Price is above median");
        } else {
            logger.log("Price is the median");
        }
    }

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link StatisticsService#isUpperOutlier} (origin: {@link java.util.Collection#toArray})      </li>
     * <li>      {@link StatisticsService#isLowerOutlier} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    private void comparePriceToOutlier(Price price, List<Price> prices) {
        boolean isUpperOutlier = statisticsService.isUpperOutlier(price, prices);
        if (isUpperOutlier) {
            logger.log("Price is an upper outlier");
        }
        boolean isLowerOutlier = statisticsService.isLowerOutlier(price, prices);
        if (isLowerOutlier) {
            logger.log("Price is lower outlier");
        }
    }

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     */
    private Price getLowestPrice(List<Price> prices) {
        if (prices.size() <= 0) {
            return null;
        }
        Price highestPrice = prices.get(0);
        for (Price price : prices) {
            if (price.value < highestPrice.value) {
                highestPrice = price;
            }
        }
        return highestPrice;
    }
}
