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