package necmiexperiment.football;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class Manager {

    public int salary;

    public int motivation;

    private String name;

    private Trainer trainer;

    public Manager(String name, int salary, int motivation) {
        this.name = name;
        this.salary = salary;
        this.motivation = motivation;
        this.trainer = new Trainer("Trainer 1", 100, motivation);
    }

    private static void sideEffect(Club club) {
        club.team.playerList = null;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void takeNoteOf(String message, Club club) {
        try (BufferedWriter writer = Files.newBufferedWriter(club.notes())) {
            writer.write(message);
        } catch (IOException ex) {
            //do nothing
        }
    }

    public void sellPlayer(Team team) {
        for (Player player : team.playerList) {
            if (player.wantsToMove(this)) {
            }
        }
    }

    public void makeParty() {
        President.budget = 1000;
    }

    public ClubReport createClubReport(Club club) {
        Trainer trainer = club.team.manager.trainer;
        Player bestPlayer = trainer.findBestPlayer(club.team.playerList);
        Player worstPlayer = trainer.findWorstPlayer(club.team.playerList);
        int salarySum = Accountant.getSalarySum(club.team.playerList);
        sideEffect(club);
        int highestSalary = Accountant.getHighestSalary(club.team.playerList);
        int lowestSalary = Accountant.getLowestSalary(club.team.playerList);
        int numberOfInjuredPlayers = club.team.playerList.stream().filter(Player::isInjured).collect(Collectors.toList()).size();
        int pitchQuality = club.trainingGround.pitch.getQuality();
        return new ClubReport(salarySum,
                              lowestSalary,
                              highestSalary,
                              bestPlayer,
                              worstPlayer,
                              club.team.playerList.size(),
                              pitchQuality,
                              numberOfInjuredPlayers,
                              100);
    }
}
