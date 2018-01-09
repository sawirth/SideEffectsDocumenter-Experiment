package ch.uzh.ifi.seal.marketing.model;

public class MarketingInformation {

    public final String Language;

    public final String Description;

    public final String TagLine;

    /**
     * Purity: FieldModifier   <br>
     */
    public MarketingInformation(String language, String description, String tagline) {
        Language = language;
        Description = description;
        TagLine = tagline;
    }
}
