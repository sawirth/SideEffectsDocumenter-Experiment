package necmiexperiment.football;

public class Janitor {

    public String name;

    private Lawnmower lawnmower;

    public Janitor(String name, Lawnmower lawnmower) {
        this.name = name;
        this.lawnmower = lawnmower;
    }

    public void mowPitch(Club club) {
        this.lawnmower.refuel();
        String mowResult = this.lawnmower.mow(this, club.trainingGround.pitch);
        notifyManager(club.team.manager, mowResult, club);
    }

    private void notifyManager(Manager manager, String message, Club club) {
        manager.takeNoteOf(message, club);
    }
}
