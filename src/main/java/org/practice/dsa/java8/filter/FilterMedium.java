package org.practice.dsa.java8.filter;

import java.util.Arrays;
import java.util.List;

public class FilterMedium {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", 280000, "IT"),
                new Employee("Jane", 350000, "Finance"),
                new Employee("Mark", 290000, "IT"),
                new Employee("Emily", 250000, "HR"),
                new Employee("Steve", 270000, "IT")
        );
        System.out.println(filterEmployeesBySalaryAndDepartment(employees));
    }

//    Filter by multiple condition
//    Filter employees whose salary less 280000 and department is IT
    public static List<Employee> filterEmployeesBySalaryAndDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .filter(a -> a.getSalary() < 300000 && a.getDepartment().equals("IT"))
                .toList();
    }
}
