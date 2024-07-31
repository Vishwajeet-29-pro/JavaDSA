package org.practice.dsa.java8.functional_programming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionsTest {
    Questions questions = new Questions();
    @Test
    void testFactorial() {
        int expected = 120;
        int result = questions.calculateFactorial(5);

        assertEquals(expected, result);
    }

    @Test
    void testPalindrome() {
        String input = "madam";

        boolean result = questions.validatePalindrome(input);
        assertTrue(result);
        assertFalse(questions.validatePalindrome("today"));
    }

    @Test
    void testMergeLists() {
        List<String> list1 = List.of("apple","mongo","kiwi");
        List<String> list2 = List.of("banana","orange","pineapple");
        List<String> expected = List.of("apple","banana","kiwi","mongo","orange","pineapple");

        List<String> result = questions.mergeLists(list1, list2);
        assertEquals(expected, result,"Result should be merged lists");
    }
}
