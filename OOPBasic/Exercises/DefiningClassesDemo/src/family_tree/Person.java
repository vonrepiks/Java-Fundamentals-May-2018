package family_tree;

public class Person {
    private String name;
    private String birthDate;

    public Person() {
    }

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean hasNullFields() {
        return this.name == null || this.birthDate == null;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}
