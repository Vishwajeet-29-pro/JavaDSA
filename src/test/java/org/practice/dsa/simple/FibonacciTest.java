package org.practice.dsa.simple;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    private final Fibonacci f = new Fibonacci();

    @Test
    public void testFibonacci() {
        int input = 5;
        List<Integer> expected = List.of(0, 1, 1, 2, 3);
        List<Integer> actual = f.fibonacci(input);
        assertEquals(expected, actual);
    }
}
