package necmiexperiment.football;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Janitor {
    private String name;

    public Janitor(String name) {
        this.name = name;
    }

    public void mowPitch(Pitch pitch) {
        Path path = Paths.get("resources/task1.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("pitch mowed by " + this.name);
        } catch (IOException ex) {
            //do nothing
        }
    }
}
