package necmiexperiment.football;

import java.nio.file.Path;

public class Pitch {
    public Grass grass;
    private int pitchQuality;

    public Pitch() {
        this.grass = new Grass(10, 10);
    }

    public int getQuality() {
        return this.grass.getQuality();
    }

    public void upgradePitch(int type, Path notes) {
        this.grass.upgradeGrassType(type, notes);
    }
}
