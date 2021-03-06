package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public class Faust implements ICompetitorCrawler {
    @Override
    public CompetitorSalesInformation getSalesInformation(Product product) {
        return new CompetitorSalesInformation(
                "Faust",
                19.99,
                2
        );
    }
}
