package org.practice.dsa.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class QuestionThreeSet {
    public static void main(String[] args) {
        var set = new HashSet<String>();
        chooseOperation(set);
    }

    static void chooseOperation(Set<String> set){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter the your choice: ");
            System.out.println("Add, Remove, Find, Display, Exit");
            choice = scanner.next().toLowerCase();

            switch (choice){
                case "add" -> addElementsToSet(set);
                case "remove" -> {
                    System.out.println("Enter the name of student to delete: ");
                    removeElementsFromSet(set, scanner.next());
                }
                case "find" -> {
                    System.out.println("Enter the name of Student: ");
                    checkIfElementPresentOrNot(set, scanner.next());
                }
                case "display" -> displayElementsOfSet(set);
                case "exit" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (!choice.equals("exit"));
    }

    static void addElementsToSet(Set<String> set){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Student name to add in the set: ");
        set.add(scanner.next());
    }

    static void removeElementsFromSet(Set<String> set, String index){
        set.remove(index);
    }

    static void displayElementsOfSet(Set<String> set){
        set.forEach(s -> System.out.print(s +" "));
        System.out.println();
    }

    static void checkIfElementPresentOrNot(Set<String> set, String element){
        if (set.contains(element)){
            System.out.println("The Student '"+element+"' is present");
        } else System.out.println("Student not found");
    }
}
