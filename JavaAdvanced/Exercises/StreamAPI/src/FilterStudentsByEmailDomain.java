import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            String email = tokens[2];

            Pair<String, String> student = new Pair<>(firstName + " " + lastName, email);

            students.add(student);
        }

        students.stream()
                .filter(s -> s.getValue().endsWith("@gmail.com"))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
