package necmiexperiment.football;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grass {
    public int grassType;
    public int grassLength;
    public int grassQuality;

    public Grass(int grassType, int grassLength) {
        this.grassLength = grassLength;
        this.grassType = grassType;
    }

    public int getQuality() {
        return this.grassType + this.grassLength;
    }

    public void upgradeGrassType(int type) {
        try (Stream<String> stream = Files.lines(Paths.get("resources/task1.txt"))){
            List<String> elements = stream.collect(Collectors.toList());
            type = Integer.parseInt(elements.get(0));
        } catch(IOException ex) {
            //do nothing
        }
        this.grassType = type;
    }
}
