package necmiexperiment.football;

public class PrivateLife {
    private int nightLife;
    private int family;
    private int press;
    private Player player;

    public PrivateLife(Player player) {
        this.nightLife = 10;
        this.family = 10;
        this.press = 10;
        this.player = player;
    }

    public int getPrivateLifeEffect() {
        int effect = this.nightLife;
        return effect;
    }

    public void goPartying() {
        this.nightLife += 10;
        if (this.nightLife > 10) {
            player.getInjured("injured");
        } else {
        }
    }

    public void visitFamily() {
        this.family += 10;
    }

    public void talkToPress() {
        this.press += 10;
    }
}
