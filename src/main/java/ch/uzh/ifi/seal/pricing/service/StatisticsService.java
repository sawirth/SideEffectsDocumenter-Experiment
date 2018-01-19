package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsService {

    private final double boundary = 1.5;

    /**
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
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
     * Purity: Stateless   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
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
     * Purity: ArgumentModifier   <br>
     *
     * Modifies the following arguments:
     * <ul>
     * <li>    prices (via {@link StatisticsService#standardDeviation(List)})   </li>
     * </ul>
     *
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     */
    public boolean isUpperOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.value > median + this.boundary * standardDeviation;
    }

    /**
     * Purity: ArgumentModifier   <br>
     *
     * Modifies the following arguments:
     * <ul>
     * <li>    prices (via {@link StatisticsService#standardDeviation(List)})    </li>
     * </ul>
     *
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: price (Price)      </li>
     * <li>      Argument: prices (List<Price>)      </li>
     * </ul>
     */
    public boolean isLowerOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.value < median - this.boundary * standardDeviation;
    }

    /**
     * Purity: ArgumentModifier   <br>
     *
     * Modifies the following argument:
     * <ul>
     * <li>    prices    </li>
     * </ul>
     *
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: prices (List<Price>)      </li>
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

        // ==================================================================
        // THIS IS THE ERROR YOU ARE LOOKING FOR :) Delete the following line
        // ==================================================================
        prices.get(0).value = 2;
        return Math.sqrt(mean);
    }
}
