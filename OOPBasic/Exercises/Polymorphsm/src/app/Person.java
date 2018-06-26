package app;

public class Person {
    private String name;
    private String birthDate;
    private int age;

    protected Person() {
    }

    public Person(int age, String name, String birthDate) {
        this.name = name;
    }

    public Person(String birthDate, int age, String name) {
        this.name = name;
        this.age = age;
    }

    protected int getAge() {
        return this.age;
    }
}
