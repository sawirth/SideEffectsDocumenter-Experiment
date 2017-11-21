package necmiexperiment.football;

public class Shoe {

    private int comfort;

    private int robustness;

    public Shoe() {
        this.comfort = 10;
        this.robustness = 10;
    }

    public int getQuality() {
        return this.comfort + this.robustness;
    }

    public void setQuality(int quality) {
        this.comfort += quality;
        this.robustness += quality;
    }
}
