package necmiexperiment.football;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Club {

    public static int salaryMultiplicator = 1;
    public Team team;

    public TrainingGround trainingGround;
    private String name;
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
            this.trainingGround = new TrainingGround("Zidane", 90, this.equipment);
        }
        this.janitor = new Janitor(janitor, new Lawnmower());
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

    public Path notes() {
        return Paths.get("resources/task1.txt");
    }

    public void playGameAgainst(Club club) {
        int wins = 0;
        for (Player player : this.team.playerList) {
            int counter = 0;
            for (Player playerOtherTeam : club.team.playerList) {
                boolean weWon;
                if (counter % 2 == 0 && (player.takePenalty(playerOtherTeam)) || !playerOtherTeam.takePenalty(player)) {
                    wins++;
                } else {
                    wins--;
                }
                counter++;
            }
        }
        if (wins > 0) {
            this.team.manager.makeParty();
        } else {
            club.team.manager.makeParty();
        }
    }
}
