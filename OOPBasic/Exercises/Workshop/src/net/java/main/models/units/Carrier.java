package net.java.main.models.units;

import net.java.main.constants.GameConstants;
import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Position;

public class Carrier extends BaseUnit {

    public Carrier(String name, Position position,
                   CombatHandler combatHandler) {
        super(name, GameConstants.CARRIER_RANGE, position,
                GameConstants.CARRIER_HEALTH_POINTS,
                GameConstants.CARRIER_ENERGY_POINTS,
                GameConstants.CARRIER_ATTACK_POINTS,
                GameConstants.CARRIER_DEFENCE_POINTS,
                combatHandler);
    }

}
