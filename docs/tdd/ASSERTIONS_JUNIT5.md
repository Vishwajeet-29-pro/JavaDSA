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

### `assertTimeoutPreemptively()`
`assertTimeoutPreemptively()` is similar to `assertTimeout()`, but with a key difference: it preemptively aborts the execution of the code block as soon as the timeout is reached. If the code does not complete within the specified, it throws an exception and stops further execution immediately. This is useful when you don't care about the result if the execution exceeds the timeout and want to fail the test immediately.
`<T> T assertTimeoutPreemptively(Duration duration, Executable executable);`
- `timeout`: The maximum duration that the executable code is allowed to take.
- `executable`: The code want to test, typically passed as a lambda expression.
  Example:
```
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class PreemptiveTimeoutTest {
	
	@Test
	public void testSlowOperationPreemptively() {
		assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
			Thread.sleep(2000);
		});
	}
	
	@Test
	public void testOperationExceedsTimeoutPreemptively() {
		assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
			Thread.sleep(3000);
		})
	}
}
```
In the first test `assertTimeoutPreemptively` allows the code to run since it completes within the specified 5 seconds. In the seconds test, however, the code is aborted immediately after 2 seconds, and the test fails.
#### Key Difference Between `assertTimeout()` & `assertTimeoutPreemptively()`:
- Execution Behavior:
   - `assertTimeout()`: waits for the code to complete, even if it exceeds the timeout, and then fails the test.
   - `assertTimeoutPreemptively()`: Aborts the code execution as soon as the timeout is reached and fails the test immediately.
- Use cases:
   -  Use `assertTimeout()` if you still want to inspect the result or state of the code after it completes, even if it exceeded the allowed time.
   - Use `assertTimeoutPreemptively()` if you want to ensure strict adherence to the time limit and don't case about the result if the timeout is breached.
##### Best Practices:
- Timeout Duration: Always choose a timeout duration that makes sense for the operation you are testing, Setting a timeout that is too short may result in false positives(failures), while setting it too long might defeat the purpose of the test.
- Resource Usage: `assertTimeoutPreemptively()` can be resource-intensive as it may use a separate thread to manage the timeout. Use it judiciously, especially in tests where performance is critical.
- Timeout Testing: Timeout assertions are especially useful in performance test, integration tests, or when testing third-party API calls where delays might occur.

### `assertSame() and assertNotSame()`
##### `assertSame()`:
`assertSame()` is an assertion method in Junit 5 that checks whether two references points to the same object instance. This is different from `assertEquals()`, which checks whether two objects are logically equivalent (i.e. their `equals()` method returns `true`). `assertSame()` ensures that the references are identical, meaning they refer to the exact same object in memory.
```
public static void assertSame(Object expected, Object actual, String message)
public static void assertSame(Object expected, Object actual)
```
- `expected`: The expected object reference.
- `actual`: The actual object reference.
- `message`: (Optional) A custom message that will be displayed if the assertion fails.
  If the expected and actual references, do not point to the same object, the assertion will fail.
  Example Usage
```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class AssertSameTest {
	@Test
	public void testAssertSame() {
		String originalString = "Hello, World";
		String sameReference = orginalString;
		String differentReference = new String("Hello, World");
		
		// This will pass becuase both references points to the same object.
		assertSame(orginalString, sameReference, "Both should references the same object");
		// This will fail because they are different objects, even though they are logically equal.
		assertSame(originalString, differentReference, "These should be the same object reference);
	}
}
```
##### Difference between `assertSame()` and `assertEquals()`:
- `assertSame()`: Checks if both references point to the exact same object.
- `assertEquals()`: Checks if the objects referred to by the references are equal based on their content or logical equality (via the `equals()` method).
##### When to Use `assertSame()`
- Object Identity: Use `assertSame()` when you need to verify that two variables or fields refer to the exact same instance of an object.
- Singleton or Caching Patterns: When testing singleton patterns or caching mechanisms where you expect the same instance to be returned.
- Ensuring Correct References: When you want to ensure that an object passed around or returned by a method is exactly the same object as you expect.
##### Best Practices:
- Use `assertSame()` sparingly, as most tests should focus on the logical equality of objects (`assertEquals()`). However, in cases where object identity is crucial (like in certain design pattern or when testing references), `assertSame()` is invaluable.

