package ch.uzh.ifi.seal.pricing.service;

import ch.uzh.ifi.seal.pricing.model.Price;
import ch.uzh.ifi.seal.vatrate.service.VatRateService;

public class ProfitService {
    public static double calculateProfit(Price price) {
        VatRateService vatRateService = new VatRateService();
        RelativePricingService relativePricingService = new RelativePricingService();
        double margin = relativePricingService.getCategoryFraction("Tablet") + relativePricingService.getBrandFraction("Apple");
        return (price.getValue() * margin * vatRateService.getVatRateFraction("Switzerland"))  - price.getValue();
    }
}
