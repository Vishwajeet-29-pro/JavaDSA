package org.practice.dsa.java8.exercise.flight;

import java.util.List;

public class FlightManagement {

    // Task 1: Find all passengers flying to a specific destination
    public List<Passenger> findAllPassengersByDestination(List<Flight> flights, String destination) {
        return flights.stream()
                .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
                .flatMap(flight -> flight.getPassengers().stream())
                .toList();
    }

    public double findWeightOfLuggageForPassenger(List<Flight> flights, String name) {
        return flights.stream()
                .flatMap(flight -> flight.getPassengers().stream())
                .filter(passenger -> passenger.getName().equalsIgnoreCase(name))
                .flatMap(passenger -> passenger.getLuggage().stream())
                .mapToDouble(Luggage::getWeight)
                .sum();
    }
}