##### `assertNotSame()`
The `assertNotSame()` method in JUnit 5 is used to verify that two object references, do not print to the same object in memory. Unlike `assertSame()`, which checks if two references are identical(pointing to the same object), `assertNotSame()` ensures that the references are not identical, even if their contents are equal.
**Syntax**
`assertNotSame(unexpected, actual, message);`
- `unexpected`: The reference that the `actual` reference should not point to.
- `actual`: The actual reference that you are testing.
- `message`: (Optional): A custom message to display if the assertion fails.
  **Usage:**
  `assertNotSame()` is useful when you want to ensure that two references point to different objects even if the objects themselves might be logically equal (in terms of their contents).
```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertion.assertNotSame;

public class AssertNotSameTest {
	@Test
	public void testNotSameReferences() {
		String str1 = new String("Hello");
		String str2 = new string("Hello");
		String str3 = str1;
		//pass
		assertNotSame(str1, str2, "str1 and str2 should not refer to the same object);
		//fail
		assertNotSame(str1, str3, "str1 and str3 should not refer tot he same object");
	}
}
```
###### Difference between `assertNotSame()` and `assertNotEqual()`
- `assertNotSame()`: Checks if two references, do not point to the same object in memory.
- `assertNotEquals()`: Checks if two objects are not equal in terms of their content or logical equality (via the `equals()` method)

###### When to Use `assertNotSame()`:
- Object Identity: Use `assertNotSame()` when you need to verify that two variables or fields refer to different instances of an object.
- Ensuring Correct Instantiation: When testing object creation to ensure that new instances are being created instead of reusing the same instance.
- Verifying Copy Operations: In scenarios where you're copying objects, `assertNotSame()` can be used to ensure that the copy is a distinct object, not just another reference to the same object.
###### Best Practices
- Use `assertNotSame()` in situations where it's important that two references point to different objects, even if their contents are identical. This can help catch bugs where objects are incorrectly shared or reused.

### `assertNull() and assertNotNull()`:
#### `assertNull()`:
The `assertNull()` method in JUnit 5 is used to verify that a given object references is `null`. If the references is not `null`, the assertion fails.
**Syntax**:
`assertNull(actual, message);`
- `actual`: The object references that is expected to be null.
- `message:` (Optional) A custom message that will be displayed if the assertion fails.

**Usage**: `assertNull()` is commonly used in tests to ensure that a method returns `null` when expected or that an object is not initialized yet.

Example
```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertion.assertNull;

public class AssertNullTest {
	@Test
	public void testObjectNull() {
		String str = null;
		assertNull(str, "str should be null"); //pass
	}
	
	@Test
	public void testObjectIsNull() {
		String str = "Hello, World!";
		assertNull(str, "str should be null"); //fail
	}
}
```

##### When to Use `assertNull()`:
- Checking Initialization: When you want to ensure that an object references is not yet initialized or is supposed to be `null` after certain operations.
- Testing API Return Values: When testing method that should return null under certain conditions. (e.g. When an element is not found.)
- Ensuing Cleanup: To verify that a resource or reference has been properly cleaned up or set to null after an operation.
###### Best Practices
- **Clear Messages**: When using `assertNull()`, it's a good practice to provide a clear message that explains why the reference is expected to be `null`. This will help when debugging failed tests.
- **Logical Tests**: Use `assertNull()` only when it logically makes sense for an object to be `null`. In other cases, consider using `assertNotNull()` to ensure that an object is properly instantiated or initialized.

