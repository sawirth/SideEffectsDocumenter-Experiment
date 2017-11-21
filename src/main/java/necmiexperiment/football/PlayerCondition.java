package necmiexperiment.football;

public class PlayerCondition {

    public PhysicalCondition physicalCondition;

    private PrivateLife privateLife;

    private ProfessionalLife professionalLife;

    private Player player;

    public PlayerCondition(Player player) {
        this.privateLife = new PrivateLife(player);
        this.professionalLife = new ProfessionalLife();
        this.physicalCondition = new PhysicalCondition();
    }

    public PrivateLife getPrivateLife() {
        return privateLife;
    }

    public int getPlayerCondition() {
        int temp = this.privateLife.getPrivateLifeEffect() + this.physicalCondition.getPhysicalCondition();
        return temp;
    }

    public double calculateFitness() {
        return privateLife.getPrivateLifeEffect() + professionalLife.getAverage();
    }
}
