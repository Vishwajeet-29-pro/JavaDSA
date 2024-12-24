package org.practice.dsa.java8.functional_programming.map;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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

        System.out.println(reverseElements(list));

        System.out.println(integerToBinary(integerList));

        System.out.println(extractFirstLetter(list));

        System.out.println(calculateLength(list));

        List<String> nameList = List.of("Vishwajeet", "Anil", "John", "Robert");
        System.out.println(addPrefix(nameList));

        List<LocalDate> dates = List.of(LocalDate.of(2024, 12,2), LocalDate.of(2024,12,3));
        System.out.println(dateFormat(dates));

        List<Double> price = List.of(100.0, 200.0, 400.0);
        System.out.println(twiceThePrice(price));

        System.out.println(conversion(employeeList));

        List<List<Integer>> nestedLists = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        System.out.println(transformNestedLists(nestedLists));
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
//                .flatMap(a -> Arrays.stream(a))
                .flatMap(Arrays::stream)
                .toList();
    }

    // Reverse strings in a list
    public static List<String> reverseElements(List<String> list) {
        return list.stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .toList();
    }

//    Convert a List of Integers to Their Binary Representation
    public static List<String> integerToBinary(List<Integer> list) {
        return list.stream()
//                .map(s -> Integer.toBinaryString(s))
                .map(Integer::toBinaryString)
                .toList();
    }

//    Extract First Letters
    public static List<String> extractFirstLetter(List<String> list) {
        return list.stream()
                .map(a -> a.substring(0, 1))
                .toList();
    }

//    Calculate Length of Strings
    public static List<Integer> calculateLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }

//        Add Prefix to names
    public static List<String> addPrefix(List<String> list) {
        return list.stream()
                .map(s -> "Mr./Ms " +s)
                .toList();
    }

//    Transform LocalDates to specific pattern
    public static List<String> dateFormat(List<LocalDate> dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dates.stream()
//                .map(date -> formatter.format(date))
                .map(formatter::format)
                .toList();
    }

//    Double the price
    public static List<Double> twiceThePrice(List<Double> list) {
        return list.stream()
                .map(d -> d * 2)
                .toList();
    }

//    Convert Object List to Attribute List
    public static List<String> conversion(List<Employee> employees) {
        return employees.stream()
//                .map(e -> e.getEmployeeName())
                .map(Employee::getEmployeeName)
                .toList();
    }

//    Transform Nested Lists
    public static List<List<Integer>> transformNestedLists(List<List<Integer>> list) {
        return list.stream()
                .map(e -> e.stream().map(s -> s*2).toList())
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
