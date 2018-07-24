package net.java.main.handlers;

import net.java.main.constants.ExceptionMessagesConstants;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.factories.SpellFactory;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;

public class CarrierCombatHandler extends BaseCombatHandler {
    private int spellCount;

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Unit unit = super.getUnit();
        Spell spell = SpellFactory.createSpell(SpellType.BULLET_RAIN, unit.getAttackPoints());

        this.spellCount++;

        if (this.spellCount % 3 == 0) {
            return spell;
        } else {
            if (unit.getEnergyPoints() <= spell.getEnergyCost()) {
                throw new NotEnoughEnergyException(ExceptionMessagesConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
            }
        }

        unit.setEnergyPoints(unit.getEnergyPoints() - spell.getEnergyCost());

        return spell;
    }
}
