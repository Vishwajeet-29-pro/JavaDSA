package org.practice.dsa.recursion.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipStringTest {

    private final SkipString sk = new SkipString();

    @Test
    public void testSkipApple() {
        String s = "andappled";
        String expected = "andd";
        String actual = sk.skipApple(s);

        assertEquals(expected, actual);
    }

    @Test
    public void testSkipAppNotApple() {
        String s= "addappnotapple";
        String expected = "addnotapple";
        String actual = sk.skipAppNotApple(s);

        assertEquals(expected, actual);
    }
}