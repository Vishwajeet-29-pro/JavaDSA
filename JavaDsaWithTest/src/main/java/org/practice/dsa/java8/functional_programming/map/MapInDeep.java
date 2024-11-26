package org.practice.dsa.java8.functional_programming.map;

import java.util.ArrayList;
import java.util.List;

public class MapInDeep {

    public static void main(String[] args) {
        List<String> list = List.of("apple","banana","cherry");
        System.out.println(upperCaseList(list));

        List<Employee> employeeList = List.of(new Employee("Vishwajeet", 24), new Employee("Aniket", 25), new Employee("Mitesh", 22));
        System.out.println(getEmployeeName(employeeList));

    }
//    1. Transforming Elements
    public static List<String> upperCaseList(List<String> list) {
        return list.stream()
//                .map(s -> s.toUpperCase()) // transform the list into upper case list
                .map(String::toUpperCase)
                .toList();
    }

//    2. Extracting Fields
    public static List<String> getEmployeeName(List<Employee> employees) {
        return employees.stream()
//                .map(s -> s.getEmployeeName())
                .map(Employee::getEmployeeName)
                .toList();
    }

    private static class Employee {
        private String employeeName;
        private int age;

        public Employee(String employeeName, int age) {
            this.age = age;
            this.employeeName = employeeName;
        }

        public String getEmployeeName() {
            return this.employeeName;
        }
    }
}
