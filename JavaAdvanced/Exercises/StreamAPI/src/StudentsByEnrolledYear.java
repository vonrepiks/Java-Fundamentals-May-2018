import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsByEnrolledYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> marksByFacultyNumber = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String facultyNumber = tokens[0];

            List<String> marks = Arrays.stream(tokens).skip(1).collect(Collectors.toList());

            marksByFacultyNumber.putIfAbsent(facultyNumber, marks);
        }

        marksByFacultyNumber.entrySet().stream()
                .filter(m -> m.getKey().endsWith("14") || m.getKey().endsWith("15"))
                .forEach(m ->
                        System.out.println(
                                String.format("%s", String.join(" ", m.getValue()))));
    }
}
