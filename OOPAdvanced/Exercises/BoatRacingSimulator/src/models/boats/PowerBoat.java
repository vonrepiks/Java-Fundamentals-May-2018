package models.boats;

import contracts.BoatEngine;
import contracts.Race;

public class PowerBoat extends BaseBoat {

    private BoatEngine firstBoatEngine;

    private BoatEngine secondBoatEngine;

    public PowerBoat(String model, int weight, BoatEngine firstBoatEngine, BoatEngine secondBoatEngine) {
        super(model, weight);
        this.firstBoatEngine = firstBoatEngine;
        this.secondBoatEngine = secondBoatEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.firstBoatEngine.getCachedOutput() + this.secondBoatEngine.getCachedOutput()) - super.getWeight() + (race.getOceanCurrentSpeed() / 5d);
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }
}
