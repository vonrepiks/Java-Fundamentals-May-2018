package app.models;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private List<Course> courses;

    public University() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public double getStudentsAverageAge() {
        return this.students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .getAsDouble();
    }
}
