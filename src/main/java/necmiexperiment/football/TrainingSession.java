package necmiexperiment.football;

public class TrainingSession {

    public double trainingResult;
    private String trainingName;
    private TrainingGround trainingGround;
    private Trainer trainer;
    private Player player;

    public TrainingSession(String trainingName, TrainingGround trainingGround, Trainer trainer, Player player) {
        this.trainingName = trainingName;
        this.trainingGround = trainingGround;
        this.trainer = trainer;
        this.player = player;
        if (trainingName.equals("speed")) {
            this.trainingResult = doCoreTraining("speed");
            this.player.getSkill("speed").trainingSessions.add(this);
            this.player.getSkill("speed").updateSkill();
        }
        if (trainingName.equals("power")) {
            this.trainingResult = doCoreTraining("power");
            this.player.getSkill("power").trainingSessions.add(this);
            this.player.getSkill("power").updateSkill();
        }
    }

    private double doCoreTraining(String trainingName) {
        double skillEffort = this.player.getSkillEffort(trainingName);
        int playerMotivation = this.player.getMotivation();
        SkillStrength currentSkillStrength = this.player.getPlayerSkillStrength(trainingName);
        int trainerSkill = this.trainer.getTrainerSkill();
        int trainerMotivation = this.trainer.getMotivation();
        int trainingGroundQuality = this.trainingGround.getQuality();
        int playerCondition = this.player.getPlayerCondition().getPlayerCondition();
        double total = (playerMotivation * skillEffort) + trainerMotivation + trainerSkill + trainingGroundQuality + playerCondition;
        return total;
    }
}
