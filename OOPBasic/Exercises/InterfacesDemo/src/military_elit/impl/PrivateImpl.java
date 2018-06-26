package military_elit.impl;

import military_elit.contracts.Private;

public class PrivateImpl extends BaseSoldier implements Private {

    private double salary;

    public PrivateImpl(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.salary);
    }
}
