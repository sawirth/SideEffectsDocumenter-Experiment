package necmiexperiment.football;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Skill> skillList;
    private Skill powerSkill;
    private Skill speedSkill;
    private Skill mySkill;
    private int daysInClub;
    public int salary;
    public int motivation;
    public PlayerCondition playerCondition;

    public Player(String name, int speed, int power, int salary, int motivation) {
        this.name = name;
        this.skillList = new ArrayList<>();
        this.speedSkill = new Skill("speed", speed);
        this.powerSkill = new Skill("power", power);
        this.mySkill = new Skill("shoot", speed + power);
        this.daysInClub = 365;
        addSkill(speedSkill);
        addSkill(powerSkill);
        addSkill(mySkill);

        this.salary = salary;
        this.motivation = motivation;

        this.playerCondition = new PlayerCondition(this);
    }

    public PlayerCondition getPlayerCondition() {
        return playerCondition;
    }

    public int getMotivation() {
        return motivation;
    }

    public void updateSkill(Skill skill) {
        double currentSkillStrength = this.speedSkill.getSkillStrength().getValue();
        for (int i = 0; i < this.skillList.get(0).trainingSessions.size(); i++) {
            currentSkillStrength += this.skillList.get(0).trainingSessions.get(i).trainingResult;
        }
    }

    public void addSkill(Skill skill) {
        this.skillList.add(skill);
    }

    public Skill getSkill(String skillName) {
        if (skillName == "speed")  {
            return this.speedSkill;
        }

        if (skillName == "power") {
            return this.powerSkill;
        }

        if (skillName == "shoot") {
            return this.mySkill;
        }

        System.out.println("Skill " + skillName + " does not exist");
        return null;
    }

    public double getSkillEffort(String skillName) {
        if (skillName == "speed") {
            return this.skillList.get(0).getLearningEffort();
        }

        if (skillName == "power") {
            return this.skillList.get(1).getLearningEffort();
        }

        if (skillName == "shoot") {
            return this.skillList.get(2).getLearningEffort();
        }

        System.out.println("Skill " + skillName + " does not exist");
        return 0;
    }

    public SkillStrength getPlayerSkillStrength(String skillName) {
        if (skillName == "speed") {
            return this.skillList.get(0).getSkillStrength();
        }

        if (skillName == "power") {
            return this.skillList.get(1).getSkillStrength();
        }

        if (skillName == "shoot") {
            return this.skillList.get(2).getSkillStrength();
        }

        return null;
    }

    private boolean isBetterThan(Player otherPlayer) {
        if (this.getPlayerSkillStrength("speed").isStrongerThan(otherPlayer.getPlayerSkillStrength("speed"))) {
            return true;
        }

        return false;
    }

    public boolean takePenalty(Player goalKeeper) {
        if (this.isBetterThan(goalKeeper)) {
            return true;
        } else {
            return false;
        }
    }

    public void getInjured(String injury) {
        this.playerCondition.physicalCondition.addInjury(injury);
    }

    public boolean wantsToMove(Manager manager) {
        int physicalCondition = this.getPlayerCondition().getPlayerCondition();
        return manager.motivation +  physicalCondition - daysInClub < 10;
    }
}
