package net.java.main.interfaces;

public interface Unit {

    String getName();

    int getRange();

    Position getPosition();

    int getHealthPoints();

    void setHealthPoints(int points);

    int getEnergyPoints();

    void setEnergyPoints(int points);

    int getAttackPoints();

    int getDefencePoints();

    CombatHandler getCombatHandler();
}
