package net.java.main.enums;

public enum UnitType {
    MARINE,
    CARRIER;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
