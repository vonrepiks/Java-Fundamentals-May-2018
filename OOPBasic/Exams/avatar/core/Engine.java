package avatar.core;

import avatar.io.ConsoleInputReader;
import avatar.io.ConsoleOutputWriter;
import avatar.utilities.InputParser;

import java.util.ArrayList;

import static avatar.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private GameManager gameManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, GameManager gameManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.gameManager = gameManager;
    }

    public void run() {
        String inputLine;

        while(true) {
            inputLine = this.inputReader.readLine();
            ArrayList<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(ArrayList<String> commandParams) {
        String command = commandParams.remove(0);

        switch(command) {
            case "Bender":
                String benderType = commandParams.get(0);
                String benderName = commandParams.get(1);
                long power = Long.parseLong(commandParams.get(2));
                double secondParameter = Double.parseDouble(commandParams.get(3));

                this.gameManager.createBender(benderType, benderName, power, secondParameter);
                break;
            case "Monument":
                String monumentType = commandParams.get(0);
                String monumentName = commandParams.get(1);
                long affinity = Long.parseLong(commandParams.get(2));

                this.gameManager.createMonument(monumentType, monumentName, affinity);
                break;
            case "Status":
                this.outputWriter.writeLine(this.gameManager.status(commandParams.get(0)));
                break;
            case "War":
                this.gameManager.war(commandParams.get(0));
                break;
            case "Quit":
                this.outputWriter.writeLine(this.gameManager.quit());
        }
    }
}
