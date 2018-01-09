package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public class Talando implements ICompetitorCrawler {

    /**
     * Purity: Stateless   <br>
     */
    @Override
    public CompetitorSalesInformation getSalesInformation(Product product) {
        return new CompetitorSalesInformation("Talando", 21.50, 3);
    }
}
