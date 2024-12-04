package org.practice.dsa.java8.functional_programming.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
