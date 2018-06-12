package company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEmployees = Integer.parseInt(reader.readLine());

        List<Employee> employees = new ArrayList<>();

        while (countOfEmployees-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }

            employees.add(employee);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1, e2) ->
                        Double.compare(
                e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();
                    result.append(String.format("Highest Average Salary: %s", d.getKey())).append(System.lineSeparator());
                    d.getValue().stream()
                            // .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(employee -> result.append(employee.toString()).append(System.lineSeparator()));

                    System.out.print(result.toString());
                });
    }
}
