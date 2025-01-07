package org.practice.dsa.cucumber_test;

import java.util.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryManagementSteps {
    private Map<String, Integer> books = new HashMap<>();
    private String searchResult;
    private String errorMessage;

    @Given("the library has following books")
    public void theLibraryHasFollowingBooks(io.cucumber.datatable.DataTable dataTable) {
        books.clear();
        dataTable.asMaps(String.class, String.class).forEach(row ->{
            String title = row.get("Title");
            int quantity = Integer.parseInt(row.get("Quantity"));
            books.put(title, quantity);
        });
    }

    @When("I search for {string}")
    public void iSearchFor(String title) {
        searchResult = books.getOrDefault(title, 0) > 0 ? "Available" : "Not Available";
    }

    @Then("the result should be {string}")
    public void theResultShouldBe(String expected) {
        assertEquals(expected, searchResult);
    }

    @When("I barrow the {string}")
    public void iBarrowThe(String title) {
        int quantity = books.getOrDefault(title, 0);
        if (quantity > 0) {
            books.put(title, quantity - 1);
        } else {
            errorMessage = "Book not available";
        }
    }

    @Then("the quantity of {string} should be {int}")
    public void theQuantityOfShouldBe(String title, int expectedQuantity) {
        assertEquals(expectedQuantity, books.get(title));
    }

    @When("I add a new book {string} with author {string} and quantity {int}")
    public void iAddANewBookWithAuthorAndQuantity(String title, String author, int quantity) {
        books.put(title, quantity);
    }

    @Then("the library should be updated with book details")
    public void theLibraryShouldBeUpdatedWithBookDetails(io.cucumber.datatable.DataTable dataTable) {
        Map<String, Integer> expectedBooks = new HashMap<>();
        dataTable.asMaps(String.class, String.class).forEach(row -> {
            String title = row.get("Title");
            int quantity = Integer.parseInt(row.get("Quantity"));
            expectedBooks.put(title, quantity);
        });
        assertEquals(expectedBooks, books, "Library books do not match with the expected data");
    }

    @When("I delete the book {string}")
    public void iDeleteTheBook(String title) {
        books.remove(title);
    }

    @Then("the book with name {string} is removed")
    public void theBookWithNameIsRemoved(String title) {
        boolean isRemoved = !books.containsKey(title);
        assertTrue(isRemoved, "The book was not removed successfully.");
    }
}
