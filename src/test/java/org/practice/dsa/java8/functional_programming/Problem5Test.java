package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem5Test {
    private final Problem5 p = new Problem5();

    @Test
    public void testFirstLetterToUpperCase() {
        List<String> list = List.of("apple","banana","cherry","date");
        List<String> expectedList = List.of("Apple","Banana","Cherry","Date");
        List<String> actualList = p.firstLetterToUpperCase(list);
        assertEquals(expectedList, actualList);
    }
}
