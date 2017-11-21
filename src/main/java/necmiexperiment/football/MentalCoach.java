package necmiexperiment.football;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MentalCoach {

    public static Player findMostMotivatedPlayer(List<Player> playerList) {
        return Collections.max(playerList, Comparator.comparing(Player::getMotivation));
    }

    public static Player findLeastMotivatedPlayer(List<Player> playerList) {
        return Collections.min(playerList, Comparator.comparing(Player::getMotivation));
    }
}
