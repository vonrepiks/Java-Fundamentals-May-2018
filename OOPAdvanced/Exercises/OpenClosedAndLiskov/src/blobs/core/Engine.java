package blobs.core;

import blobs.annotations.Inject;
import blobs.interfaces.*;
import blobs.interfaces.Runnable;
import blobs.models.Blob;
import blobs.observers.Subject;
import blobs.utility.MutateBoolean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_PATH = "blobs.core.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";

    private String[] data;
    private Reader reader;
    private Writer writer;
    private Repository<Blob> blobRepository;
    private Subject subject;
    private MutateBoolean mutateBoolean;

    public Engine(Reader reader, Writer writer, Repository<Blob> blobRepository, Subject subject, MutateBoolean mutateBoolean) {
        this.writer = writer;
        this.reader = reader;
        this.blobRepository = blobRepository;
        this.subject = subject;
        this.mutateBoolean = mutateBoolean;
    }

    @Override
    public void run() {
        while (true) {
            String userInput = this.reader.readLine();

            if (TERMINATE_COMMAND.equals(userInput)) {
                break;
            }

            String[] args = userInput.split("\\s+");

            this.interpredCommand(args, args[0]);

            this.subject.notifyAllObservers();
        }
    }

    private String parseCommandName(String commandName) {
        return Arrays.stream(commandName.split("-"))
                .map(word -> String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(""));
    }

    private void interpredCommand(String[] data, String commandName) {
        this.data = Arrays.stream(data)
                .skip(1)
                .toArray(String[]::new);
        try {
            String commandClassName =
                    this.parseCommandName(commandName);

            Class<?> commandClass =
                    Class.forName(
                            COMMAND_PATH +
                                    commandClassName +
                                    COMMAND_SUFFIX_NAME);

            Constructor<?> declaredConstructor =
                    commandClass.getDeclaredConstructor();
            Executable command =
                    (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            command.execute();

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }
    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command
                .getClass()
                .getDeclaredFields();
        Field[] engineFields = this
                .getClass()
                .getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    engineField.setAccessible(true);
                    if (commandField
                            .getType()
                            .getSimpleName().equals(engineField
                                    .getType()
                                    .getSimpleName()) &&
                            commandField
                                    .getType().equals(engineField
                                    .getType())) {
                        commandField.set(
                                command, engineField.get(this));
                    }
                }
            }
        }

    }
}
