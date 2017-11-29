package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public class Gigitec implements ICompetitorCrawler {
    @Override
    public CompetitorSalesInformation getSalesInformation(Product product) {
        return new CompetitorSalesInformation(
                "Gigitec",
                17.50,
                1
        );
    }
}
