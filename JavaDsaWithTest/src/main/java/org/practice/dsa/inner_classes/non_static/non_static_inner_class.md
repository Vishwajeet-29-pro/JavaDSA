# Non-static Inner Class (Member Inner Class)

A non-static inner class, also known as a member inner class, is a class that is defined within another class without
using the static keyword. This type of inner class has the following characteristics:

- Access to Outer Class Members: Non-static inner classes can access all members (fields and methods) of the outer class,
including private ones.
- Object Binding: An instance of a non-static inner class is always associated with an instance of the outer class. You
need an instance of the outer class to create an instance of the non-static inner class.
- Usage: These classes are used when you logically want to group a class within another class and the inner class needs
to access members of the outer class.

**Syntax:**
```java
class OuterClass {
    // define outer class member
    private String outerClassField;
    // define non-static inner class

    class inner {
        // inner class method
        void innerMethod() {
        // accessing outer class member
        System.out.println("Outer field: "+outerClassField);
        }
    }
}
```
**Creating an Instance**
To create an instance of a non-static inner class, you first need to create an instance of the outer class:
```
OuterClass outerClass = new OuterClass();
outerClass.InnerClass inner = outer.new InnerClass();
inner.innerMethod();
```
