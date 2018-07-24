package net.java.main.commands;

import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FightCommand implements Command {
    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public FightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws NotEnoughEnergyException {
        List<Unit> killedUnit = new ArrayList<>();

        Collection<Unit> allUnits = this.unitRepository.findAll();

        if (allUnits.size() < 2) {
            return "No enough spawns for fight!";
        }

        StringBuilder result = new StringBuilder();
        for (Unit unit : allUnits) {
            if (unit.getHealthPoints() <= 0) {
                continue;
            }
            Position currentUnitPosition = unit.getPosition();
            int range = unit.getRange();

            List<Unit> targets = this.battleground.getUnitsInRange(currentUnitPosition.getX(), currentUnitPosition.getY(), range);
            if (targets.isEmpty()) {
                continue;
            }

            Unit target = unit.getCombatHandler().pickNextTarget(targets);

            Spell spell = unit.getCombatHandler().generateAttack();

            if (spell.getDamage() > target.getDefencePoints()) {
                target.setHealthPoints(target.getHealthPoints() - spell.getDamage());

                result
                        .append(
                                String.format("%s cast %s spell and did %d damage",
                                        unit.getName(),
                                        spell.getClass().getSimpleName(),
                                        spell.getDamage()))
                        .append(System.lineSeparator());

                if (target.getHealthPoints() <= 0) {
                    target.setHealthPoints(0);

                    result
                            .append(String.format("%s killed %s", unit.getName(), target.getName()))
                            .append(System.lineSeparator());

                    killedUnit.add(unit);
                }
            }
        }

        String resultString = result.toString().trim();

        if (resultString.isEmpty()) {
            return "Units are outside range of their enemies, move closer and try again!";
        }

        for (Unit unit : killedUnit) {
            this.battleground.remove(unit);
        }

        return resultString;
    }
}
