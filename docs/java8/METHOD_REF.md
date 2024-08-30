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

The method references can only be used to replace a single method of the lambda expression. A code is more clear and short if one uses a lambda expression rather than using an anonymous class and one can use method reference rather using a single function lambda expression to achieve the same. In general, one doesn't have to pass arguments to method references.
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
There are four type method references that are as follows:
1. Static Method Reference.
2. Instance Method Reference of a particular object.
3. Instance Method Reference of an arbitrary object of a particular type.
4. Constructor Reference.
   To look into all these types we will consider a common example of sorting with a comparator.
###### Type 1. Reference to a static method
If a Lambda expression is like:
```
// If a lambda expression just call a static method of a class
(args) -> Class.staticMethod(args)
```
Then method reference is like:
```
// Shorthand if a Lambda expression just call a static method of a class
Class::staticMethod
```
Example:
```
import java.io.*;
import java.util.*;

class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getAge() { return age; }
	public String getName() { return name; }
}

public class Test {

	public static int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

	public static int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Vicky", 24));
		personList.add(new Person("Sunny", 28));
		personList.add(new Person("Rani", 27));
		
		Collections.sort(personList, Test::compareByName);
		
		System.out.println("Sort by name:");
		
		personList.stream()
			.map(x -> x.getName())
			.forEach(System.out::println);
		
		Collections.sort(personList, Test::compareByAge);
		
		System.out.println("Sort by age:");
		
		personList.stream()
			.map(x -> x.getName())
			.forEach(System.out::println);
	}
}
```
###### Type 2. Reference to an instance method of a particular object
If a Lambda expression is like:
```
// If a lambda expression just call a default method of an object
(args) -> obj.instanceMethod(args)
```
Then method reference is like:
```
// Shorthand if a lambda expression just call a default method of an object
obj::instanceMethod
```
Example:
```
import java.io.*;
import java.util.*;
// we are using previous Person class for data.
// Person(String name, int age)

class ComparisonProvider {
	public int compareByName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
	
	public int compareByAge(Person a, Person b) {
		return a.getAge().compareTo(b.getAge());
	}
}

class Test {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("vicky", 24));
		personList.add(new Person("Sachin", 25));
		personList.add(new Person("Poonam", 19));
		
		ComparisonProvider comparator = new ComparisonProvider();
		
		Collection.sort(personList, comparator::compareByName);
		
		System.out.println("Sort by name :");
		
		personList.stream().map(x -> x.getName())
				  .forEach(System.out::println);
				  
		Collection.sort(personList, comparator::compareByAge);
		
		System.out.println("Sort by age: ");
		
		personList.stream().map(x -> x.getName())
				  .forEach(System.out::println); 
	}
}
```
###### Type 3. Reference to an instance method of an arbitrary object of a particular type
If a Lambda expression is like:
```
// If a lambda expression just call an instance method of a ObjectType
(obj, args) -> obj.instanceMethod(args)
```
Then method reference is like:
```
// Shorthand if a lambda expression just call an instance method of a objectType
ObjectType::instanceMethod
```
Example:
```
import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		List<String> personList = new ArrayList<>();
		personList.add("vicky");
		personList.add("pooman");
		personList.add("sachin");
		
		Collection.sort(personList, String::compareToIgnoreCase);
		
		personList.forEach(System.out::println);
	}
}
```
###### Type 4. Constructor method reference
If a lambda expression is like:
```
// if a lambda expression just create an object
(args) -> new ClassName(args)
```
Then method reference is like:
```
// Shorthand if a lambda expression just create an object
ClassName::new
```
Example:
```
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.*;

class Person {
	private String name;
	private String age;
	
	public Person() {
		Random ran = new Random();
		
		// Assigning a random value to name
		this.name = ran.ints(97, 122+1)
						.limit(7)
						.collect(StringBuilder::new,
								 StringBuilder:: appendCodePoint,
								 StringBuilder::append)
						.toString();
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}
public class Test {
	public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply) {
		List<T> list = new ArrayList<>();
		
		for(int i = 0; i < length; i++) 
			list.add(objectSupply.get());
			return list;
	}
	
	public static void main(String[] args) {
		List<Person> personList = getObjectList(5, Person::new);
		
		personList.stream()
			.map(x -> x.getName())
			.forEach(System.out::println);
	}
}
```