package ch.uzh.ifi.seal.image.model;

public class ProductImage {
    public final String FileName;
    public final int widthPx;
    public final int heightPx;
    public final double sizeKB;

    public ProductImage(String fileName, int widthPx, int heightPx, double sizeKB) {
        FileName = fileName;
        this.widthPx = widthPx;
        this.heightPx = heightPx;
        this.sizeKB = sizeKB;
    }
}
