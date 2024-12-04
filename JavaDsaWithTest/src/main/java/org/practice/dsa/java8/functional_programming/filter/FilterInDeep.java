package org.practice.dsa.java8.functional_programming.filter;

import java.util.List;

public class FilterInDeep {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5,6);
        System.out.println(evenNumbers(integerList));

        List<String> stringList = List.of("Java", "JavaScript", "Kotlin", "Python");
        System.out.println(specificLetterList(stringList, "J"));
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
}
