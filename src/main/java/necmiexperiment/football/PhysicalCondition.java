package necmiexperiment.football;

import java.util.ArrayList;
import java.util.List;

public class PhysicalCondition {
    private List<String> injuryList;
    private List<String> recoveredInjuries;

    public PhysicalCondition() {
        this.injuryList = new ArrayList<>();
        this.recoveredInjuries = new ArrayList<>();
    }

    public void addInjury(String name) {
        this.injuryList.add(name);
    }

    public int getPhysicalCondition() {
        if (injuryList.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}