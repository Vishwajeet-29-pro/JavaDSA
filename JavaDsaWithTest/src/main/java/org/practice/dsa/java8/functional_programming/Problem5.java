package org.practice.dsa.java8.functional_programming;

import java.util.List;

public class Problem5 {
    public List<String> firstLetterToUpperCase(List<String> list) {
        return list.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .toList();
    }
}
