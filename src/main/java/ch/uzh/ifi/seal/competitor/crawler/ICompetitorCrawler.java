package ch.uzh.ifi.seal.competitor.crawler;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;

public interface ICompetitorCrawler {
    CompetitorSalesInformation getSalesInformation(Product product);
}
