package net.java.main.factories;

import net.java.main.handlers.CarrierCombatHandler;
import net.java.main.handlers.MarineCombatHandler;
import net.java.main.interfaces.CombatHandler;

final class CombatHandlerFactory {

    private CombatHandlerFactory() {
    }

    static CombatHandler createCarrierCombatHandler() {
        return new CarrierCombatHandler();
    }

    static CombatHandler createMarineCombatHandler() {
        return new MarineCombatHandler();
    }
}
