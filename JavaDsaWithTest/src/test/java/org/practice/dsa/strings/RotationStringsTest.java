package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RotationStringsTest {

    private final QuestionIsRotationStrings rotationStrings = new QuestionIsRotationStrings();

    @Test
    void testIsRotation() {
        String stringOne = "waterbottle";
        String stringTwo = "erbottlewat";

        boolean result = rotationStrings.isRotation(stringOne, stringTwo);

        assertTrue(result);
    }

    @Test
    void testIsRotationWithNotEqualLength() {
        String s1 = "water";
        String s2 = "wate";

        boolean result = rotationStrings.isRotation(s1, s2);

        assertFalse(result);
    }
}
