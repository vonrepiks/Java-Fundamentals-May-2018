package net.java.main.models.spells;

import net.java.main.interfaces.Spell;

public abstract class BaseSpell implements Spell {

    private int damage;
    private int energyCost;

    protected BaseSpell(int damage, int energyCost) {
        this.damage = damage;
        this.energyCost = energyCost;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getEnergyCost() {
        return this.energyCost;
    }
}
