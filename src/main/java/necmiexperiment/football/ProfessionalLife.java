package necmiexperiment.football;

public class ProfessionalLife {
    private int relationsWithTeamMates;
    private int relationsWithManager;
    private int relationsWithPresident;
    private int relationsWithTrainer;

    public ProfessionalLife() {
        this.relationsWithManager = 10;
        this.relationsWithPresident = 10;
        this.relationsWithTeamMates = 10;
        this.relationsWithTrainer = 10;
    }

    public double getAverage() {
        double avg = (this.relationsWithManager + this.relationsWithPresident + this.relationsWithTrainer +
                this.relationsWithTeamMates) / 10;

        return avg;
    }
}
