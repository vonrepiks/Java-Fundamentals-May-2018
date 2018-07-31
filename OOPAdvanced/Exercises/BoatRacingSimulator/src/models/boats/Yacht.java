package models.boats;

import contracts.BoatEngine;
import contracts.Race;
import utility.Validator;

public class Yacht extends BaseBoat {

    private int cargoWeight;

    private BoatEngine boatEngine;

    public Yacht(String model, int weight, int cargoWeight, BoatEngine boatEngine) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.boatEngine = boatEngine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.boatEngine.getCachedOutput() - super.getWeight() - this.cargoWeight + (race.getOceanCurrentSpeed() / 2d);
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }
}
