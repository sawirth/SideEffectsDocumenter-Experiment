package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsService {

    private final double boundary = 1.5;

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link StatisticsService#getSortedList} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    public double getMedian(List<Price> prices) {
        List<Price> sortedList = getSortedList(prices);
        double median;
        int size = sortedList.size();
        if (sortedList.size() % 2 != 0) {
            median = sortedList.get(size / 2).value;
        } else {
            int lowerPrice = sortedList.get(size / 2).value;
            int higherPrice = sortedList.get((size / 2) + 1).value;
            median = (lowerPrice + higherPrice) / 2;
        }
        return median;
    }

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link ArrayList#ArrayList()} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    private List<Price> getSortedList(List<Price> prices) {
        Price[] sortedArray = new Price[prices.size()];
        sortedArray = prices.toArray(sortedArray);
        for (int i = 1; i < sortedArray.length; i++) {
            Price price = sortedArray[i];
            int j = i;
            while (j > 0 && sortedArray[j - 1].value > price.value) {
                sortedArray[j] = sortedArray[j - 1];
                j--;
            }
            sortedArray[j] = price;
        }
        return new ArrayList<>(Arrays.asList(sortedArray));
    }

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link StatisticsService#getMedian} (origin: {@link java.util.Collection#toArray})      </li>
     * <li>      {@link StatisticsService#standardDeviation} (origin: {@link java.lang.StrictMath#sqrt})      </li>
     * </ul>
     */
    public boolean isUpperOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.value > median + this.boundary * standardDeviation;
    }

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link StatisticsService#standardDeviation} (origin: {@link java.lang.StrictMath#sqrt})      </li>
     * <li>      {@link StatisticsService#getMedian} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    public boolean isLowerOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.value < median - this.boundary * standardDeviation;
    }

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link java.lang.Math#sqrt} (origin: {@link java.lang.StrictMath#sqrt})      </li>
     * <li>      {@link java.lang.Math#pow} (origin: {@link java.lang.StrictMath#pow})      </li>
     * </ul>
     */
    private double standardDeviation(List<Price> prices) {
        int N = prices.size();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += prices.get(i).value;
        }
        double mean = sum / N;
        double sumSquared = 0;
        for (int i = 0; i < N; i++) {
            sumSquared += Math.pow(prices.get(i).value - mean, 2);
        }
        double meanSquared = sumSquared / N;
        prices.get(0).value = 2;
        return Math.sqrt(mean);
    }
}
