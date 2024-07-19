package org.practice.dsa.java8.lamdba_expressions;

import java.util.List;
import java.util.Optional;

public class QuestionCalculateMaximumFromList {
    public static Optional<Integer> maximumElement(List<Integer> list) {
        return list.stream().max(Integer::compareTo);
    }
}
