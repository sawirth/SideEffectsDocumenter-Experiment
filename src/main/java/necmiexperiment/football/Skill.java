package necmiexperiment.football;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private SkillStrength skillStrength;
    private double learningEffort;
    public List<TrainingSession> trainingSessions;

    public Skill(String name, int skillStrength) {
        this.name = name;
        this.skillStrength = new SkillStrength(skillStrength);
        this.learningEffort = calculateLearningEffort();
        this.trainingSessions = new ArrayList<>();
    }

    public double getLearningEffort() {
        return learningEffort;
    }

    public SkillStrength getSkillStrength() {
        return skillStrength;
    }

    public double calculateLearningEffort() {
        double learningEffort = skillStrength.getLearningEffort();
        return learningEffort;
    }

    public void updateSkill() {
        for (int i = 0; i < this.trainingSessions.size(); i++) {
            skillStrength.add(this.trainingSessions.get(i).trainingResult);
        }
    }
}
