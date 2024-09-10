package org.practice.dsa.java8.exercise.flight;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class FlightManagementTest {

    private FlightManagement flightMs = new FlightManagement();
    private List<Flight> flights;

    @BeforeEach
    public void setup() {
        Luggage l1 = new Luggage("Suitcase",30.0);
        Luggage l2 = new Luggage("Backpack", 7.5);
        Luggage l3 = new Luggage("Briefcase",22);

        Passenger p1 = new Passenger("Vishwajeet", List.of(l1, l2));
        Passenger p2 = new Passenger("John",List.of(l2, l3));
        Passenger p3 = new Passenger("Tommy Shelby", List.of(l3));

        Flight f1 = new Flight("New York", List.of(p1, p2));
        Flight f2 = new Flight("New Delhi", List.of(p3));
        Flight f3 = new Flight("New Mumbai",List.of(p1));

        flights = List.of(f1, f2, f3);
    }



}
