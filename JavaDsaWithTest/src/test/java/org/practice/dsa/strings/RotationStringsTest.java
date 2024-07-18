package org.practice.dsa.strings;

import org.junit.jupiter.api.Test;

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
}
