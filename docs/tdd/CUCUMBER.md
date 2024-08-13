# Cucumber

### Step Definitions
A step Definitions is a method with an expression that links it to one or more Gherkin steps. When Cucumber executes a Gherkin step in a scenario, it will look for a matching step definitions to execute.

To illustrate how this works, look at the following Gherkin Scenario:
```
Scanario: Some cukes
	Given I have 48 cukes in my belly
```
The `I have 48 cukes in my belly` part of the step (the text following the Given keyword) will match the following step definition:
```
package com.example;
import io.cucumber.java.en.Given;

public class StepDefinitons {
	@Given("I have {int} cukes in my belly")
	public void i_have_n_cukes_in_my_belly(int cukes) {
		System.out.println("Cukes: %n\n", cukes);
	}
}
```
### Expressions
A step definition's expression can either be a Regular Expression or a Cucumber Expression. The examples in this section use Cucumber Expressions. If you prefer to use Regular Expressions, each capture group from the match will be passed as arguments to the step definition's method.

```
@Given("I have {int} cukes in my belly")
public void i_have_n_cukes_in_my_belly(int cukes) {
}
```
If the capture group expression is identical to one of the registered parameter type's `regexp`, the captured string will be transformed before it is passed to the step definition's method. In the example above, the `cukes` argument will be an integer, because the built-in `int` parameter type's `regexp` is `\d+`.

## State management
A step definition can transfer state to a subsequent step definition by storing state in instance variables.

## Scope
Step definitions aren't linked to a particular feature file or scenario. The file, class or package name of the a step definition does not affect what Gherkin steps it will match. The only thing that matters is the step definition's expression.

## Snippets
When Cucumber encounters a Gherkin step without a matching step definition, it will print a step definition snippet with a matching Cucumber Expression. You can use this as a starting point for new step definitions.
Consider this Gherkin step:

`Given I have 3 reb balls`

If you don't have a matching step definition, cucumber will suggest following snippet:
```
@Given("I have {int} red balls")
public void i_have_red_balls(int int1) {
}
```
Suggested snippets will use your own parameters types if they match parts of your undefined step. If a color parameter type exists, cucumber would use that in the suggested expressions:
```
@Given("I have {int} {color} balls")
public void i_have_color_balls(int int1, Color color){
}
```
Make sure you use the summary plugin when running Cucumber in order to have the snippets printed.
