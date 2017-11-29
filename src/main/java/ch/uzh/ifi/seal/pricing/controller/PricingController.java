package ch.uzh.ifi.seal.pricing.controller;

import ch.uzh.ifi.seal.competitor.controller.CompetitorController;
import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;
import ch.uzh.ifi.seal.competitor.service.CompetitorComparisonService;

import java.util.Set;

public class PricingController {
    private final CompetitorController competitorController;
    private final CompetitorComparisonService competitorComparisonService;

    public PricingController() {
        this.competitorController = new CompetitorController();
        this.competitorComparisonService = new CompetitorComparisonService();
    }

    public void setBestPriceForProduct(Product product) {
        //TODO Eines der Hauptstatemente
        /*
            - Konkurrenzdaten sammeln
            - Konkurrenzdaten vergleichen und den besten Preis suchen
            - Mwst. suchen
            - Marge konfigurieren (z.b. für Marke)
            -
         */

        //Crawl competitors to find their prices
        Set<CompetitorSalesInformation> competitorSalesInformationSet = competitorController.crawlCompetitors(product);

        if (competitorSalesInformationSet.size() > 0) {
            //Find best competitor based on certain rules
            CompetitorSalesInformation bestCompetitor = competitorComparisonService.findBestCompetitorSalesInformation(competitorSalesInformationSet);
        } else {
            //In case we don't find a competitor we have set the price based on brand and category

        }

        //After finding the sales price we have to convert it to correct currency and include the VatRate

    }
}
