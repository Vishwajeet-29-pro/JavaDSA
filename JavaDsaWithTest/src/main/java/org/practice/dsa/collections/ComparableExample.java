package org.practice.dsa.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<ComparableDemo> demo = new ArrayList<>();
        demo.add(new ComparableDemo(3, "V"));
        demo.add(new ComparableDemo(1, "B"));
        demo.add(new ComparableDemo(2, "X"));

        Collections.sort(demo);
        demo.forEach(System.out::println);
    }
}
