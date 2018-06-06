import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> marks = Arrays.stream(tokens).skip(2).map(Integer::parseInt).collect(Collectors.toList());

            students.putIfAbsent(firstName + " " + lastName, marks);
        }

        students.entrySet().stream()
                .filter(s -> s.getValue().stream()
                        .filter(m -> m <= 3).count() >= 2)
                .forEach(s -> System.out.println(s.getKey()));
    }
}
