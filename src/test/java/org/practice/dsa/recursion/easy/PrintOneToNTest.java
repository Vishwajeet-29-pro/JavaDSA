package org.practice.dsa.recursion.easy;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintOneToNTest {
    private PrintOneToN print = new PrintOneToN();

    @Disabled
    @Test
    void testPrint1ToN() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(printStream);

        print.print1ToN(5);

        System.setOut(originalOut);

        String capturedOutput = outputStream.toString().trim();

        String expectedOutput = "5\n4\n3\n2\n1";

        assertEquals(expectedOutput, capturedOutput, "The output should print numbers from 5 to 1");
    }

}