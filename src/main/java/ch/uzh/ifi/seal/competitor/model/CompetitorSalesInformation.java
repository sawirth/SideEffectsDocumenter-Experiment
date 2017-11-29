package ch.uzh.ifi.seal.competitor.model;

public class CompetitorSalesInformation {
    public final String Competitor;
    public final double Price;
    public final int DeliveryDuration;

    public CompetitorSalesInformation(String competitor, double price, int deliveryDuration) {
        Competitor = competitor;
        Price = price;
        DeliveryDuration = deliveryDuration;
    }
}
