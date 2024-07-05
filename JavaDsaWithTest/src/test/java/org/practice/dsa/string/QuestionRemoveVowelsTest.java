package org.practice.dsa.string;

import org.junit.jupiter.api.Test;
import org.practice.dsa.strings.QuestionRemoveOvals;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionRemoveVowelsTest {


    @Test
    public void testRemoveVowels(){
        String actual = QuestionRemoveOvals.removeVowels("leetcodeisacommunityforcoders");
        String expected = "ltcdscmmntyfrcdrs";

        assertEquals(expected, actual);
    }
}
