package calculator;

import calculator.annotations.CalculationMode;
import calculator.strategies.AdditionStrategy;
import calculator.strategies.Strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final String STRATEGIES_PATH_REFERENCE = "calculator.strategies.";
    private static final String STRATEGIES_RELATIVE_PATH = "H:\\SoftUni\\Java\\Java-Fundamentals-May-2018\\OOPAdvanced\\Exercises\\CommunicationAndEvents\\src\\calculator\\strategies";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Strategy defaultStrategy = new AdditionStrategy();
        PrimitiveCalculator calculator = new PrimitiveCalculator(defaultStrategy);

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            if ("mode".equals(tokens[0])) {
                String mode = tokens[1];

                Strategy strategy = initStrategyByMode(mode);

                if (strategy != null) {
                    calculator.changeStrategy(strategy);
                }

            } else {
                int firstOperand = Integer.parseInt(tokens[0]);
                int secondOperand = Integer.parseInt(tokens[1]);

                System.out.println(calculator.performCalculation(firstOperand, secondOperand));
            }
        }
    }

    private static Strategy initStrategyByMode(String mode) {
        File strategyDirectory = new File(STRATEGIES_RELATIVE_PATH);

        if (strategyDirectory.isDirectory()) {
            File[] files = strategyDirectory.listFiles();

            for (File file : files) {
                try {
                    Class<?> fileClass = Class.forName(STRATEGIES_PATH_REFERENCE + file.getName().replace(".java", ""));
                    if (fileClass.isAnnotationPresent(CalculationMode.class)) {
                        String annotationValue = fileClass.getAnnotation(CalculationMode.class).value();

                        if (annotationValue.equals(mode)) {
                            Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor();
                            Strategy strategy = (Strategy) declaredConstructor.newInstance();

                            return strategy;
                        }
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
