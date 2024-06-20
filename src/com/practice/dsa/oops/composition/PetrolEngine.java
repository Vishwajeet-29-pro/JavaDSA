package com.practice.dsa.oops.composition;

public class PetrolEngine implements Engine{

    @Override
    public void start() {
        System.out.println("Petrol Engine Started...");
    }

    @Override
    public void stop() {
        System.out.println("Petrol Engine Stopped....");
    }

    @Override
    public String getType() {
        return "Petrol";
    }
}
