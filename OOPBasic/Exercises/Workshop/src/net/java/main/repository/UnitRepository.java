package net.java.main.repository;

import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UnitRepository implements Repository<Unit> {

    private Map<String, Unit> units;

    public UnitRepository(){
        this.units = new HashMap<>();
    }

    @Override
    public void save(Unit unit) {
        this.units.putIfAbsent(unit.getName(), unit);
    }

    @Override
    public Collection<Unit> findAll() {
        return this.units.values();
    }

    @Override
    public Unit findByName(String name) {
        return this.units.get(name);
    }
}
