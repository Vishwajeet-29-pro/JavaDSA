package org.practice.dsa.java8.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepository {
    // find employee by employee name
    public String findEmployeeByName(List<Employee> employees, String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(Employee::toString)
                .orElse("Employee Not found");
    }

    // find employee's phone number by email
    public String findPhoneNumberByEmail(List<Employee> employees, String email) {
        return employees.stream()
                .filter(employee -> employee.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .flatMap(Employee::getPhoneNumber)
                .orElse("PhoneNumber not found");
    }

    // Filter Employees by department
    public List<Employee> filterEmployeeByDepartment(List<Employee> employees, Optional<String> department) {
        return employees.stream()
                .filter(employee -> department
                        .map(d -> employee.getDepartment()
                                        .map(d::equals)
                                        .orElse(false)
                        ).orElse(true)
                ).collect(Collectors.toList());
    }
}
