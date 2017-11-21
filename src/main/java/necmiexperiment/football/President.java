package necmiexperiment.football;

import java.util.List;
public class President {
    private String name;
    public static int budget;

    public President(String name) {
        this.name = name;
        budget = 20000000;
    }

    public void raisePlayerSalary(int playerIndex, Club club, int amount) {
        club.team.playerList.get(playerIndex).salary += amount;
        if (club.team.playerList.get(playerIndex).motivation != 10) {
            club.team.playerList.get(playerIndex).motivation += 1;
        }
    }

    public void decreasePlayerSalary(int playerIndex, Club club, int amount) {
        club.team.playerList.get(playerIndex).salary -= amount;
        if (club.team.playerList.get(playerIndex).motivation != 10) {
            club.team.playerList.get(playerIndex).motivation -= 1;
        }
    }

    public void raiseManagerSalary(Club club, int amount) {
        club.team.manager.salary += amount;
        if (club.team.manager.motivation != 10) {
            club.team.manager.motivation += 1;
        }
    }

    public void upgradeTrainingGround(Club club, int upgradeType) {
        if (upgradeType == 1) {
            club.getTrainingGround().upgrade(upgradeType, club.notes());
        } else {
            club.getTrainingGround().upgrade(upgradeType, club.notes());
        }
    }

    public void controlSalaries(List<Player> playerList) {
        int sum = 0;
        for (Player player : playerList) {
            sum += player.salary;
        }

        if (sum > budget) {
            throw new SalaryEscalationException();
        }
    }
}
