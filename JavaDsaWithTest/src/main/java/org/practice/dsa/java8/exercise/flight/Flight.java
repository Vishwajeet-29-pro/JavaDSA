package org.practice.dsa.java8.exercise.flight;

import java.util.List;

public class Flight {
    private String destination;
    private List<Passenger> passengers;

    public Flight(String destination, List<Passenger> passengers) {
        this.destination = destination;
        this.passengers = passengers;
    }

    public String getDestination() {
        return destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
