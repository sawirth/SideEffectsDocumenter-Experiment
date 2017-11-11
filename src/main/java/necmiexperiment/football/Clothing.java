package necmiexperiment.football;

public class Clothing {
    private int comfort;
    private int robustness;
    private int quality;

    public Clothing() {
        this.comfort = 20;
        this.robustness = 10;
        this.quality = this.comfort + this.robustness;
    }

    public int getQuality() {
        return this.comfort + this.robustness;
    }

    public void setQuality(int upgradeValue) {
        this.comfort += upgradeValue;
        this.robustness += upgradeValue;
    }
}
