import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Set<String>>> classes = new LinkedHashMap<>();

        String validParameter = "[A-Z][A-Za-z0-9]{2,}";
        String validDelimiter = "\\s\\|\\s";
        String pattern = String.format("^%1$s%2$s%1$s%2$s%1$s$", validParameter, validDelimiter);

        String line;
        while (true) {
            if ("It's testing time!".equals(line = reader.readLine())) {
                break;
            }

            if (!line.matches(pattern)) {
                continue;
            }

            String[] tokens = line.split("\\s\\|\\s");

            String clazz = tokens[0];
            String method = tokens[1];
            String unitTest = tokens[2];

            Set<String> unitTests = new LinkedHashSet<>();
            Map<String, Set<String>> methods = new LinkedHashMap<>();
            if (classes.containsKey(clazz)) {
                methods = classes.get(clazz);
                if (methods.containsKey(method)) {
                    unitTests = methods.get(method);
                }
            }

            unitTests.add(unitTest);
            methods.put(method, unitTests);
            classes.put(clazz, methods);
        }



        classes.entrySet().stream()
                .sorted(Comparator
                        .comparing((Map.Entry<String, Map<String, Set<String>>> entry) ->
                                entry.getValue().values().stream().mapToInt(Set::size).sum(), Comparator.reverseOrder())
                        .thenComparing((Map.Entry<String, Map<String, Set<String>>> entry) -> entry.getValue().size())
                        .thenComparing(Map.Entry::getKey))
                .forEach(clazz -> {
                    StringBuilder classResult = new StringBuilder(String.format("%s:", clazz.getKey())).append(System.lineSeparator());
                    clazz.getValue().entrySet().stream()
                            .sorted(Comparator
                                    .comparing((Map.Entry<String, Set<String>> entry) -> entry.getValue().size(), Comparator.reverseOrder())
                                    .thenComparing(Map.Entry::getKey))
                            .forEach(method -> {
                                classResult.append(String.format("##%s", method.getKey())).append(System.lineSeparator());

                                method.getValue().stream()
                                        .sorted(Comparator
                                                .comparing(String::length)
                                                .thenComparing((String s) -> s))
                                        .forEach(unitTest -> {
                                            classResult.append(String.format("####%s", unitTest)).append(System.lineSeparator());
                                        });

                            });
                    System.out.print(classResult);
                });
    }
}
