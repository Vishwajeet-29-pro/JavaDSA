1. Difference between `volatile` and `transient` variables in java?
    
    - `volatile`:
      - The `volatile` keyword is used in multithreaded environment to ensure that a variable's value is always read from and 
        written to the main memory, not from a thread's local cache. This ensures visibility of changes to variables across threads.
    - `transient`:
      - The `transient` keyword is used in the context of serialization. It indicates that a variable should not be serialized when the object
        is being converted to a byte stream (e.g., during file saving or network transmission). When the object is deserialized, the transient 
        variable will have its default value (e.g., null for objects, 0 for primitives)

    - volatile used for thread safety in multithreaded environments to ensure that changes made by one thread to a variable are visible to all other threads.
    - transient used in serialization context to prevent certain variables from bing included in the serialized form of an object
    - volatile variable is read from and written to main memory directly.
    - transient has nothing to do with memory management during program execution. It only affects the variable during the process of serialization. 
    - Thread safety: volatile is used for visibility of changes across threads. eg. when one thread updates a volatile variable, the update is immediately visible to all other threads.
    - transient has no impact on thread safety or multithreading. It is purely about serialization.

2. Difference between `Vector` and `ArrayList`:

    | Feature                      | Vector                                                          | ArrayList                                                     |
    |------------------------------|-----------------------------------------------------------------|---------------------------------------------------------------|
    | Synchronization              | Synchronized (thread-safe)                                      | Not synchronized (not thread-safe)                            |
    | Performance in Single Thread | Slower due to synchronization                                   | Faster as no synchronization overhead                         |
    | Growth Rate                  | Doubles the size when capacity is exceeded                      | Increases by 50% of the current size                          |
    | Iterator Rate                | Fail-fast and synchronized                                      | Fail-fast, but not synchronized                               |
    | Legacy Status                | Considered legacy, introduced in JDK 1.0                        | Part of Java Collections Framework, introduced in JDK 1.2     |
    | Usage in Multi-threading	    | Can be used in multi-threaded environments due to thread safety | Not suitable for multi-threading unless manually synchronized |
    | Default Size Increase        | Grows by 100% (doubles in size)                                 | Grows by 50% (1.5x times the size)                            |

3. How Collection is different from Collections in Java?
    
   | Feature            | Collection                                                               | Collections                                                                      |
   |--------------------|--------------------------------------------------------------------------|----------------------------------------------------------------------------------|
   | Type               | Interface                                                                | Utility class                                                                    |
   | Belongs to         | `java.util` package                                                      | `java.util` package                                                              |
   | Inheritance        | Superinterface of the Java Collection framework                          | No inheritance, but provides static utility methods.                             |
   | Purpose            | Defines the basic operations for data structures that stores objects     | Provides utility methods for working with collections. (e.g., sorting, searching |
   | Core Functionality | Used as a blueprint for other interfaces like `List`, `Set` and `Queue`. | Offers helper methods such as sorting synchronization, and other common tasks.   |
   | Common Methods     | `add()`, `remove()`, `size()`, `iterator()`, etc.                        | `sort()`, `reverse()`, `synchronizedList()`, `binarySearch()`, etc               |
   | Usage              | Implemented by data structures like ArrayList, HashSet, LinkedList       | Used to perform utility operations on Collection types.                          |

4. Importance of `hashCode()` and `equals()`?
    - These methods are crucial in Java for defining how objects are compared and stored.
    - `hashCode()` method:
      - The `hashCode()` method returns an integer that represents the hash code of an object. This integer is used to determine where to place the object in the hash-based collections.
      - Contract of `hashCode()`:
        1. Consistency: The `hashCode()` of an object should not change unless its state (used in equals()) changes.
        2. Equality: If two objects are equal as per equals(), they must have the same `hashCode()`.
        3. Unequal Objects: If two objects are not equal, they can have the same hashCode() (but different values are preferable to avoid collisions).
    - `equals()` Method: 
      - The equals() method is used to check if two objects are logically equivalent based on their state (not memory reference).
      - Contract of `equals()`:
        1. Reflexive: An object must be equal to itself (`a.equals(a)` should be true).
        2. Symmetric: If `a.equals(b)`is true, then `b.equals(a)` must be true.
        3. Transitive: If a.equals(b) is true and b.equals(c) is true, then a.equals(c) must also be true. 
        4. Consistent: If a.equals(b) is true, it should consistently return true unless the object’s state changes. 
        5. Non-nullity: a.equals(null) should always return false.