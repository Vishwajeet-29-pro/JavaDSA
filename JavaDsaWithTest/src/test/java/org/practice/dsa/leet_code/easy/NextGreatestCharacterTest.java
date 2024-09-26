package org.practice.dsa.leet_code.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextGreatestCharacterTest {

    private final QuestionNextGreatestCharacter greatestCharacter = new QuestionNextGreatestCharacter();

    @Test
    public void testNextGreatestCharacter() {
        char[] arr = {'c','f','g'};
        char target = 'a';

        assertEquals('c', greatestCharacter.nextGreatestLetter(arr, target));
        assertEquals('f', greatestCharacter.nextGreatestLetter(arr, 'c'));
    }

    @Test
    public void testEdgeCase() {
        char[] arr = {'x','x','y','y'};
        char target = 'z';

        assertEquals('x', greatestCharacter.nextGreatestLetter(arr, target));
    }
}
