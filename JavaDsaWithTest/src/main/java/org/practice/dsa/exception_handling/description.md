# Types of Exceptions

### Checked Exceptions:
Checked exceptions are checked at compile-time.
These exceptions must be either caught using a try-catch block or declared in the method signature using the throws
keyword.

**Examples:** IOException, SQLException.

### Unchecked Exceptions:
Unchecked exceptions are not checked at compile-time, but rather at runtime.
These exceptions do not need to be explicitly caught or declared.
Examples: NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException.

Exception handling in Java is a powerful mechanism to handle runtime errors and maintain the normal flow of the
application. It allows you to catch and handle errors gracefully without crashing your program. Here is a detailed
explanation and example to help you understand and implement exception handling in Java.

Key Concepts:

- Try-Catch Block:
  - Try: A block of code that is likely to throw an exception.
  - Catch: A block of code that handles the exception.

- Finally Block:
A block that executes regardless of whether an exception is thrown or caught.

- Throw and Throws:
  - Throw: Used to explicitly throw an exception.
  - Throws: Indicates that a method can throw an exception.

- Custom Exceptions:
Creating your own exception classes.

Java provides a rich set of built-in classes, methods, and interfaces for handling exceptions. Understanding these
components will help you effectively manage and respond to exceptional conditions in your code.

#### Built-in Exception Classes

**Throwable Class:**
The superclass of all errors and exceptions in the Java language.
Subclasses: Error and Exception.

**Exception Class:**
The superclass for all exceptions that a reasonable application might want to catch.
Subclasses: IOException, SQLException, ClassNotFoundException, etc.

**RuntimeException Class:**
The superclass for all runtime exceptions, which are unchecked exceptions.
Subclasses: NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException, etc.

**Error Class:**
The superclass for all errors, which are not meant to be caught by the application.
Subclasses: OutOfMemoryError, StackOverflowError, VirtualMachineError, etc.

Common Exception Classes
- IOException
- FileNotFoundException
- SQLException
- ClassNotFoundException
- NullPointerException
- ArrayIndexOutOfBoundsException
- IllegalArgumentException
- ArithmeticException

#### Key Methods for Exception Handling

- Throwable Methods:
  - String getMessage(): Returns the detail message string of this throwable.
  - String getLocalizedMessage(): Creates a localized description of this throwable.
  - String toString(): Returns a short description of this throwable.
  - void printStackTrace(): Prints this throwable and its backtrace to the standard error stream.
  - StackTraceElement[] getStackTrace(): Provides programmatic access to the stack trace information.
  - Throwable getCause(): Returns the cause of this throwable or null if the cause is nonexistent or unknown.
  - Throwable initCause(Throwable cause): Initializes the cause of this throwable.

- Exception Methods:
Inherits all methods from Throwable.

- Interfaces

  - AutoCloseable Interface:
    Contains a single method void close() throws Exception.
    Allows an object to be used in a try-with-resources statement, ensuring that the close method is called automatically
    at the end of the statement.

  - Closeable Interface:
    Extends AutoCloseable and adds void close() throws IOException.
    Used for IO operations, like file streams.
