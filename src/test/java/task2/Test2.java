package task2;

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

        // ==============================================================
        // ==== EXPERIMENT CODE: DO NOT CHANGE ANYTHING IN THIS FILE ====
        // ==============================================================

        List<Price> prices = new ArrayList<>(Arrays.asList(
                new Price(1),
                new Price(5),
                new Price(4),
                new Price(2),
                new Price(7),
                new Price(1),
                new Price(2),
                new Price(5),
                new Price(8),
                new Price(2)
        ));

        PricingService pricingService = new PricingService();

        int sum = 0;
        for (Price price : prices) {
            pricingService.verifyPrice(price, prices);
            sum += price.value;
        }

        int expectedSum = 37;
        Assert.assertEquals(expectedSum, sum);
    }
}