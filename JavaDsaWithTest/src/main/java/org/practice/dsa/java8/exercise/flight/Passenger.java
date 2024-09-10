package org.practice.dsa.java8.exercise.flight;

import java.util.List;

public class Passenger {
    private String name;
    private List<Luggage> luggage;

    public Passenger(String name, List<Luggage> luggage) {
        this.name = name;
        this.luggage = luggage;
    }

    public String getName() {
        return name;
    }

    public List<Luggage> getLuggage() {
        return luggage;
    }
}
