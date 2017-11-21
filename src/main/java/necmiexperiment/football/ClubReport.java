package necmiexperiment.football;

public class ClubReport {

    public final int totalSalaries;

    public final int lowestSalary;

    public final int highestSalary;

    public final Player bestPlayer;

    public final Player worstPlayer;

    public final int numberOfPlayers;

    public final int pitchQuality;

    public final int numberOfInjuredPlayers;

    public final int generalMood;

    public ClubReport(int totalSalaries,
                      int lowestSalary,
                      int highestSalary,
                      Player bestPlayer,
                      Player worstPlayer,
                      int numberOfPlayers,
                      int pitchQuality,
                      int numberOfInjuredPlayers,
                      int generalMood) {
        this.totalSalaries = totalSalaries;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
        this.bestPlayer = bestPlayer;
        this.worstPlayer = worstPlayer;
        this.numberOfPlayers = numberOfPlayers;
        this.pitchQuality = pitchQuality;
        this.numberOfInjuredPlayers = numberOfInjuredPlayers;
        this.generalMood = generalMood;
    }
}
