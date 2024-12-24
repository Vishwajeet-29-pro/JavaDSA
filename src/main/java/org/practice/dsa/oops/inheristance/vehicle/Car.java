package org.practice.dsa.oops.inheristance.vehicle;

public class Car extends Vehicle {
    int numberOfDoors;
    boolean isConvertible;

    public Car(String make, String model, int year, int numberOfDoors, boolean isConvertible) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
        this.isConvertible = isConvertible;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: "+numberOfDoors);
        System.out.println("Is Convertible: "+(isConvertible ? "YES" : "NO"));
    }
}
