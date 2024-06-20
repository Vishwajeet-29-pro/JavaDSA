package com.practice.dsa.oops.inheristance.vehicle;

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println("Make: "+make+" Model: "+model+" Year: "+year);
    }
}
