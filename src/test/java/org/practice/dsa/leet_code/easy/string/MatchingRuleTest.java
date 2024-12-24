package org.practice.dsa.leet_code.easy.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchingRuleTest {

    private final QuestionMatchingRule matchingRule = new QuestionMatchingRule();

    @Test
    public void testMatchingRule() {
        List<List<String>> item = List.of(List.of("phone","blue","pixel"), List.of("computer","silver","lenovo"), List.of("phone", "gold", "iphone"));
        String ruleKey = "color";
        String ruleValue = "silver";
        int expected = 1;
        assertEquals(expected, matchingRule.countMatches(item, ruleKey, ruleValue));
    }
}
