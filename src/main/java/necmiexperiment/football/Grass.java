package necmiexperiment.football;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

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
        try {
            FileReader fileReader = new FileReader(notes.toString());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int oldType = Integer.parseInt(bufferedReader.readLine());
            if (oldType != type) {
                this.grassType = type;
            }
        } catch (IOException ex) {
        //do nothing
        }
    }
}
