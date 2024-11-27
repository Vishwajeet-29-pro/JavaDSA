package org.practice.dsa.java8.functional_programming.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapInDeep {

    public static void main(String[] args) {
        List<String> list = List.of("apple","banana","cherry");
        System.out.println(upperCaseList(list));

        List<Employee> employeeList = List.of(new Employee("Vishwajeet", 24), new Employee("Aniket", 25), new Employee("Mitesh", 22));
        System.out.println(getEmployeeName(employeeList));

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        System.out.println(square(integerList));

        System.out.println(formattedList(integerList));

        List<String> stringList = List.of("Hello World", "Welcome to Java");
        System.out.println(convertList(stringList));
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

//    3. Computation or Transformation
    public static List<Integer> square(List<Integer> list) {
        return list.stream()
                .map(s -> s*s)
                .toList();
    }

//    4. Complex Transformation
    public static List<String> formattedList(List<Integer> list) {
        return list.stream()
                .map(s-> "Age: " + s)
                .toList();
    }

//    5. Flatting Data
//      Convert a list of sentences into individual words.
    public static List<String> convertList(List<String> list) {
        return list.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
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
