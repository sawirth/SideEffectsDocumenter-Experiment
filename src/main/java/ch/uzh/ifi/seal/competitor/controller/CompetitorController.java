package ch.uzh.ifi.seal.competitor.controller;

import ch.uzh.ifi.seal.competitor.crawler.CrawlerFactory;
import ch.uzh.ifi.seal.competitor.crawler.ICompetitorCrawler;
import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import ch.uzh.ifi.seal.product.model.Product;
import java.util.HashSet;
import java.util.Set;

public class CompetitorController {

    /**
     * Purity: Stateless   <br>
     */
    public Set<CompetitorSalesInformation> crawlCompetitors(Product product) {
        Set<ICompetitorCrawler> crawlers = CrawlerFactory.loadCrawlers();
        Set<CompetitorSalesInformation> competitorSalesInformations = new HashSet<>();
        for (ICompetitorCrawler crawler : crawlers) {
            CompetitorSalesInformation info = crawler.getSalesInformation(product);
            competitorSalesInformations.add(info);
        }
        return competitorSalesInformations;
    }
}
