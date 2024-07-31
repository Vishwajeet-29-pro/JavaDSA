package org.practice.dsa.java8.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problems2 {

    /*Given a list of integers, find out all the numbers starting with 1 using Stream functions?*/


    public List<Integer> integersStartWithOne(List<Integer> numbers) {
      return numbers.stream()
              .filter(s-> String.valueOf(s).startsWith("1"))
              .collect(Collectors.toList());
    }
}
