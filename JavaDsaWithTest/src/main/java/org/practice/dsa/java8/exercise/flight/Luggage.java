package org.practice.dsa.java8.exercise.flight;

public class Luggage {
    private String description;
    private double weight;

    public Luggage(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }
}