#### `assertNotNull()`
The `assertNotNull()` method in JUnit 5 is used to verify that a given object reference is not `null`. If the reference is null, the assertion fails.
**Syntax:**
`assertNotNull(actual, message)`;
- `actual:` The object references that is expected to be non-null.
- `message`(optional): A custom message that will be displayed if the assertion fails.
  **Usage**
  `assertNotNull()` is typically used in tests to ensure that an object or method return value has been properly instantiated or initialized.
  **Example:**
```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertNotNullTest {
	@Test
	public void testObjectIsNotNull() {
		String str = "Hello, World!";
		
		assertNotNull(str, "str should not be null");
	}
	
	@Test
	public void testObjectIsNull() {
		String str = null;
		assertNotNull(str, "str should not be null"); //fail
	}
}
```

###### When to Use `assertNotNull()`
- Checking Initialization: Use `assertNotNull()` to ensure that an object references has been properly initialized.
- Testing API Return values: Use it when testing methods that should always return a non-null value under normal conditions.
- Validating Results: Ensure that certain operations or methods have produced a valid object or result.
###### Best Practices
- **Clear Messages**: Providing a clear message when using `assertNotNull()` can be helpful for understanding why a particular object is expected to be non-null, especially when a test fails.
- **Logical Tests**: Ensure that the use of `assertNotNull()` is logical and appropriate for the context. It should be used in scenarios where it is crucial that the object is never `null`.

### `assertAll()`:
The `assertAll()` method in JUnit 5 is used to group multiple assertions together in a single test. This allows you to execute all the assertions, even if one or more of them fail. If any of the grouped assertions fail, `assertAll()` reports all failures at once, instead stopping at the first failure.
**Syntax**:
```
assertAll(executableGroup);
assertAll("heading",executableGroup);
```
- `executableGroup`: This is a series of lambda expressions or method references that contain the assertions you want to group together.
- `heading`(Optional): A string that acts as a heading for the group of assertions, making the test output easier to understand.
  **Usage**:
  `assertAll()` is particularly useful when you want to validate multiple conditions in a test and don't want the test to stop at the first failed assertion.
  **Example**
```
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {
	@Test
	public void testMultipleAssertions() {
		String str = "Hello, World!";
		
		assertAll("String Tests",
			() -> assertEquals("Hello, World!", str, "The string should match exactly."),
			() -> assertTrue(str.startsWith("Hello"), "The string should start with 'Hello'"),
			() -> assertTrue(str.endsWith("World!"), "The string should end with 'world!'"),
			() -> assertEquals(13, str.length(), "The length of the string should be 13")
		);
	}
}
```
###### When to Use `assertAll()`
- Multiple Validations: When you need to validate several conditions in a single test, and you want to see the result of each assertions, use `assertAll()` to group them together.
- Comprehensive Testing: It's particularly useful when testing complex objects, where multiple fields or properties need to be validated.
- Reducing Noise: Instead of writing separate tests for each assertion, you can group them into one, reducing the overall number of test methods while still covering all necessary checks.
##### Best Practices:
- Descriptive Messages: Always provide descriptive messages for each assertion within `assertAll()` to make it easier to understand the context when a test fails.
- Avoid Overuse: While `assertAll()` is powerful, avoid grouping too many unrelated assertions together, as it can make the test header to understand.
- Logical Grouping: Use `assertAll()` to group logically related assertions, such as all checks on a single object's properties.
###### Example with failure:
```
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

public class AssertAllFailureTest {

	@Test
	public void testMultipleAssertionsWithFailures() {
		String str = "Hello, World!";
		
		assertAll("String Tests,
		() -> assertEquals("Hi, World!", str, "Expected string to be 'Hi, World!'" ),
		() -> assertTrue(str.startsWith("Hi"), "Expected string to start with 'Hi'"),
		() -> assertTrue(str.endWith("Earth"), "Expected string to end with 'Earth'")
		);
	}
}



Output:
Multiple Failures (3 failures)
    Expected string to be 'Hi, World!' ==> expected: <Hi, World!> but was: <Hello, World!>
    Expected string to start with 'Hi' ==> expected: <true> but was: <false>
    Expected string to end with 'Earth!' ==> expected: <true> but was: <false>

```