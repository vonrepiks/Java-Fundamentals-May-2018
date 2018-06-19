package mankind;

public class Worker extends Human {
    private static final String INVALID_WORKER_LAST_NAME_EXCEPTION_MESSAGE = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    private static final String INVALID_WORKING_HOURS_EXCEPTION_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";

    private static final int WORKING_DAYS_PER_WEEK = 7;

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() <= 3) {
            throw new IllegalArgumentException(INVALID_WORKER_LAST_NAME_EXCEPTION_MESSAGE);
        }
        super.setLastName(lastName);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException(INVALID_WEEK_SALARY_EXCEPTION_MESSAGE);
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(INVALID_WORKING_HOURS_EXCEPTION_MESSAGE);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        double salaryPerHour = this.weekSalary / (this.workHoursPerDay * WORKING_DAYS_PER_WEEK);
        return salaryPerHour;
    }

    @Override
    public String toString() {
        StringBuilder worker = new StringBuilder();

        worker.append(super.toString()).append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.weekSalary)).append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.workHoursPerDay)).append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));

        return worker.toString();
    }
}
