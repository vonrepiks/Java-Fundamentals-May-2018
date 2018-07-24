package net.java.main.models.spells;

public class BulletRain extends BaseSpell {

    private static final int ENERGY_COST = 15;

    public BulletRain(int damage) {
        super(damage, ENERGY_COST);
    }
}
