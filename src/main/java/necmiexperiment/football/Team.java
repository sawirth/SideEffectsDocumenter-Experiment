package necmiexperiment.football;

import java.util.List;

public class Team {
    private String name;
    public List<Player> playerList;
    public Manager manager;

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
