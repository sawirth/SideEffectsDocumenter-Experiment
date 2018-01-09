package ch.uzh.ifi.seal.advertisement.model;

public class Video {

    public final String Name;

    public final int lengthInSeconds;

    /**
     * Purity: FieldModifier   <br>
     */
    public Video(String name, int lengthInSeconds) {
        Name = name;
        this.lengthInSeconds = lengthInSeconds;
    }
}
