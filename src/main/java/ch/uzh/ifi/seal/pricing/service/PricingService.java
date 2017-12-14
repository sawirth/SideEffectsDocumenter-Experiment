package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.log.Logger;
import ch.uzh.ifi.seal.pricing.model.Price;
import ch.uzh.ifi.seal.pricing.model.PriceController;

import java.util.List;

public class PricingService {

    private final PriceHistoryService priceHistoryService;
    private final Logger logger;

    public PricingService() {
        priceHistoryService = new PriceHistoryService();
        logger = new Logger();
    }

    public void verifyPrices(List<Price> prices) {
        for (Price price : prices) {
            verify(price);
        }

        //TODO
        PriceController priceController = new PriceController(prices);
        priceController.controlPrices();
    }

    private void verify(Price price) {
        logger.log("Checking price history");
        priceHistoryService.checkHistoryOfPrice(price);
        PricingHelper.doStuff(price);
    }
}
