package ch.uzh.ifi.seal.competitor.crawler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CrawlerFactory {

    /**
     * Purity: Native   <br>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link HashSet#HashSet()} (origin: {@link java.lang.Float#floatToRawIntBits})      </li>
     * </ul>
     */
    public static Set<ICompetitorCrawler> loadCrawlers() {
        return new HashSet<>(Arrays.asList(new Faust(), new Gigitec(), new Talando()));
    }
}
