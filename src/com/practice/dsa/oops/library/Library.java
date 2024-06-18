package com.practice.dsa.oops.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> list;

    public Library(){
        list = new ArrayList<>();
    }

    public void addBook(Book book){
        list.add(book);
    }

    public void removeBook(String title){
        for (var book: list){
            if (book.getTitle().equalsIgnoreCase(title)){
                list.remove(book);
            }
            else System.out.println("Book not found");
        }
    }

    public void displayBook(){
       for (Book book: list){
           System.out.println(book.toString());
       }
    }

    public void searchBook(String title) {
        for (Book book: list){
            if (book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book);
            } else System.out.println("Not found");
        }
    }
}
