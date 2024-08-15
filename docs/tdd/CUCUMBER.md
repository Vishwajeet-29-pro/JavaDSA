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

# Cucumber Reference
Cucumber can be used to implement automated tests based on scenarios described in your Gherkin feature files.

### Step Arguments
In the example in step definitions, Cucumber extracts the text 48 from the step, convert it to an `int` and passes it as an argument to the method.

The number of parameters in the method has to match the number of capture groups in the expression. (If there is a mismatch, Cucumber will throw an error).

### Data Tables
Data tables form Gherkin can be accessed by using the `DataTable` object as the last parameter in a step definition. This conversion can be done either by Cucumber or manually.
Depending on the table shape as one of the following collections:
```
List<List<String>> table
List<Map<String, String>> table
Map<String, String> table
Map<String, List<String>> table
Map<String, Map<String, String>> table
```
The simplest way to pass a `List<String>`  to a step definition is to use a data table:
```
Given the following animals:
| cow   |
| horse |
| sheep |
```
Declare the argument as a `List<String>`, but don't define any capture groups in the expression:

Annotated method style:
```
@Given("the following animals:")
public void the_following_animals(List<String> animals) {
}
```
In this case, the `DataTable` is automatically flattened a `List<String>` by Cucumber (using `DataTable.asList(String.class)`) before invoking the step definition.

Note: In addition to collections of String, `Integer`, `Float`, `BigInteger` and `BigDecimal`, `Byte`,`Short`, `Long` and `Double` are also supported.

### Steps
A steps is analogous to a method call or function invocation.
For example:
```
Given I have 93 cucumbers in my belly
```
In this step, you're "calling" the above step definition with one argument: the value 93.

Steps are declared in your `*.feature` files.

# Matching steps
1. Cucumber matches a step against a step definition's  `Regexp`
2. Cucumber gathers any capture group s or variables
3. Cucumber passes them to the step definition's method and executes it.
   Recall that step definitions with a preposition or an adverb (`Given, When, Then, And, But`).

All step definitions are loaded (and defined) before Cucumber starts to execute the plain text in the feature file.

Once execution begins, for each step, Cucumber will look for a registered step definition with a matching `Regexp`. If it finds one, it will execute it, passing all capture group s and variables from the `Regexp` as arguments to the method.

The specific preposition/adverb used has no significance when Cucumber is registering or looking up step definitions.

### Step Results
Each step can have one of the following results:
#### Success
When Cucumber finds a matching step definition it will execute it. If the block in the step definition doesn't raise an error, the step is marked as successful(green). Anything you return from a step definition has no significance whatsoever.

#### Undefined
When Cucumber can't find a matching step definition, the step gets marked as undefined (yellow), and all subsequent steps in the scenario are skipped.

#### Pending
When a step definition's method invokes the pending method, the step is marked as pending (yellow, as with undefined ones), indicating that you have work to do.

### Failed Steps
When a step definition's method is executed and raises an error, the step is marked as failed (red). What you return from a step definition has no significance whatsoever.<br>
Returning null or false will not cause a step definition to fail.

#### Skipped
Steps that follow undefined, pending or failed steps are never executed, even if there is a matching step definition.  These steps are marked as skipped. (cyan).

#### Ambiguous
Step definitions have to be unique for Cucumber to know what to execute. If you use ambiguous step definitions, Cucumber will raise an `AmbiguousStepDefinitionsException`, telling you to fix the ambiguity.


