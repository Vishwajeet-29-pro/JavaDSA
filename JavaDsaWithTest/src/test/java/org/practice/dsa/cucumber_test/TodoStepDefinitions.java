package org.practice.dsa.cucumber_test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoStepDefinitions {

    private List<String> todoList;

    @Given("I have an empty todo list")
    public void i_have_an_empty_todo_list() {
        todoList = new ArrayList<>();
    }

    @When("I add a new todo with the title {string}")
    public void iAddANewTodoWithTheTitle(String todo) {
        todoList.add(todo);
    }

    @Then("the todo list should contain {int} todo")
    public void theTodoListShouldContainTodo(int count) {
        assertEquals(count, todoList.size());
    }


    @And("the title of the first todo should be {string}")
    public void theTitleOfTheFirstTodoShouldBe(String title) {
        assertEquals(title, todoList.getFirst());
    }
}
