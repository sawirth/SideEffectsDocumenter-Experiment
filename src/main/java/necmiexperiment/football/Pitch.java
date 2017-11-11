package necmiexperiment.football;

public class Pitch {
    private Grass grass;
    private int pitchQuality;

    public Pitch() {
        this.grass = new Grass(10, 10);
    }

    public int getQuality() {
        return this.grass.getQuality();
    }

    public void upgradePitch(int type) {
        this.grass.upgradeGrassType(type);
    }
}
