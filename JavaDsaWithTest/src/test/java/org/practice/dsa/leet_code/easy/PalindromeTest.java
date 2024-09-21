package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    private final QuestionPalindrome palindrome = new QuestionPalindrome();

    @Test
    public void testNumberIsPalindrome() {
        boolean result = palindrome.isPalindrome(121);
        assertTrue(result);
    }

    @Test
    public void testIsPalindromeForNegativeNumber() {
        assertFalse(palindrome.isPalindrome(-121));
    }

    @Test
    public void testPalindromeIfNumberIsZero() {
        assertTrue(palindrome.isPalindrome(0));
    }

    @Test
    public void testPalindromeNumber() {
        assertFalse(palindrome.isPalindrome(10));
        assertFalse(palindrome.isPalindrome(550));
    }

    @Test
    public void testPalindromeFor123(){
        assertFalse(palindrome.isPalindrome(123));
    }
}
