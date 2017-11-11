package necmiexperiment.football;

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
}
