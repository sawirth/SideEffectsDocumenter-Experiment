package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsService {
    private final double boundary = 1.5;

    public double getMedian(List<Price> prices) {
        List<Price> sortedList = getSortedList(prices);
        double median;
        int size = sortedList.size();

        if (sortedList.size() % 2 != 0) {
            median = sortedList.get(size / 2).getValue();
        } else {
            int lowerPrice = sortedList.get(size / 2).getValue();
            int higherPrice = sortedList.get((size / 2) + 1).getValue();
            median = (lowerPrice + higherPrice) / 2;
        }

        return median;
    }


    private List<Price> getSortedList(List<Price> prices) {
        Price[] sortedArray = new Price[prices.size()];
        sortedArray = prices.toArray(sortedArray);

        for (int i = 1; i < sortedArray.length; i++) {
            Price price = sortedArray[i];
            int j = i;
            while (j > 0 && sortedArray[j - 1].getValue() > price.getValue()) {
                sortedArray[j] = sortedArray[j - 1];
                j--;
            }

            sortedArray[j] = price;
        }

        return new ArrayList<>(Arrays.asList(sortedArray));
    }

    public boolean isUpperOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.getValue() > median + this.boundary * standardDeviation;
    }

    public boolean isLowerOutlier(Price price, List<Price> prices) {
        double standardDeviation = standardDeviation(prices);
        double median = getMedian(prices);
        return price.getValue() < median - this.boundary * standardDeviation;
    }

    private double standardDeviation(List<Price> prices) {
        int N = prices.size();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += prices.get(i).getValue();
        }

        double mean = sum / N;

        double sumSquared = 0;
        for (int i = 0; i < N; i++) {
            sumSquared += Math.pow(prices.get(i).getValue() - mean, 2);
        }

        double meanSquared = sumSquared / N;
        prices.get(0).setValue(2);
        return Math.sqrt(mean);
    }
}
