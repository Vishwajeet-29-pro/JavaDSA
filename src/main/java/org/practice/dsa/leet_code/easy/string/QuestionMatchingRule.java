package org.practice.dsa.leet_code.easy.string;

import java.util.List;
import java.util.Objects;

public class QuestionMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int counter = 0;
        int index;
        if (Objects.equals(ruleKey, "type")) index = 0;
        else if (Objects.equals(ruleKey, "color")) index = 1;
        else index = 2;
        for (var lst: items) {
            if (lst.get(index).equals(ruleValue)){
                counter++;
            }
        }
        return counter;
    }
}
