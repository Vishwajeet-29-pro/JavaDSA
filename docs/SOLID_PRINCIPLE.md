`In Java, SOLID principles are an object-oriented approach that are applied to software structure design. It is conceptualized 
by Robert C. Martin (Uncle Bob). These five principles have changed the world of object-oriented programming, also changed 
the way of writing software. It also ensures that the software is modular, easy to understand, debug, and refactor. In this 
section, we will discuss SOLID Principles in java with proper examples.`
##### The word SOLID acronym for:
- Single Responsibility Principle (SRP)
- Open-Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

![SOLID principle](https://static.javatpoint.com/core/images/solid-principles-java.png)

## Single Responsibility Principle
The single responsibility principle states that every Java class must perform a single functionality. Implementation of 
multiple functionalities in a single class mashup the code and if any modification is required may affect the whole class.
It precise the code and the code can be easily maintained. Let's understand the single responsibility principle through an example` 

Suppose, Student is a class having three methods namely printDetails(), calculatePercentage(), and addStudent(). hence, 
the Student class has three responsibilities to print the details of Students, calculate percentages, add database. By 
using the single responsibility principle, we can separate these functionalities into three separate classes to fulfill 
the goal of the principles.

```
Student.java

public class Student {
	public void printDetails() {
	// functionality of the method.
	}

	public void calculatePercentage() {
	// functionality of the method.
	}

	public void addStudent() {
	// functionality of the method.
	}
}
```

To above code snippet violates the single responsibility principle. To achieve the goal of the principle, we should 
implement a separate class that performs a single functionality only.

```
Student.java
public class student {
	public void addStudent() {
		// functionality of the method.
	}
}

PrintStudentDetails.java

public class PrintStudentDetails {
	public void printStudents() {
		// functionality of the method.
	}
}

Percentage.java

public class Percentage {
	public void calculatePercentage() {
		// functionality of the method.
	}
}
```

### Open-Closed Principle (OCP)
The application or module entities the methods, functions, variables, etc. The open-closed principle states that according 
to new requirements the module should be open for extension but closed for modification. The extension allows us to implement 
new functionality to the module. Let's understand the principle through an example
Suppose, `VehicleInfo` is a class and it has the method `vechicleNumber()` that returns the vehicle number.

`VehicleInfo.java`
```
public class VehicleInfo {
	public double vehicleNumber(Vehicle vcl) {
		if (vcl instanceof Car) {
			return vcl.getNumber();
		}
		if (vcl instanceof Bike) {
			return vcl.getNumber();
		}
	}
}
```
If we want to add another subclass named Truck, simply, we add one more if statement that violates the open-closed principle. 
The only way to add the subclass and achieve the goal of principle by overriding the `vehicleNumber()` method, as we have shown below:

```
public class VehicleInfo {
	public double vehicleNumber() {
		// functionality
	}
}

public class Car extends VehicleInfo {
	public double vehicleNumber() {
		return this.getValue();
	}
}

public class Bike extends VehicleInfo {
	public double vehicleNumber() {
		return this.getValue();
	}
}
```
Similarly, we can add more vehicles by making another subclass extending from the vehicle class. The approach would not 
affect the existing application.

### Liskov Substitution Principle (LSP)
The Liskov Substitution Principle was introduced by Barbara Liskov. It applies to inheritance in such a way that the derived 
classes must be completely substitutable for their base classes. In other words, if class A is a subtype of class B, then 
we should be able to replace B with A without interrupting the behavior of the program.
It extends the open-close principle and also focuses on the behavior of superclass and its subtypes. We should design the 
classes to preserve the property unless we have a strong reason to do otherwise. Let's understand the principle through 
an example.
### Applying LSP in Java
To properly apply LSP in Java, follow these guidelines:
1. **Ensure Correct Override of Methods:**
    - Subclasses should override methods from the base class in a way that preserves the behavior expected by clients of the base class.
2. **Avoid Strengthening Preconditions:**
    - A subclass should not enforce stricter preconditions than the base class method.
3. **Preserve Postconditions:**
    - A subclass should not weaken the postconditions established by the base class method.
4. **Maintain Invariants:**
    - Ensure that any invariants of the base class are preserved in the subclass.
5. **Avoid Changing the Base Class’s Contract:**
    - Don't alter the expected behavior of the base class methods in the subclass.

Student.java
```
public class Student {
	private double height;
	private double weight;

	public void setHeight(double height) {
		this.height = height;
	}

	public vid setWeigth(double weight) {
		this.weight = weight;	
	}
	// other functionality
}

public class StudentBMI extends Student {
	public void setHeight(double height) {
		super.setHeight(height);
		super.setWeight(weight)	
	}
	public void setWeight(double weight) {
		super.setHeight(height);
		super.setWeight(weight);	
	}
}
```

The above classes violates the Liskov substitution principle because the `StudentBMI` class has extra constraints i.e. 
height and weight that must be the same. Therefore, the Student class  (base class) cannot be replaced by `StudentBMI` 
class (derived class).

### Interface Segregation Principle
The principle states that the larger interfaces split into smaller ones. Because the implementation classes use only the 
methods that are required. We should not force the client to use the methods that they do not want to use.

The goal of the interface segregation principle is similar to the single responsibility principle. Let's understand the 
principle through an example.

![Interface Segregation Principle](https://static.javatpoint.com/core/images/solid-principles-java2.png)

Suppose, we have created an interface named Conversion having three methods `intToDouble()`, `intToChar()`, `charToString()`

```
public interface Conversion {
	public void intToDouble();
	public void intToChar();
	public void charToString();
}
```
The above interface has three methods. If we want to use only a method `intToChar()` we have no choice to implement the 
single method. To overcome the problem, the principle allows us to split the interface into three separate ones.

```
public interface convertIntToDouble {
	public void intToDouble();
}

public interface ConvertIntToChar {
	public void intToChar();
}

public interface ConvertCharToString {
	public void charToString();
}
```
Now we can use only the method that is required. Suppose we want to convert the integer to double and character to string
then, we will use only the methods `intToDouble()` and `charToString()`
```
public class DataTypeConversion implements ConvertIntToDouble, ConvertCharToString {
	public void intToDouble() {
		// conversion logic
	}
	public void charToString() {
		// conversion logic
	}
} 
```

### Dependency Inversion Principle

The principle states that we must use abstraction (abstract classes and interfaces) instead of concrete implementations. High-level modules should not depend on the low-level module but both should depend on the abstraction. Because the abstraction does not depend on details but the details depends on abstraction. It decouples the software.
```
public class WindowMachine {
// functionality
}
```
It is worth, if we have not keyboard and mouse to work on Windows. To solve this problem, we create a constructor of the class and add the instances of the keyboard and monitor. After adding the instances, the class looks like the following:
```
public class WindowsMachine {
	public final keyboard;
	public final monitor;

	public WindowsMachine() {
		monitor = new monitor();
		keyboard = new keyboard();
	}
}
```

Now we can work on the Windows machine with the help of a keyboard and mouse. But we still face the problem. Because we have tightly coupled the three classes together by using the new keyword. It is hard to test the class Windows machine.

To make the code loosely coupled, we decouple the `WindowsMachine` from the keyboard by using the Keyboard interface and this keyword.

Keyboard.java
```
public interface Keyboard {
// functionality
}

WindowsMachine.java

public class WindowsMachine {
	private final Keyboard keyboard;
	private final Monitor monitor;

	public WindowsMachine(Keyboard keyboard, Monitor monitor) {
		this.keyboard = keyboard;
		this.monitor = monitor;
	}
}
```

In the above code, we have used the dependency injection to add the keyboard dependency in the `WindowsMachine` classes.

![dependency inversion](https://static.javatpoint.com/core/images/solid-principles-java3.png)

# Why should we use SOLID principles?
- It reduces the dependencies so that a block of code can be changed without affecting the other code blocks.
- The principles intended to make design easier, understandable.
- By using the principles, the system is maintainable, testable, scalable, and reuseble.
- It avoids the bad design of the software.