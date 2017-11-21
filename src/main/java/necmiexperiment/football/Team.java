package necmiexperiment.football;

import java.util.List;

public class Team {

    public List<Player> playerList;
    public Manager manager;
    private String name;

    public Team(String name, List<Player> players, Manager manager) {
        this.name = name;
        this.playerList = players;
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
