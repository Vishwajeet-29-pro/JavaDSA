package org.practice.dsa.java8.functional_programming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problems3 {

    /*Given a list of integers, sort all the values present in it in descending order using Stream functions?*/
    public List<Integer> sortListInReverseOrder(List<Integer> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .toList();
    }

    /* Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    every element is distinct */
    public boolean validateArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed().toList();
        Set<Integer> integersSet = new HashSet<>(list);
        return integersSet.size() != list.size();
    }

    public List<String> concateTwoStringLists(List<String> s1, List<String> s2) {
       return Stream.concat(s1.stream(), s2.stream()).toList();
    }

    public List<Integer> findCubeAndReturnGreaterThanFifty(List<Integer> integerList) {
        return integerList.stream()
                .map(s-> s*s*s)
                .filter(s-> s>50)
                .toList();
    }

    public List<String> toUpperCaseObject(List<String> stringList) {
        return stringList.stream().map(String::toUpperCase).toList();
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity()
                                , Collectors.counting()
                        ));
        System.out.println(namesCount);
    }
}
