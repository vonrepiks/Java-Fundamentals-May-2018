package net.java.main.interfaces;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.InvalidUnitTypeException;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.exceptions.UnitNotExistException;

public interface Command {

    String execute(String[] args) throws InvalidUnitTypeException, InvalidPositionException, UnitNotExistException, NotEnoughEnergyException;
}
