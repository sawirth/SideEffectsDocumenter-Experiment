package necmiexperiment.football;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
        } else if (Calendar.getInstance().getTime().getDay() <= 15){
            return 1;
        }

        return 2;
    }
}
