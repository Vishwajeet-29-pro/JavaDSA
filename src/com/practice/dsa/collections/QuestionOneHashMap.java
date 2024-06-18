package com.practice.dsa.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuestionOneHashMap {
    public static void main(String[] args) {
        HashMap<String, String> contactNumber = new HashMap<>();
        chooseOperations(contactNumber);
    }

    static void chooseOperations(Map<String, String> map){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter the operation want to perform on HashMap");
            System.out.println("Add, Remove, Display, Find");
            choice = scanner.next().toLowerCase();

            switch (choice){
                case "add" -> addElementsToMap(map);
                case "remove" -> {
                    System.out.println("Enter the Name of the contact to remove from Book: ");
                    var elementByName = scanner.next();
                    removeElementFromMap(map, elementByName);
                }
                case "display" -> displayContentOfHashMap(map);
                case "find" -> {
                    System.out.println("Enter the name of the contact to search");
                    var contactName = scanner.next();
                    searchContactFromMap(map, contactName);
                }
                case "q" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid Choice");
            }

        } while (!choice.equals("q"));
    }

    private static void searchContactFromMap(Map<String, String> map, String contactName) {
        var data = map.get(contactName);
        System.out.println(data);
    }

    private static void removeElementFromMap(Map<String, String> map, String elementByName) {
        map.remove(elementByName);
    }

    static void addElementsToMap(Map<String, String> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Contact number and the Name: ");
        map.put(scanner.next(), scanner.next());
    }

    static void displayContentOfHashMap(Map<String, String> map){
        map.forEach((key, value) ->{
            System.out.print(key +" : "+value+" ");
        });
    }
}
