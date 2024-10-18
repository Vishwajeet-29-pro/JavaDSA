# Local Inner Class

A local inner class is a class defined within a method or a block of code. Local inner classes are not visible outside
    the method or block where they are defined. They have the following characteristics:

- Scope: Local inner classes are scoped to the block, method, or constructor in which they are defined. They are not
    accessible outside of that scope.
- Access to Enclosing Class Members: They can access the members (both static and non-static) of the enclosing class.
    Additionally, they can access final or effectively final variables of the enclosing method.
- Instantiation: Local inner classes are instantiated within the block, method, or constructor where they are defined.

**Syntax:**
```java

    class OuterClass {
        // some method
        void someMethod() {
            // Local inner class:
            class LocalInnerClass {
                void display() {
                    System.out.println("Local Inner class elements");
                }
            }
            // creating local inner class instance:
            LocalInnerClass inner = new LocalInnerClass();
            inner.display();
        }
    }
```

Local inner classes are particularly useful in scenarios where you need to encapsulate functionality that is closely
    tied to the specific method or block of code. They help to keep the code organized and more readable by limiting the scope of the class to where it's actually used. Here are some typical use cases and examples:

**Use Cases for Local Inner Classes**
- Encapsulating Method-Specific Logic:
    When a piece of functionality is only relevant to a specific method and does not need to be reused elsewhere.
- Implementing Callbacks or Listeners:
    When you need to handle events or callbacks within a method, especially if the logic is simple and localized.
- Simplifying Complex Methods:
    When breaking down complex methods into smaller, manageable chunks by defining helper classes within the method.
