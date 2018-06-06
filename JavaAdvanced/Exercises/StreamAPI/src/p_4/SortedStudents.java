package p_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortedStudents {
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

            Student student = new Student(firstName, lastName);

            students.add(student);
        }

//        students.stream()
//                .sorted((s1, s2) -> {
//                    int comparatorByLastName = s1.getLastName().compareTo(s2.getLastName());
//
//                    if (comparatorByLastName != 0) {
//                        return comparatorByLastName;
//                    }
//
//                    int comparatorByFirstName = s2.getFirstName().compareTo(s1.getFirstName());
//
//                    return comparatorByFirstName;
//                })
//                .forEach(System.out::println);
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}

