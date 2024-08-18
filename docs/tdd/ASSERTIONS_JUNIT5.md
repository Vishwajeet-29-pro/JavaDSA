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
