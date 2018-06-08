import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GUnit2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Set<String>>> classes = new LinkedHashMap<>();

        String validNameElementRegex = "[A-Z][A-Za-z0-9]+";
        String validDelimiterRegex = "\\s\\|\\s";

        String validLineRegex = String.format("%1$s%2$s%1$s%2$s%1$s", validNameElementRegex, validDelimiterRegex);

        String line;
        while (true) {
            if ("It's testing time!".equals(line = reader.readLine())) {
                break;
            }

            if (!line.matches(validLineRegex)) {
                continue;
            }

            String[] tokens = line.split(validDelimiterRegex);

            String clazz = tokens[0];
            String method = tokens[1];
            String unitTest = tokens[2];

            Set<String> unitTests = new LinkedHashSet<>();
            Map<String, Set<String>> methods = new LinkedHashMap<>();

            if (classes.containsKey(clazz)) {
                methods = classes.get(clazz);
            }

            if (methods.containsKey(method)) {
                unitTests = methods.get(method);
            }

            unitTests.add(unitTest);
            methods.put(method, unitTests);
            classes.put(clazz, methods);
        }

        StringBuilder result = new StringBuilder();

        classes.entrySet().stream()
                .sorted((clazz1, clazz2) -> {
                    int amountUnitTestClazz1 = clazz1.getValue().values().stream()
                            .mapToInt(m -> m.size()).sum();
                    int amountUnitTestClazz2 = clazz2.getValue().values().stream()
                            .mapToInt(m -> m.size()).sum();

                    int comparatorByAmountOfUnitTest = amountUnitTestClazz2 - amountUnitTestClazz1;

                    if (comparatorByAmountOfUnitTest != 0) {
                        return comparatorByAmountOfUnitTest;
                    }

                    int amountMethodsClazz1 = clazz1.getValue().size();
                    int amountMethodsClazz2 = clazz2.getValue().size();

                    int comparatorByAmountOfMethods = amountMethodsClazz1 - amountMethodsClazz2;

                    if (comparatorByAmountOfMethods != 0) {
                        return comparatorByAmountOfMethods;
                    }

                    int comparatorByNames = clazz1.getKey().compareTo(clazz2.getKey());

                    return comparatorByNames;
                }).forEach(clazz -> {
                    result.append(String.format("%s:", clazz.getKey())).append(System.lineSeparator());
                    clazz.getValue().entrySet().stream()
                            .sorted((method1, method2) -> {
                                int amountOfUnitTestsMethod1 = method1.getValue().size();
                                int amountOfUnitTestsMethod2 = method2.getValue().size();

                                int comparatorByAmountTests = amountOfUnitTestsMethod2 - amountOfUnitTestsMethod1;

                                if (comparatorByAmountTests != 0) {
                                    return comparatorByAmountTests;
                                }

                                int comparatorByNames = method1.getKey().compareTo(method2.getKey());

                                return comparatorByNames;

                            }).forEach(method -> {
                                result.append(String.format("##%s", method.getKey())).append(System.lineSeparator());
                                method.getValue().stream()
                                        .sorted((unitTest1, unitTest2) -> {
                                            int comparatorByNamesLength = unitTest1.length() - unitTest2.length();
                                            if (comparatorByNamesLength != 0) {
                                                return comparatorByNamesLength;
                                            }

                                            int comparatorByNames = unitTest1.compareTo(unitTest2);

                                            return comparatorByNames;
                                        })
                                        .forEach(uniTest -> {
                                            result.append(String.format("####%s", uniTest)).append(System.lineSeparator());
                                        });
                    });
        });

        System.out.print(result);
    }
}
