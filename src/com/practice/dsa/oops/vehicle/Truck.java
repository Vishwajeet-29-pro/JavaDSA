package com.practice.dsa.oops.vehicle;

public class Truck extends Vehicle{
    int loadCapacityInKG;
    boolean hasTrailer;

    public Truck(String make, String model, int year, int loadCapacityInKG, boolean hasTrailer) {
        super(make, model, year);
        this.loadCapacityInKG = loadCapacityInKG;
        this.hasTrailer = hasTrailer;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Load Capacity in KG: "+loadCapacityInKG);
        System.out.println("Has Trailer: "+hasTrailer);
    }
}
