package org.practice.dsa.java8.functional_programming;

import java.util.*;
import java.util.stream.Collectors;

public class Problems2 {

    /*Given a list of integers, find out all the numbers starting with 1 using Stream functions?*/
    public List<Integer> integersStartWithOne(List<Integer> numbers) {
      return numbers.stream()
              .filter(s-> String.valueOf(s).startsWith("1"))
              .collect(Collectors.toList());
    }


    /*How to find duplicate elements in a given integers list in java using Stream functions?*/
    public List<Integer> findDuplicatesFromList(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        return list.stream()
                .filter(s-> !set.add(s))
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream().toList();
    }

    /*Given the list of integers, find the first element of the list using Stream functions*/
    public int findFirstElementOfList(List<Integer> integers) {
        return integers.stream().findFirst().orElse(0);
    }

    /*Given a list of integers, find the total number of elements present in the list using Stream functions*/
    public long findTotalNumber(List<Integer> integers) {
        // return integers.stream().count();
        return integers.size();
    }

    /*Given a list of integers, find the maximum value element present in it using Stream functions?*/
    public int findMaxFromList(List<Integer> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("Empty list");
        return list.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
    }


    /*Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions.*/
    public List<Integer> removeDuplicates(List<Integer> list) {
        return new LinkedHashSet<>(list)
                .stream()
                .toList();
    }

    /*Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.*/
    public Map<Integer, Long> frequencyOfElements(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s-> s, Collectors.counting()));
    }
}
