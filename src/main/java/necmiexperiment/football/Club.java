package necmiexperiment.football;

public class Club {
    private String name;
    public Team team;
    public TrainingGround trainingGround;
    private President president;
    private Equipment equipment;
    private Janitor janitor;

    public Club(String name, President president, String equipmentName, String janitor) {
        if (name.equals("Barcelona")) {
            this.name = name;
            this.team = team = new TeamConstructor().createTeamBarcelona();
            this.equipment = new Equipment(equipmentName);
            this.president = president;
            this.trainingGround = new TrainingGround("Ciutat Esportiva Joan Gamper", 90, this.equipment);
        }

        if (name.equals("Real Madrid")) {
            this.name = name;
            this.team = team = new TeamConstructor().createTeamRealMadrid();
            this.equipment = new Equipment(equipmentName);
            this.president = president;
            this.trainingGround = new TrainingGround("Zidaner", 90, this.equipment);
        }

        this.janitor = new Janitor(janitor);
    }

    public Team getTeam() {
        return team;
    }

    public President getPresident() {
        return president;
    }

    public TrainingGround getTrainingGround() {
        return trainingGround;
    }

    public Janitor getJanitor() {
        return janitor;
    }
}
