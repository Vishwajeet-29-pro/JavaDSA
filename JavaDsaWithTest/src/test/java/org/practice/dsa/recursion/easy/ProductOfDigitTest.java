package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductOfDigitTest {
    private final ProductOfDigits product = new ProductOfDigits();

    @Test
    public void testProductOfDigits() {
        int expected = 6;
        int actual = product.productNumbers(32);

        assertEquals(expected, actual);
    }
}
