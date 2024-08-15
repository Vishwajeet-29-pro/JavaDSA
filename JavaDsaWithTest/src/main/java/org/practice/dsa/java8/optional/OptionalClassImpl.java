package org.practice.dsa.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassImpl {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = Arrays.asList(
                new Employee("Vishwajeet","vishwajeet@example.com", Optional.of("8308708911"), Optional.of("Backend")),
                new Employee("Balraj","balraj@example.com", Optional.of("8308708912"), Optional.of("Frontend")),
                new Employee("Samay","samay@example.com", Optional.of("8308708913"), Optional.empty()),
                new Employee("Amit","amit@example.com", Optional.empty(), Optional.of("HR")),
                new Employee("MaheepSingh","maheepsingh@examle.com", Optional.of("9876543210"),Optional.of("Backend"))
        );

        System.out.println(employeeRepository.findEmployeeByName(employees, "Amit"));
        System.out.println(employeeRepository.findEmployeeByName(employees,"Vishwajeet"));

        System.out.println(employeeRepository.findPhoneNumberByEmail(employees,"vishwajeet@example.com"));
        System.out.println(employeeRepository.findPhoneNumberByEmail(employees,"amit@example.com"));
        System.out.println(employeeRepository.findPhoneNumberByEmail(employees, "balraj@example.com"));

        System.out.println(employeeRepository.filterEmployeeByDepartment(employees, Optional.of("Backend")));
        System.out.println(employeeRepository.filterEmployeeByDepartment(employees, Optional.empty()));
    }
}
