package necmiexperiment.football;

public class Lawnmower {
    private int fuel;

    public void refuel() {
        this.fuel = 100;
    }

    public String mow(Janitor janitor, Pitch pitch) {
        if (this.fuel < 50) {
            pitch.grass.grassLength -= 20;
        } else {
            pitch.grass.grassLength -= 10;
        }

        this.fuel = 0;
        return String.format("Pitch mowed by %s", janitor.name);
    }
}
