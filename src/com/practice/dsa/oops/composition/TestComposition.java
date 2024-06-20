package com.practice.dsa.oops.composition;

public class TestComposition {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        Engine electricEngine = new ElectricEngine();

        Car petrolCar = new Car("TATA","Safari", petrolEngine);
        Car electricCar = new Car("Tesla","S",electricEngine);

        petrolCar.displayDetails();
        petrolCar.startEngine();
        petrolCar.stopEngine();

        System.out.println();

        electricCar.displayDetails();
        electricCar.startEngine();
        electricCar.stopEngine();

        System.out.println();
    }
}
