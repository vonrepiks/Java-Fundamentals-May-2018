import some_package.Person;
import some_package.some_inner_package.Student;

public class Main {
    public static void main(String[] args) {

        Person student = new Student("Miro");

        System.out.println(student);
    }
}
