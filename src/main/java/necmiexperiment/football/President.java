package necmiexperiment.football;

public class President {
    private String name;

    public President(String name) {
        this.name = name;
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
}
