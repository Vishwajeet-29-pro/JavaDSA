package org.practice.dsa.java8.functional_programming;

import java.util.function.Function;

public class Questions {
    Function<Integer, Integer> fact = n-> {
        if (n == 0 || n == 1) return 1;
        return n * this.fact.apply(n-1);
    };

    public int calculateFactorial(int number){
        return fact.apply(number);
    }
}
