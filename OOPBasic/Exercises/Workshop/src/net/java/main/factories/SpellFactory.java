package net.java.main.factories;

import net.java.main.enums.SpellType;
import net.java.main.interfaces.Spell;
import net.java.main.models.spells.BulletRain;
import net.java.main.models.spells.RageShoot;

public final class SpellFactory {

    private SpellFactory() {
    }

    public static Spell createSpell(SpellType type, int damage) {
        switch (type) {
            case RAGE_SHOOT:
                return new RageShoot(damage);
            case BULLET_RAIN:
                return new BulletRain(damage);
            default:
                return null;
        }
    }
}
