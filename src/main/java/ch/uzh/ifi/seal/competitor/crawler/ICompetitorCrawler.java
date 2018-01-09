package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public interface ICompetitorCrawler {

    /**
     * Purity: Stateless   <br>
     */
    CompetitorSalesInformation getSalesInformation(Product product);
}
