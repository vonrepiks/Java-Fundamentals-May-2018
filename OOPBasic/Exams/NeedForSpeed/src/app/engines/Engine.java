package app.engines;

import app.core.CarManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private static final String TERMINATE_COMMAND = "Cops Are Here";

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);

            if (inputLine.equals(TERMINATE_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.get(0);

        int carId;
        int raceId;
        String type;

        switch(command) {
            case "register":
                carId = Integer.parseInt(commandParams.get(1));
                type = commandParams.get(2);
                String brand = commandParams.get(3);
                String model = commandParams.get(4);
                int year = Integer.parseInt(commandParams.get(5));
                int horsepower = Integer.parseInt(commandParams.get(6));
                int acceleration = Integer.parseInt(commandParams.get(7));
                int suspension = Integer.parseInt(commandParams.get(8));
                int durability = Integer.parseInt(commandParams.get(9));

                this.carManager.register(carId, type, brand, model, year, horsepower, acceleration, suspension, durability);
                break;
            case "check":
                carId = Integer.parseInt(commandParams.get(1));
                this.outputWriter.writeLine(this.carManager.check(carId));
                break;
            case "open":
                carId = Integer.parseInt(commandParams.get(1));
                type = commandParams.get(2);
                int length = Integer.parseInt(commandParams.get(3));
                String route = commandParams.get(4);
                int prizePool = Integer.parseInt(commandParams.get(5));
                this.carManager.open(carId, type, length, route, prizePool);
                break;
            case "participate":
                carId = Integer.parseInt(commandParams.get(1));
                raceId = Integer.parseInt(commandParams.get(2));
                this.carManager.participate(carId, raceId);
                break;
            case "park":
                carId = Integer.parseInt(commandParams.get(1));
                this.carManager.park(carId);
                break;
            case "unpark":
                carId = Integer.parseInt(commandParams.get(1));
                this.carManager.unpark(carId);
                break;
            case "start":
                raceId = Integer.parseInt(commandParams.get(1));
                this.outputWriter.writeLine(this.carManager.start(raceId));
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commandParams.get(1));
                String addOn = commandParams.get(2);
                this.carManager.tune(tuneIndex, addOn);
                break;
        }
    }
}
