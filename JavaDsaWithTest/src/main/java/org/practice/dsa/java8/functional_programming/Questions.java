package org.practice.dsa.java8.functional_programming;

import java.util.function.Function;
import java.util.function.Predicate;

public class Questions {
    Function<Integer, Integer> fact = n-> {
        if (n == 0 || n == 1) return 1;
        return n * this.fact.apply(n-1);
    };

    Predicate<String> isPalindrome = s -> {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    };

    public int calculateFactorial(int number){
        return fact.apply(number);
    }

    public boolean validatePalindrome(String s) {
        return isPalindrome.test(s);
    }
}
