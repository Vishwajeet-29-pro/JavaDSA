package org.practice.dsa.java8.exercise.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    private final Library library = new Library();
    Book b1 = new Book("Java: zero to advance","Vishwajeet", "Science", 2024, 500);
    Book b2 = new Book("Kotlin: zero to advance","Pravin", "Technologies", 2023, 300);
    Book b3 = new Book("Python: zero to advance","Dhiraj", "IT", 2022, 600);
    Book b4 = new Book("JavaScript: zero to advance","Amit", "Computer", 2022, 100);
    Book b5 = new Book("go: zero to advance","Shubham", "IT", 2023, 600);
    Book b6 = new Book("C#: zero to advance","Rushi", "Science", 2024, 300);

    @BeforeEach
    public void setup() {
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);
        library.addBook(b6);
    }

    @Test
    public void testFindBookByTitle() {
        String title = "Java: zero to advance";
        Optional<Book> expected = Optional.ofNullable(b1);
        var actual = library.findBookByTitle(title);
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterBookByGenre() {
        String genre = "IT";
        List<Book> expected = List.of(b3, b5);
        List<Book> actual = library.filterBooksByGenre(genre);
        assertEquals(expected, actual);
    }

    @Test
    public void testSortBookByPublishingYear() {
        List<Book> expected = List.of(b3, b4, b2, b5, b1, b6);
        List<Book> actual = library.sortBooksByPublishingYear();
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateTotalPages() {
        int expected = 2400;
        int actual = library.calculateTotalNumberOfPages();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetListOfAuthors() {
        String genre = "Science";
        List<String> expected = List.of(b1.getAuthor(),b6.getAuthor());
        List<String> actual = library.getListOfAuthors(genre);
        assertEquals(expected, actual);
    }
}
