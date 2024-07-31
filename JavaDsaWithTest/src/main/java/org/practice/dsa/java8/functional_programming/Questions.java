package org.practice.dsa.java8.functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {
    Function<Integer, Integer> fact = n -> {
        if (n == 0 || n == 1) return 1;
        return n * this.fact.apply(n - 1);
    };

    Predicate<String> isPalindrome = s -> {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    };

    BiFunction<List<String>, List<String>, List<String>> mergeLists = (list1, list2) -> {
        return Stream.concat(list1.stream(), list2.stream()).sorted().toList();
    };

    static Function<List<String>, Map<Integer, List<String>>> groupByLength = list -> {
       return list.stream().collect(Collectors.groupingBy(String::length));
    };

    public Map<Integer, List<String>> groupListByLength(List<String> words) {
        return groupByLength.apply(words);
    }

    public int calculateFactorial(int number) {
        return fact.apply(number);
    }

    public boolean validatePalindrome(String s) {
        return isPalindrome.test(s);
    }

    public List<String> mergeLists(List<String> list1, List<String> list2) {
        return mergeLists.apply(list1, list2);
    }
}
