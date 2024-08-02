package org.practice.dsa.java8.functional_programming;

import java.util.*;
import java.util.stream.Stream;

public class Problems3 {

    /*Given a list of integers, sort all the values present in it in descending order using Stream functions?*/
    public List<Integer> sortListInReverseOrder(List<Integer> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .toList();
    }

    public boolean validateArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed().toList();
        Set<Integer> integersSet = new HashSet<>(list);
        return integersSet.size() != list.size();
    }

    public List<String> concateTwoStringLists(List<String> s1, List<String> s2) {
       return Stream.concat(s1.stream(), s2.stream()).toList();
    }
}
