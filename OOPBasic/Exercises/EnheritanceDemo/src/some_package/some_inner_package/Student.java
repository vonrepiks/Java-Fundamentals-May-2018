package some_package.some_inner_package;

import some_package.Person;

public class Student extends Person {
    private String name;
    private float age;

    public Student(String name) {
        super(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
