package com.practice.dsa.oops.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> list;

    public Library(){
        list = new ArrayList<>();
    }

    public void addBook(Book book){
        list.add(book);
    }

    public void removeBook(String title){
        Iterator<Book> iterator = list.listIterator();
        boolean found = false;
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                found = true;
                System.out.println("Book Deleted Successfully");
            }
        }
        if (!found){
            System.out.println("Book Not found");
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
