package org.practice.dsa.java8.functional_programming.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterInDeep {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5,6);
        System.out.println(evenNumbers(integerList));

        List<String> stringList = List.of("Java", "JavaScript", "Kotlin", "Python");
        System.out.println(specificLetterList(stringList, "J"));

        List<String> stringsWithNull = new ArrayList<>();
        stringsWithNull.add("Java");
        stringsWithNull.add("JavaScript");
        stringsWithNull.add(null);
        stringsWithNull.add("Kotlin");
        stringsWithNull.add(null);
        System.out.println(filterNullValues(stringsWithNull));

        List<Student> students = List.of(new Student("V", 25), new Student("R", 15), new Student("T",19));
        filterStudents(students).forEach(s -> System.out.print(s.getName()+" "));
        System.out.println();

        System.out.println(filterLength(stringList));

        Map<String, Integer> scores = Map.of(
                "Vishwajeet", 90,
                "Raman", 50,
                "Random", 45,
                "Soren", 55
        );

        System.out.println(filterMap(scores));
    }

    public static List<Integer> evenNumbers(List<Integer> list) {
        return list.stream()
                .filter(f -> f % 2 == 0)
                .toList();
    }

    // Filter List of string and return list starts with specific letter
    public static List<String> specificLetterList(List<String> list, String ch) {
        return list.stream()
                .filter(s -> s.startsWith(ch))
                .toList();
    }

    // Filter out null values from the list
    public static List<String> filterNullValues(List<String> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .toList();
    }

    // Filter out student whose age greater than 18.
    public static List<Student> filterStudents(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge() > 18)
                .toList();
    }

    // Filter strings from list whose length is greater than 4
    public static List<String> filterLength(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 4)
                .toList();
    }

    // Filter Based on a Condition in a Map
    // Extract all map entries where the value is greater than 50.
    public static Map<String, Integer> filterMap(Map<String, Integer> scores) {
        return scores.entrySet().stream()
                .filter(s -> s.getValue() > 50)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
