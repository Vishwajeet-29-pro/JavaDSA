package org.practice.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
    public static void main(String[] args) {

        System.out.println(fibo(10));
        var list = fiboList(5);
        System.out.println(list);
    }

    // print the last or sum
    static int fibo(int input) {

        if (input < 2) {
            return input;
        }
        return fibo(input -1) + fibo(input -2);
    }

    static List<Integer> fiboList(int input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <input; i++) {
            result.add(fibo(i));
        }
        return result;
    }
}
