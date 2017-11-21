package necmiexperiment.football;

import java.util.List;

public class Physiotherapist {

    public static Player findFittestPlayer(List<Player> playerList) {
        Player fittest = playerList.get(0);
        for (Player player : playerList) {
            if (player.getPlayerCondition().calculateFitness() > fittest.getPlayerCondition().calculateFitness()) {
                fittest = player;
            }
        }
        return fittest;
    }

    public static Player findLeastFittestPlayer(List<Player> playerList) {
        Player lessFittest = playerList.get(0);
        for (Player player : playerList) {
            if (player.getPlayerCondition().calculateFitness() < lessFittest.getPlayerCondition().calculateFitness()) {
                lessFittest = player;
            }
        }
        return lessFittest;
    }
}
