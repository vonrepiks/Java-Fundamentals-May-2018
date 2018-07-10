package tests;

public class User implements Comparable<User> {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User other) {
        return this.name.compareTo(other.name);
    }
}
