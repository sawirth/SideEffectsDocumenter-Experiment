package ch.uzh.ifi.seal.competitor.service;

import ch.uzh.ifi.seal.competitor.model.CompetitorSalesInformation;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class CompetitorComparisonService {
    public CompetitorSalesInformation findBestCompetitorSalesInformation(Set<CompetitorSalesInformation> competitorSalesInformationSet) {
        //Find our delivery
        int ourDeliveryDuration = 10;

        //Compare with competitors
        return Collections.min(competitorSalesInformationSet,
                               Comparator.comparing(c -> getPriceWithPenalty(c, ourDeliveryDuration)));
    }

    private double getPriceWithPenalty(CompetitorSalesInformation competitorSalesInformation, int ourDeliveryDuration) {
        double penaltyFraction = 1;
        int deliveryDurationDifference = competitorSalesInformation.DeliveryDuration - ourDeliveryDuration;

        if (deliveryDurationDifference < 0) {
            penaltyFraction -= 0.02;
        } else if (deliveryDurationDifference > 0 && deliveryDurationDifference < 5) {
            penaltyFraction += 0.02;
        } else if (deliveryDurationDifference >= 5 && deliveryDurationDifference < 10) {
            penaltyFraction += 0.05;
        } else {
            penaltyFraction += 0.1;
        }

        penaltyFraction += getNamePenaltyFraction(competitorSalesInformation.Competitor);

        return competitorSalesInformation.Price * penaltyFraction;
    }

    private double getNamePenaltyFraction(String competitor) {
        if (competitor.equals("Talando")) {
            return 0.01;
        }

        if (competitor.equals("Gigitec")) {
            return 0.02;
        }

        return 0;
    }
}
