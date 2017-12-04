package ch.uzh.ifi.seal.pricing.model;

import ch.uzh.ifi.seal.currency.model.Currency;

public class CompetitorOffer extends SalesOffer {
    private double competitorPrice;
    private double differenceToCompetitor;

    public CompetitorOffer(double vatRateFraction,
                           Currency currency,
                           double competitorPrice,
                           double differenceToCompetitor)
    {
        super(competitorPrice + differenceToCompetitor, vatRateFraction, currency);
        this.competitorPrice = competitorPrice;
        this.differenceToCompetitor = differenceToCompetitor;
    }
}
