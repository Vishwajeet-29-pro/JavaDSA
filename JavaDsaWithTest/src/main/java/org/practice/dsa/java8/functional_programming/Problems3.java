package org.practice.dsa.java8.functional_programming;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problems3 {

    /*Given a list of integers, sort all the values present in it in descending order using Stream functions?*/
    public List<Integer> sortListInReverseOrder(List<Integer> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .toList();
    }
}
