package demo.main;

import demo.Person;
import demo.Student;

public class Main {
    public static void main(String[] args) {

        // Identifable student = new Student("Ivan");
        Person student1 = new Student("Pesho");

//        student.getId();
//        ((Person) student).getName();
//        student1.getId();
//        student1.getName();

        student1.printName();
    }
}
