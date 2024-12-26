package org.practice.dsa.cucumber_test;

import java.util.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
