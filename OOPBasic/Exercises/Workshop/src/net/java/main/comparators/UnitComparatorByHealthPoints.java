package net.java.main.comparators;

import net.java.main.interfaces.Unit;

import java.util.Comparator;

public class UnitComparatorByHealthPoints implements Comparator<Unit> {
    @Override
    public int compare(Unit unit1, Unit unit2) {
        return unit1.getHealthPoints() - unit2.getHealthPoints();
    }
}
