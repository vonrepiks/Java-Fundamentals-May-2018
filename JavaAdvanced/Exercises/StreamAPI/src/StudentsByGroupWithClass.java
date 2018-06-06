import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByGroupWithClass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");


            String firstName = tokens[0];
            String lastName = tokens[1];
            String group = tokens[2];

            Student student = new Student(firstName, lastName, group);

            students.add(student);
        }

        students.stream()
                .filter(s -> s.getGroup().equals("2"))
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .forEach(System.out::println);
    }
}

class Student {
    String firstName;
    String lastName;
    String group;

    public Student(String firstName, String lastName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}