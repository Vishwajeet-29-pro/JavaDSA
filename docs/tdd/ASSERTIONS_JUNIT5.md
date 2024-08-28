1. `assertEquals()`
2. `assertNotEquals()`
3. `assertTrue()`
4. `assertFalse()`
5. `assertThrows()`
6. `assertDoesNotThrow()`
7. `assertThat() // from assertJ and hemcrest`
8. `assertArrayEquals()`
9. `assertIterableEquals()`
10. `assertTimeout()`, `assertTimeoutPreemptively()`
11. `assertSame()`, `assertNotSame()`
12. `assertNull()`, `assertotNull()`
13. `assertAll()`

*If the method does not return anything and that time if you want to test the code, how can you?*
-->  Whenever we create a method with return type void, it produces the side effect after calling the method. We can generally test these side effects.
Examples:
1. modifying the state of an object.
2. changing the values of parameters.
3. updating external resources.
   Code example:
```
public void swapNumbers(int[] arr) {
	int temp = arr[0];
	arr[0] = arr[1];
	arr[1] = temp;
}
```
for the above method we can verify the output by calling the method.
```
public class SwapNumbersTest {
	private final SwapNumbers s = new SwapNumbers();
	@Test
	public void testSwapNumbers() {
		int[] arr = {10, 20};
		s.swapNumbers(arr);
		assertEquals(20, arr[0], "The first number should be 20");
		assertEquals(10, arr[1], "The second number should be 10");
	}
}
```
#### `assertTrue() and assertFalse()`
**`assertTrue()`** : The `assertTrue` method in JUnit is used to assert that a given `true`. If the condition evaluates to `false`, the test will fail. This method is often used to check `boolean` expressions or conditions that you expect to be true during your tests.
Syntax:
```
assertTrue(boolean condition);
assertTrue(boolean condition, String message);
```
- `condition` : the `boolean` expression that you expect to be true.
- `message` : (Optional) A custom error message that will be displayed if the assertion fails.
##### Example:
```
public class MathTest {
	@Test
	public void testIsPositive() {
		int number = 5;
		assertTrue(number > 0, "The number should be positive")
	}
}
```
##### When to Use `assertTrue()`
- Boolean Methods: Use `assertTrue()` when testing methods that returns a `boolean` value.
- Conditions: Use it to verify conditions or expressions that should evaluate to `true`.
- Custom Messages: It's often helpful to include a custom message that describe what the test is checking, so you can quickly understand what failed if the assertion does not pass.

**`assetFalse()`** :
`assertFalse()` is used in JUnit tests to assert that a given condition is false. You would use `assertFalse()` when you want to verify that an expression, method, or variable evaluates to `false` as part of your test case.
##### Use cases for `assertFalse()`
1. Negative Logic Verification: When you want to ensure that a specific condition is not true.
2. Testing Methods That Returns a Boolean: When you have a method that should return `false` under certain conditions.
3. Validating State After an Operation: After performing an operation, you might want to check that a particular state or condition remains or become false.
##### Example Usage
```
public class MyTest {
	
	@Test
	public void testIsEmpty() {
		String str = "Hello";
		assertFalse(str.isEmpty(), "String should not be empty");
	}

	@Test
	public void testIsNegative() {
		int number = -5;
		assertFalse(number > 0, "Number should not be positive");
	}
}
```
- Use `assertFalse()` when you expect the condition you're testing to be false.
- It is useful for confirming that a particular negative condition is met, ensuring the correctness of your logic in those scenarios.

### AssertThrows()
If method will throw some exception at runtime or may be it will generate some exception, and we need to catch that, for that we can use `AssertThrows()`. here is how we can implement code for it.
```
public class ArrayCheck {
public void checkArray(int[] arr) {
	if(arr.length == 0) throw new RuntimeException("Empty array passed.");
	// other logic to perform operation on array.
	}
}
```
The test case for the checking the exception using AssertThrows():
```
public class ArrayTest {
	private final ArrayCheck check = new ArrayCheck();

	@Test
	public void testCheckArray() {
		int arr[] = {};
		Exception exception = assertThrows(RuntimeException.class, ()->{
			check.checkArray(arr);
		});	

		assertThrows("Empty array passed.", exception.getMessage());
	}
}
```

