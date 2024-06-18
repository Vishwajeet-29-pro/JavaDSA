package com.practice.dsa.oops.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        chooseOperation(library);
    }

    public static void chooseOperation(Library library){
        String choice;
        do {
            System.out.println("Enter your choice: (Add, Remove, Display, Search, Exit): ");
            choice = scanner.next().toLowerCase();

            switch (choice){
                case "add" -> library.addBook(addNewBook());
                case "remove" -> library.removeBook(getTitle());
                case "display" -> library.displayBook();
                case "search" -> library.searchBook(getTitle());
                case "exit" -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (!choice.equalsIgnoreCase("exit"));
    }

    public static Book addNewBook(){
        Book book = new Book();
        scanner.nextLine();
        System.out.println("Enter the title of book: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Enter the Author of Book: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Enter the isbn: ");
        book.setIsbn(scanner.nextLine());
        return book;
    }

    public static String getTitle(){
        scanner.nextLine();
        System.out.print("Enter the title of the book: ");
        return scanner.nextLine();
    }
}
