package com.practice.dsa.oops.composition;

public class Car {
    private String make;
    private String model;
    private Engine engine;

    public Car(String make, String model, Engine engine){
        this.make = make;
        this.model = model;
        this.engine = engine;
    }

    public void startEngine(){
        System.out.println("Starting car: "+make+" : "+model);
        engine.start();
    }

    public void stopEngine(){
        System.out.println("Stopping car: "+make+" : "+model);
        engine.stop();
    }

    public void displayDetails(){
        System.out.println("Car Make: "+make);
        System.out.println("Car Model: "+model);
        System.out.println("Car Engine: "+engine.getType());
    }
}
