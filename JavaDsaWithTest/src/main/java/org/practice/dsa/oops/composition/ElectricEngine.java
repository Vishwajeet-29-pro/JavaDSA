package org.practice.dsa.oops.composition;

public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric Engine Started...");
    }

    @Override
    public void stop() {
        System.out.println("Electric Engine Stopped...");
    }

    @Override
    public String getType() {
        return "Electric";
    }
}
