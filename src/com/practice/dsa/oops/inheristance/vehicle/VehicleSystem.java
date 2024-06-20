package com.practice.dsa.oops.inheristance.vehicle;

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota","Innova", 2022,5, false);
        Vehicle truck = new Truck("TATA","RoadRage",2020,50000, true);
        Vehicle motorCycle = new MotorCycle("Honda","CB Shine",2011, false);

        System.out.println("Information of the Car:");
        car.displayDetails();
        System.out.println();

        System.out.println("Information of the Truck:");
        truck.displayDetails();
        System.out.println();

        System.out.println("Information of the Motor Cycle");
        motorCycle.displayDetails();
        System.out.println();

    }


}
