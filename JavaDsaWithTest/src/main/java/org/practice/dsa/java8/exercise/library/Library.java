package org.practice.dsa.java8.exercise.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
