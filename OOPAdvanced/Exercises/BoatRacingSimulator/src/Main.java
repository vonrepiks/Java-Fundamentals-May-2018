import contracts.*;
import contracts.Runnable;
import controllers.BoatSimulatorControllerImpl;
import core.CommandHandlerImpl;
import core.Engine;
import database.BoatEngineRepository;
import database.BoatRepository;
import database.BoatSimulatorDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Repository<BoatEngine> boatEngineRepository = new BoatEngineRepository();
        Repository<Boat> boatRepository = new BoatRepository();
        BoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository, boatEngineRepository);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);
        Runnable engine = new Engine(reader, commandHandler);

        engine.run();
    }
}
