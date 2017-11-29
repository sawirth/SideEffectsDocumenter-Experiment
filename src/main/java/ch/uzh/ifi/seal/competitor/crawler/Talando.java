package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public class Talando implements ICompetitorCrawler {
    @Override
    public CompetitorSalesInformation getSalesInformation(Product product) {
        return new CompetitorSalesInformation(
                "Talando",
                21.50,
                3
        );
    }
}
