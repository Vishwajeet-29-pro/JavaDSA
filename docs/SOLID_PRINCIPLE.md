`In Java, SOLID principles are an object-oriented approach that are applied to software structure design. It is conceptualized by Robert C. Martin (Uncle Bob). These five principles have changed the world of object-oriented programming, also changed the way of writing software. It also ensures that the software is modular, easy to understand, debug, and refactor. In this section, we will discuss SOLID Principles in java with proper examples.`
##### The word SOLID acronym for:
- Single Responsibility Principle (SRP)
- Open-Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

![SOLID principle](https://static.javatpoint.com/core/images/solid-principles-java.png)

## Single Responsibility Principle
The single responsibility principle states that every Java class must perform a single functionality. Implementation of multiple functionalities in a single class mashup the code and if any modification is required may affect the whole class. It precise the code and the code can be easily maintained. Let's understand the single responsibility principle through an example` 

Suppose, Student is a class having three methods namely printDetails(), calculatePercentage(), and addStudent(). hence, the Student class has three responsibilities to print the details of Students, calculate percentages, add database. By using the single responsibility principle, we can separate these functionalities into three separate classes to fulfill the goal of the principles.

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

To above code snippet violates the single responsibility principle. To achieve the goal of the principle, we should implement a separate class that performs a single functionality only.

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

