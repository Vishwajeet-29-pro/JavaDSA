package org.practice.dsa.simple;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuestionOne {

    @Test
    public void testValidateIsEvenOrOdd() {
        assertTrue(QuestionOne.validateNumberIsOddOrEven(2),"2 should be even");
        assertFalse(QuestionOne.validateNumberIsOddOrEven(3),"3 should be odd");
        assertTrue(QuestionOne.validateNumberIsOddOrEven(4),"4 should be even");
        assertFalse(QuestionOne.validateNumberIsOddOrEven(5),"5 should be odd");
    }

    @Test
    public void testPrintResult() {
        // This is a simple test to verify printResult() method.
        // Since printResult() prints to the console, you would normally not test this directly.
        // Instead, you would test methods that use this method.
        // Here we mock the console output just for demonstration purposes.
        int number = 2;
        boolean result = true;
        String expectedOutput = "The number 2 is Even";

        // Redirect console output to a byte array output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // call the method
        QuestionOne.printResult(number,result);

        // check the output
        assertEquals(expectedOutput, outputStream.toString().trim());

    }
}
