package org.practice.dsa.java8.functional_programming.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reverse {
    // Given the list of strings, reverse the characters of String element of list not the order
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Welcome", "to", "Java");
        System.out.println(reverseString(list));
    }

    public static List<String> reverseString(List<String> list) {
        return list.stream()
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.toList());
    }
}
