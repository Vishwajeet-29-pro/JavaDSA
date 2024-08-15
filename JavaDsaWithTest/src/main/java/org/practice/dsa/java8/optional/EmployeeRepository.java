package org.practice.dsa.java8.optional;

import java.util.List;

public class EmployeeRepository {
    // find employee by employee name
    public String findEmployeeByName(List<Employee> employees, String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(Employee::toString)
                .orElse("Employee Not found");
    }
}
