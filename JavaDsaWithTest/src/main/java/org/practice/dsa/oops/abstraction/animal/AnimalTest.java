package org.practice.dsa.oops.abstraction.animal;

public class AnimalTest {
    public static void main(String[] args) {
        Animal tiger = new Tiger();
        tiger.sound();

        Animal lion = new Lion();
        lion.sound();

        System.out.println("Another way...");
        Animal animal = new Lion();
        animal.sound();

        animal = new Tiger();
        animal.sound();
    }
}
