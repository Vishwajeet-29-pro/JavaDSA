package org.practice.dsa.simple;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public List<Integer> fibonacci(int input) {
        List<Integer> result = new ArrayList<>();
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 1; i <= input; i++) {
            result.add(a);
            a = b;
            b = c;
            c = a + b;
        }
        return result;
    }
}
