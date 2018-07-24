package net.java.main.models.spells;

public class RageShoot extends BaseSpell {

    private static final int ENERGY_COST = 10;

    public RageShoot(int damage) {
        super(damage, ENERGY_COST);
    }
}
