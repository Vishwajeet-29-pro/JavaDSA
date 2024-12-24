package org.practice.dsa.oops.composition;

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

    /*
    Benefits of Composition over Inheritance:
        Flexibility: You can change the engine of the car at runtime by simply assigning a different Engine object.
        Reusability: You can reuse the Engine classes in other contexts without modifying the Car class.
        Decoupling: The Car class is decoupled from the specific implementations of the engines, following the dependency inversion principle.
    */
}