### `assertDoesNotThrow()`
The `assertDoesNotThrow()` method in JUnit5 is used to verify that a piece of code does not throw an exception. This is useful when you want to ensure that a method executes without errors, especially if you're not interested in the method's return value but rather in ensuring that it runs successfully.
**Basic Syntax**:
`assertDoesNotThrow(executable, messageSupplier);`
- `executable`: This is typically a lambda expression or method reference that contains the code you expect not to throw an exception.
- `messageSupplier`(Optional): A message that is displayed if the assertion fails.
##### Example Usage
```
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MyTest {
	@Test
	public void testMethodDoesNotThrowException() {
		// Assuming this method might throw an exception, but you expect it not to.
		assertDoesNotThrow(() -> myMethodShouldNotThrow(), "Method threw an exception unexpectedly");
	}

	@Test
	public void testAnotherMEthodDoesNotThowException() {
		// another example with a method reference
		assertDoesNotThrow(this::anotherMethodThatShouldNotThrow);
	}
}
```
##### When to Use `assertDoesNotThrow`
1. **Validating Safe Execution**: Use `assertDoesNotThrow` when you want to assert that a method completes without throwing any exception, regardless of the method's return value.
2. **Testing for Non-Exceptional Behavior**: This is especially useful in cases where exceptions might be expected (e.g., due to improper input) but you're specifically testing a scenario where an exception should not occur.
3. **Defensive code checks**: If your code is defensive against potential runtime issues, you can use `assertDoesNotThrow` to ensure that those issues are properly handled and no exceptions are thrown.
###### Example with Optional Use Cases
```
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {
	@Test
	public void testOptionalIfPresentDoesNotThrow() {
		Optional<String> optional = Optional.of("Hello");

		assertDoesNotThrow(() -> optional.if(value -> {
			System.out.println(value);
		}));
	}
}
```
### Summary

- `assertDoesNotThrow` is used to ensure that a block of code executes without throwing any exceptions.
- It is particularly useful when the correctness of the test lies in the fact that no exceptions should occur, rather than in specific return values or output.
- Ideal for scenarios where you want to validate the absence of exceptions in potentially risky code.

#### `assertThat()`
`assertThat()` is a powerful and flexible assertion method provided by various testing libraries, including `Hamcrest` and `AssertJ`, that allows for more expressive and readable test assertions compared to the traditional `assertEquals`, `assertTrue` and `assertFalse` methods. Unlike the simple assertions, `assertThat()` provides a fluent API that can be extended with custom matchers making it very useful for complex or specialized assertions.
###### Basic Usage of `assertThat()`
In general, the syntax for using `assertThat()` looks like this:
```
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyTest {
	@Test
	public void testString() {
		String str = "Hello, World!";
		assertThat(str, containsString("world"));
	}

	@Test
	public void testNumber() {
		int number = 10;
		assertThat(number, is(greaterThan(5)));
	}
}
```
##### When to Use `assertThat()`
1. Complex Assertions: Use `assertThat()` when you need to make more complex assertion that are not easily expressed with `assertEquals`, `assertTrue`, `assertFalse`.
2. Readability: `assertThat()` allows you to create readable and expressive tests. The fluent API and matcher methods make it clear what condition you are testing.
3. Custom Matchers: If you need to create your own conditions (custom matchers), `assertThat()` is the preferred method. You can use pre-built matchers or create custom ones.
#### Example with Hamcrest
Hamcrest is the most commonly used library with `assertThat()` in Junit tests.
```
import static org.hamcrest.MatcherAssert.assertThat; import static org.hamcrest.Matchers.*;

public class HamcrestTest {
	@Test
	public void testCollection() {
		List<String> list = Arrays.asList("apple","banana","cherry");

		assertThat(list, hasSize(3));
		assertThat(list, contains("apple"));
		assertThat(list, everyItem(containsString("a")));
	}

	@Test
	public void testObjectProperty() {
		Person person = new Person("John", 30);

		assertThat(person.getName(), equalTo("John"));
		assertThat(person.getAge(), is(30));
	}
}
```
##### Example with AssertJ
AssertJ is another popular library that provides a similar fluent API for assertions:
```
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
	@Test
	public void testString() {
		String str = "Hello, world!";
		assertThat(str).startWith("Hello")
						.endsWith("world!")
						.contains("world!")
	}

	@Test
	public void testNumber() {
		int number = 10;
		assertThat(number).isGreaterThan(5)
						.isLessThanOrEqualTo(10)
						.isPositive();
	}
}
```

### Summary

- Use `assertThat()` when you need more expressive, readable, and flexible assertions.
- It is particularly useful for complex assertions and can be extended with custom matchers.
- Libraries like Hamcrest and AssertJ provide a wide range of matchers to use with `assertThat()`.

