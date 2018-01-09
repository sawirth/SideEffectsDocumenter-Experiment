package ch.uzh.ifi.seal.advertisement.model;

public class Image {

    public int BlurLevel;

    public int Saturation;

    public String InstagramFilter;

    public String FileName;

    public final String Source;

    /**
     * Purity: FieldModifier   <br>
     */
    public Image(String source, String fileName) {
        this.Source = source;
        this.FileName = fileName;
    }
}
