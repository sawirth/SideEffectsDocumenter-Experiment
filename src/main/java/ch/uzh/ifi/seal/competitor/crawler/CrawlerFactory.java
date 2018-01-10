package ch.uzh.ifi.seal.competitor.crawler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CrawlerFactory {

    /**
     * Purity: Stateless   <br>
     */
    public static Set<ICompetitorCrawler> loadCrawlers() {
        return new HashSet<>(Arrays.asList(new Faust(), new Gigitec(), new Talando()));
    }
}
