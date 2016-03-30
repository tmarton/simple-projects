package net.marton.trainingjournal.entities.enums;

/**
 * Created by tmarton on 8/26/15.
 */
public enum UnitType {
    KG("Kilograms"), S("Seconds"), M("Meters");

    private String label;

    private UnitType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
