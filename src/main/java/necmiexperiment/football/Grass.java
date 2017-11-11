package necmiexperiment.football;

public class Grass {
    public int grassType;
    public int grassLength;
    public int grassQuality;

    public Grass(int grassType, int grassLength) {
        this.grassLength = grassLength;
        this.grassType = grassType;
    }

    public int getQuality() {
        return this.grassType + this.grassLength;
    }

    public void upgradeGrassType(int type) {
        this.grassType = type;
    }
}
