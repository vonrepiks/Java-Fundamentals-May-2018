package military_elit.impl;

import military_elit.contracts.Soldier;

public abstract class BaseSoldier implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    protected BaseSoldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s", this.firstName, this.lastName, this.id);
    }
}
