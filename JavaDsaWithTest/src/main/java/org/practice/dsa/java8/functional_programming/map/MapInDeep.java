package org.practice.dsa.java8.functional_programming.map;

import java.util.ArrayList;
import java.util.List;

public class MapInDeep {

    public static void main(String[] args) {
        List<String> list = List.of("apple","banana","cherry");
        System.out.println(upperCaseList(list));
    }
//    1. Transforming Elements
    public static List<String> upperCaseList(List<String> list) {
        return list.stream()
//                .map(s -> s.toUpperCase()) // transform the list into upper case list
                .map(String::toUpperCase)
                .toList();
    }
}
