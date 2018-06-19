package some_package;

public class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.setName(name);
        this.age = 12;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
