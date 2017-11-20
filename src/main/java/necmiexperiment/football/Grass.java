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

    public void upgradeGrassType(int type, Path notes) {
        try (Stream<String> stream = Files.lines(notes)) {
            List<String> elements = stream.collect(Collectors.toList());
            int oldType = Integer.parseInt(elements.get(0));
            if (oldType != type) {
                this.grassType = type;
            }
        } catch (IOException ex) {
            //do nothing
        }
    }
}
