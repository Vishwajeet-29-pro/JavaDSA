package org.practice.dsa.java8.functional_programming;

import java.util.List;

public class QuestionSumOfEvenNumbers {
    public int sumOfEvenNumbers(List<Integer> numberList) {
        return numberList.stream().filter(s-> s%2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
