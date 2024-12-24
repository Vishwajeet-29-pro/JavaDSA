package org.practice.dsa.asked_in_interview.interview;

import java.util.Map;
import java.util.stream.Collectors;

/**
* Problem: Find Duplicate Characters in a String
* Given a string, find all the duplicate characters and their counts using the Java 8 Stream API.
* The result should be a Map<Character, Integer>.
* */
public class DuplicateFromString {
    public static void main(String[] args) {
        System.out.println(duplicate("programming"));
    }

    public static Map<Character, Long> duplicate(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c, Collectors.counting()
                )).entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
        ));
    }
}
