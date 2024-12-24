package org.practice.dsa.oops.inheristance.vehicle;

public class MotorCycle extends Vehicle {
    boolean hasSideCar;

    public MotorCycle(String make, String model, int year, boolean hasSideCar) {
        super(make, model, year);
        this.hasSideCar = hasSideCar;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Has Side Car:"+(hasSideCar ? "YES" : "NO"));
    }
}
