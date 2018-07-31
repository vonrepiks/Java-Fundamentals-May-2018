package core;

import contracts.CommandHandler;
import contracts.Runnable;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private BufferedReader reader;

    private CommandHandler commandHandler;

    public Engine(BufferedReader reader, CommandHandler commandHandler) {
        this.reader = reader;
        this.commandHandler = commandHandler;
    }

    public void run() {
        String name;
        List<String> parameters;
        while (true) {
            try {
                String line = this.reader.readLine();

                if ("End".equals(line)) {
                    break;
                }


                List<String> tokens = Arrays.asList(line.split("\\\\"));
                name = tokens.get(0);
                parameters = tokens.stream().skip(1).collect(Collectors.toList());

                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
