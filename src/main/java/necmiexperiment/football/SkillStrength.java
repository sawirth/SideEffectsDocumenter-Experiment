package necmiexperiment.football;

public class SkillStrength {
    private double value;

    public SkillStrength(double value) {
        this.value = value;
    }

    public boolean isStrongerThan(SkillStrength otherSkillStrength) {
        return this.value > otherSkillStrength.getValue();
    }

    public double getValue() {
        return this.value;
    }

    public double getLearningEffort() {
        return 1 - (this.value / 100.0);
    }

    public void add(double value) {
        this.value += value;
    }
}
