# Method References
Understanding the different types of method references and when to use them.
In Java 8 we can use the method as if they were objects or primitive values, and we can treat them as a variable.
```
// This square function is a variable getSquare.
Function<Integer, Integer> getSquare = i -> i * i;

someFunction(a, b, getSquare);
// pass function as a argument to other function easily.
```
Sometimes, a lambda expression only calls an existing method. In those cases, it looks clear to refer to the existing method by name. the method references can do this, they are compact, easy-to-read as compared to Lambda expressions. A method references is a shorthand syntax for a lambda expression that contains just one method call. Here's the general syntax of a
**Generic syntax:** Method reference
1. To refer to a method in an object.
   `Object :: methodName`
2. To print all elements in a list
   Following is an illustration of a lambda expression that just calls a single method in its entire execution:
   `list.forEach(s-> System.out.println(s));`
3. Shorthand to print all elements in a list: To make the code clear and compact, In the above example, one can turn lambda expression into a method reference:
   `list.forEach(System.out::println);`

The method references can only be used to to replace a single method of the lambda expression. A code is more clear and short if one uses a lambda expression rather than using an anonymous class and one can use method reference rather using a single function lambda expression to achieve the same. In general, one doesn't have to pass arguments to method references.
The following example is about performing some operations on elements in the list and adding them. The operation to be performed on elements is a function argument and the caller can pass accordingly.

#### Illustration:
```
public int transformAndAdd(List<Integer> l, Function<Integer, Integer> ops) {
	int result = 0;
	for(Integer s: l) {
		result += f.apply(s);
	}
	return result;
} 
class OpsUtil {
	// Method 1 To half the varibale
	public static Integer doHalf(Integer x) {
		return x / 2;
	}
	// Method 2 Square up the integer number
	public static Integer doSquare(Integer x) {
		return x * x;
	}
	// many more operations...
}
```
Following are the ways to call the above method as depicted below as follows:
```
List<Integer> list = new ArrayList<>();
// Add some elements to list
...
// Using an anonymous class
transformAndAdd(list, new Function<Integer, Integer>(){
	public Integer apply(Integer i) {
		return OpsUtil.doHalf(i);
	}
});

// using a lambda expression
transformAndAdd(list, i -> OpsUtil.doHalf(i));

// Using a method reference
transformAndAdd(list, OpsUtil::doHalf);
```

## Types of Method References