package ch.uzh.ifi.seal.pricing.controller;

import ch.uzh.ifi.seal.competitor.controller.CompetitorController;
import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.pricing.model.CompetitorOffer;
import ch.uzh.ifi.seal.pricing.model.RelativeOffer;
import ch.uzh.ifi.seal.pricing.model.SalesOffer;
import ch.uzh.ifi.seal.pricing.service.RelativePricingService;
import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.competitor.service.CompetitorComparisonService;
import ch.uzh.ifi.seal.vatrate.service.VatRateService;
import java.util.Comparator;
import java.util.Set;

public class PricingController {
    private final CompetitorController competitorController;
    private final CompetitorComparisonService competitorComparisonService;
    private final RelativePricingService relativePricingService;
    private final VatRateService vatRateService;

    public PricingController() {
        competitorController = new CompetitorController();
        competitorComparisonService = new CompetitorComparisonService();
        relativePricingService = new RelativePricingService();
        vatRateService = new VatRateService();
    }

    public void setBestPriceForProduct(Product product) {
        //We need to correct VatRate (Mehrwertsteuer) for this product to make a correct price
        double vatRateFraction = vatRateService.getVatRateFraction("Switzerland");

        //Crawl competitors to find their prices
        Set<CompetitorSalesInformation> competitorSalesInformationSet = competitorController.crawlCompetitors(product);

        SalesOffer salesOffer = null;
        if (competitorSalesInformationSet.size() > 0) {
            //Find best competitor based on certain rules
            CompetitorSalesInformation bestCompetitor =
                    competitorComparisonService.findBestCompetitorSalesInformation(competitorSalesInformationSet);

            salesOffer = new CompetitorOffer(vatRateFraction, Currency.CHF, bestCompetitor.Price, 2.5);
        } else {
            //In case we don't find a competitor we have set the price based on brand and category
            double fraction = relativePricingService.getBrandFraction(product.Brand)
                    + relativePricingService.getCategoryFraction(product.Category);

            //Find the cheapest purchase price
            double bestPurchasePrice = product.PurchasingInformation.stream()
                    .min(Comparator.comparingDouble(p -> p.priceExcl))
                    .get().priceExcl;

            salesOffer = new RelativeOffer(bestPurchasePrice, fraction, vatRateFraction, Currency.CHF);
        }

        product.SalesOffer = salesOffer;
    }
}
