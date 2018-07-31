package database;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Repository;

public class BoatSimulatorDatabase {

    private Repository<Boat> boats;

    private Repository<BoatEngine> engines;

    public BoatSimulatorDatabase(Repository<Boat> boats, Repository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<BoatEngine> getEngines() {
        return this.engines;
    }
}
