package org.practice.dsa.java8.exercise.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // filter books by title
    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public List<Book> filterBooksByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<Book> sortBooksByPublishingYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .toList();
    }

    public int calculateTotalNumberOfPages() {
        return books.stream()
                .mapToInt(Book::getPages)
                .sum();
    }

    public List<String> getListOfAuthors(String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }
}
