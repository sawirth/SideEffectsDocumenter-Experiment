package necmiexperiment.football;

public class Trainer {
    private String name;
    private int trainerSkill;
    private int motivation;

    public Trainer(String name, int trainerSkill, int motivation) {
        this.name = name;
        this.trainerSkill = trainerSkill;
        this.motivation = motivation;
    }

    public int getMotivation() {
        return this.motivation;
    }

    public int getTrainerSkill() {
        return trainerSkill;
    }

    public void trainPlayer(String skillName, Team team, int playerIndex, TrainingGround trainingGround) {
        Player player = team.getPlayerList().get(playerIndex);
        if (skillName.equals("speed")) {
            TrainingSession traingSession = new TrainingSession("speed", trainingGround, this, player);
        }

        if (skillName.equals("power")) {
            TrainingSession traingSession = new TrainingSession("power", trainingGround, this, player);
        }

        if (skillName.equals("shoot")) {
            TrainingSession traingSession = new TrainingSession("shoot", trainingGround, this, player);
        }
    }
}
