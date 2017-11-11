package necmiexperiment.football;

public class Equipment {
    private String name;
    private int quality;
    private Shoe shoe;
    private Clothing clothing;

    public Equipment(String name) {
        this.name = name;
        this.shoe = new Shoe();
        this.clothing = new Clothing();

        if (name.equals("Nike")) {
            this.quality = this.shoe.getQuality() + this.clothing.getQuality();
        }

        if (name.equals("Adidas")) {
            this.quality = this.shoe.getQuality() + this.clothing.getQuality();
        }
    }

    public void upgradeEquipment(int upgradeValue) {
        getShoe().setQuality(upgradeValue);
        getClothing().setQuality(upgradeValue);
    }

    public Shoe getShoe() {
        return shoe;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public int getQuality() {
        return quality;
    }
}
