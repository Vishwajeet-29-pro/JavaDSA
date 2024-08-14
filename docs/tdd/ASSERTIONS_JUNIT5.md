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
