package org.practice.dsa.java8.functional_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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
}
