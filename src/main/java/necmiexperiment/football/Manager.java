package necmiexperiment.football;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Manager {
    private String name;
    private Trainer trainer;
    public int salary;
    public int motivation;

    public Manager(String name, int salary, int motivation) {
        this.name = name;
        this.salary = salary;
        this.motivation = motivation;
        this.trainer = new Trainer("Trainer 1", 100, motivation);
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
}
