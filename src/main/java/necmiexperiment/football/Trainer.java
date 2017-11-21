package necmiexperiment.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private String name;

    private int trainerSkill;

    private int motivation;

    public Trainer(String name, int trainerSkill, int motivation) {
        this.name = name;
        this.trainerSkill = trainerSkill;
        this.motivation = motivation;
    }

    public int getMotivation() {
        return this.motivation;
    }

    public int getTrainerSkill() {
        return trainerSkill;
    }

    public void trainPlayer(String skillName, Team team, int playerIndex, TrainingGround trainingGround) {
        Player player = team.getPlayerList().get(playerIndex);
        if (skillName.equals("speed")) {
            TrainingSession traingSession = new TrainingSession("speed", trainingGround, this, player);
        }
        if (skillName.equals("power")) {
            TrainingSession traingSession = new TrainingSession("power", trainingGround, this, player);
        }
        if (skillName.equals("shoot")) {
            TrainingSession traingSession = new TrainingSession("shoot", trainingGround, this, player);
        }
    }

    public Player findBestPlayer(List<Player> playerList) {
        List<Player> bestPlayers = new ArrayList<>();
        bestPlayers.add(Physiotherapist.findFittestPlayer(playerList));
        bestPlayers.add(MentalCoach.findMostMotivatedPlayer(playerList));
        Collections.shuffle(bestPlayers);
        return bestPlayers.get(0);
    }

    public Player findWorstPlayer(List<Player> playerList) {
        List<Player> worstPlayers = new ArrayList<>();
        worstPlayers.add(Physiotherapist.findLeastFittestPlayer(playerList));
        worstPlayers.add(MentalCoach.findLeastMotivatedPlayer(playerList));
        Collections.shuffle(worstPlayers);
        return worstPlayers.get(0);
    }
}
