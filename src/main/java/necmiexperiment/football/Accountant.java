package necmiexperiment.football;

import java.util.List;

public class Accountant {

    public static int getLowestSalary(List<Player> playerList) {
        return playerList.stream().mapToInt(p -> p.salary).max().getAsInt();
    }

    public static int getHighestSalary(List<Player> playerList) {
        return playerList.stream().mapToInt(p -> p.salary).min().getAsInt();
    }

    public static int getSalarySum(List<Player> playerList) {
        return playerList.stream().mapToInt(p -> p.salary).sum();
    }
}
