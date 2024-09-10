package org.practice.dsa.java8.exercise.flight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightManagementTest {

    private FlightManagement flightMs = new FlightManagement();
    private List<Flight> flights;
    Luggage l1;
    Luggage l2;
    Luggage l3;

    Passenger p1;
    Passenger p2;
    Passenger p3;

    Flight f1;
    Flight f2;
    Flight f3;


    @BeforeEach
    public void setup() {
        l1 = new Luggage("Suitcase",30.0);
        l2 = new Luggage("Backpack", 7.5);
        l3 = new Luggage("Briefcase",22);

        p1 = new Passenger("Vishwajeet", List.of(l1, l2));
        p2 = new Passenger("John",List.of(l2, l3));
        p3 = new Passenger("Tommy Shelby", List.of(l3));

        f1 = new Flight("New York", List.of(p1, p2));
        f2 = new Flight("New Delhi", List.of(p3));
        f3 = new Flight("New Mumbai",List.of(p1));

        flights = List.of(f1, f2, f3);
    }

    @Test
    public void testAllPassengersByDestination() {
        String destination = "New York";
        List<Passenger> expected = List.of(p1, p2);
        List<Passenger> actual = flightMs.findAllPassengersByDestination(flights, destination);
        assertEquals(expected, actual);
    }
}
