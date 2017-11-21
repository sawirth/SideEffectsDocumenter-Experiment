package necmiexperiment.football;

import java.nio.file.Path;

public class TrainingGround {

    public Pitch pitch;

    private String name;

    private Equipment equipment;

    private int pitchQuality;

    private int equipmentQuality;

    public TrainingGround(String name, int pitchQuality, Equipment equipment) {
        this.name = name;
        this.equipment = equipment;
        this.pitch = new Pitch();
    }

    public void upgrade(int upgradeType, Path notes) {
        switch (upgradeType) {
            case 1:
                getEquipment().upgradeEquipment(10);
                getPitch().upgradePitch(PitchType.type1(), notes);
                break;
            case 2:
                getEquipment().upgradeEquipment(10);
                getPitch().upgradePitch(PitchType.type2(), notes);
                break;
        }
    }

    public int getQuality() {
        int ret = pitch.getQuality() + equipment.getQuality();
        return pitch.getQuality() + equipment.getQuality();
    }

    public Pitch getPitch() {
        return pitch;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
