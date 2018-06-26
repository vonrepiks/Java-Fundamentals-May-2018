package demo;

public abstract class BasePerson implements Person {
    private String id;
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return "id";
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }
}
