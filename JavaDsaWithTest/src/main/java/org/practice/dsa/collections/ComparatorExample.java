package org.practice.dsa.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<ComparableDemo> demo = new ArrayList<>();
        demo.add(new ComparableDemo(3, "V"));
        demo.add(new ComparableDemo(1, "B"));
        demo.add(new ComparableDemo(2, "X"));

//        Collections.sort(demo, new Comparator<ComparableDemo>() {
//            @Override
//            public int compare(ComparableDemo o1, ComparableDemo o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        // short form
        Collections.sort(demo, Comparator.comparing(ComparableDemo::getName));

        System.out.println("Sort by names:");
        demo.forEach(System.out::println);
    }
}
