package task2;

import ch.uzh.ifi.seal.advertisement.service.SpamService;
import ch.uzh.ifi.seal.pricing.model.Price;
import ch.uzh.ifi.seal.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    @Test
    public void task2() {
        //
        // === EXPERIMENT CODE - DO NOT CHANGE! ===
        //
        List<Price> prices = new ArrayList<>(Arrays.asList(
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1),
                new Price(1)
        ));

        //Verify Prices
        PricingService pricingService = new PricingService();
        pricingService.verifyPrices(prices);

        //Spam
        SpamService spamService = new SpamService();
        spamService.sendSpam(prices);

        //TODO more branches


        //
        // === END OF EXPERIMENT CODE ===
        //


        // =========================================
        // What is the expected sum over all prices?
        // =========================================
        int expectedSum = 10;


        //Verification
        int actualSum = prices.stream().mapToInt(Price::getValue).sum();
        Assert.assertEquals(expectedSum, actualSum);
    }
}
