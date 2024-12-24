package org.practice.dsa.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionTwoList {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        chooseOperation(list);
    }

    private static void chooseOperation(List<String> list) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Enter Operation want to perform: ");
            choice = scanner.next().toLowerCase();
            switch (choice){
                case "add" -> addElementToList(list);
                case "display" -> displayListContent(list);
                case "remove" -> {
                    System.out.println("Enter the index of the element to delete: ");
                    var index = scanner.nextInt();
                    deleteElementFromList(list, index);
                }
                case "check" -> {
                    System.out.println("Enter the student name to validate: ");
                    var studentName = scanner.next();
                    if (checkStudentIsInList(studentName, list)) {
                        System.out.println("Student "+studentName+" is in the list");
                    } else System.out.println("Not in the list");
                }
                case "q" -> System.out.println("Exiting....");
                default -> {
                    System.out.println("Invalid choice");
                }
            }
       } while (!choice.equals("q"));
    }

    static boolean checkStudentIsInList(String name, List<String> list){
        return  false;
    }

    static void addElementToList(List<String> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Student Name to add in the list: ");
        list.add(scanner.next());
    }

    static void deleteElementFromList(List<String> list, int index){
        list.remove(index);
    }

    static void displayListContent(List<String> list){
        for (var element : list){
            if (list.lastIndexOf(element) == list.size() -1)
                System.out.print(element);
            else {
                System.out.print(element+",");
            }
        }
        System.out.println();
    }
}