### `assertArrayEquals()`
Compares two arrays to ensure they are equal.
`assertArrayEquals()` is used to test whether two arrays are equal. This assertion checks that:
1. Both arrays are of the same length.
2. The elements at each index in both arrays are equal.
   If these conditions are met, the assertion passes. If not, the test fails.

###### Common Usages
`assertArrayEquals()` can be used for various array types including `int[]`, `double[]`, `object[]` and more. It's typically used when you have a method that returns an array, and you want to verify that the output matches your expectations.
**Syntax**:
```
void assertArrayEquals(expectedArray, actualArray, String message);
```
`expectedArray` The expected array.
`actualArray`: The arrays that the method under test returns.
`message`(Optional): A message that gets displayed if the assertion fails.
#### Examples:
1. Testing with Integer Arrays
   ```
   @Test
   public void testIntegerArrayEquality() {
       int[] expected = {1,2,3,4};
       int[] actual = {1,2,3,4};
       assertArrayEquals(expected, actual, "The integer array should be equal.");
   }
   ```
2. Testing with Double Arrays(with Delta)
   For floating-point numbers(`float[]` or  `double`), due to precision issues, you might need to use a delta to determine how close two numbers should be to be considered equal.
  ```
   @Test
   public void testDoubleArrayEqualityWithDelta() {
	   double[] expected = {1.0, 2.0, 3.0};
	   double[] actual = {1.0, 2.00000001, 3.0};
	   assertArrayEquals(expected, actual, 0.0001,"The double array should be equal within given delta.");
   }
```

**Best Practices**
- Order matters: The order of elements in the arrays important, if the arrays have the same elements but in a different order, `assertArrayEquals()` will fail.
- Use Delta for Floating Points: When comparing `float[]` or `double[]`, always use the delta version to avoid issues with precision.
- Null Arrays: If either the expected or actual array is null, `assertArrayEquals()` will throw an `AssertionError`. If you expect a null array, use `assertNull()` instead.

### `assertIterableEquals()`
`assertIterableEquals()` is used to compare two `Iterable` objects (like `List`, `Set`, or any other class that implements the `Iterable` interface) to check if they are equal. This assertion checks that:
1. Both iterables have the same number of elements.
2. The elements at each position in both iterables are equal and appear in the same order.
   This is particularly useful when you want to test methods that return collections of objects or other iterable data structures.
   **Syntax**:
```
void assertIterableEquals(Iterable<?> expected, Iterable<?> actual, string message);
```
Examples
1. Testing with Lists
   ```
   @Test
   public void testListEquality() {
       List<String> expected = Arrays.asList("JUnit","is","great");
       List<String> actual = Arrays.asList("JUnit","is","great");
       assertIterableEquals(expected, actual,"The lists should be equal.");
   }
   ```
2. Testing with Sets
   ```
   @Test
   public void testSetEquality() {
       Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3));
       Set<Integer> actual = new HashSet<>(Arrays.asList(1, 2, 3));
       assertIterableEquals(expected, actual, "The sets should be equal.");
   }
   ```
This test will pas because both sets contain the same elements. However, note that `Sets` do not maintain order, so this is better used with order-dependent iterables like `Lists`.
**Best Practices**
- Order Matters: When using `assertIterableEquals()` on ordered collections like `List`, the order of elements is crucial. If the order of elements differs between the `expected` and `actual` iterable, the test will fail.
- Null Handling: If either the `expected` or `actual` iterable is `null`, as `AssertionError` will be thrown unless both are `null`.
- Custom Object Equality: When testing collection of custom objects, ensure that the `equals()` and `hashcode()` methods are properly overridden to reflect equality based on the relevant fields.

### `assertTimeout()`
`assertTimeout()` checks whether a piece of code completes within a specified duration. If the code takes longer than the specified timeout, the test fails. However, it waits for the code to finish execution, even if the timeout has been exceeded. This can be useful if you want to analyze the result or behavior of the code even if it took too long.
Syntax:
```
<T> T assertTimeout(Duration timeout, Executable executable);
```
- `timeout`: The maximum duration that the executable code is allowed to take.
- `executable`: The code you want to test, typically passed as a lambda expression.
  Example:
```
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeoutTest {

	@Test
	public void testSlowOperation() {
		assertTimeout(Duration.ofSeconds(5), () -> {
			Thread.sleep(2000);
		});
	}
	
	@Test
	public void testOperationExceedsTimeout() {
		assertTimeout(Duration.ofSeconds(2), () -> {
			Thread.sleep(3000);
		})
	}
}
```
In the first test, the `assertTimeout` assertion passes because the code block completes within the specified 5 seconds. 
In the seconds test, the assertion fails because the code takes longer than the 2 seconds timeout.