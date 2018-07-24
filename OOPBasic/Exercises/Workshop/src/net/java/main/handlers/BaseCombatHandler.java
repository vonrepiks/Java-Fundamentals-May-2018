package net.java.main.handlers;

import net.java.main.factories.UnitComparatorFactory;
import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Unit;

import java.util.List;

public abstract class BaseCombatHandler implements CombatHandler{
    private final int CLOSEST_ENEMY = 0;

    private Unit unit;

    protected BaseCombatHandler() {
    }

    protected Unit getUnit() {
        return this.unit;
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {
        targetCandidates.sort(
                UnitComparatorFactory.createComparatorByHealthPoints()
                        .thenComparing(
                                UnitComparatorFactory.createComparatorByName()));
        return targetCandidates.get(CLOSEST_ENEMY);
    }
}
