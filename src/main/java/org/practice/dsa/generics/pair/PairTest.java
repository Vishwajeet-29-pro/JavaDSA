package org.practice.dsa.generics.pair;

public class PairTest {
    public static void main(String[] args) {

        // Pair for name and age, i.e. of type String and Integer
        Pair<String, Integer> agePair = new Pair<>("Vishwajeet",24);
        System.out.println("Name and Age: "+agePair);
        System.out.println("Name is: "+agePair.getKey());
        System.out.println("Age is: "+agePair.getValue()+"\n");

        // Pair for Double and Boolean
        Pair<Double, Boolean> coordinates = new Pair<>(323.2, true);
        System.out.println("The coordinates are: "+coordinates);
        System.out.println("Get the coordinates: "+coordinates.getKey());
        System.out.println("Get Validity: "+coordinates.getValue()+"\n");

        // Pair for String and String
        Pair<String, String> countryPair = new Pair<>("India", "New Delhi");
        System.out.println("The country and capital: "+countryPair);
        System.out.println("The capital is: "+countryPair.getValue());

        // set new value to pair
        System.out.println();
        agePair.setValue(25);
        System.out.println("Age in year 2025 is: "+agePair.getValue());
    }
}
