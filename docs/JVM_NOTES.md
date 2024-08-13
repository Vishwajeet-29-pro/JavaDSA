- What is JVM?
- How JVM works?
- How we can optimize it?
- How garbage collector works?
- How to write code so that performance of JVM should be at peak?

### What is JVM? ->
- JVM  stands for Java Virtual Machine.
- It is an integral part of JRE (Java Runtime Environment) and that enables the java program run on any machine or Operating System without being rewritten.
- It interprets the compiled java bytecode and convert into machine code that the host system can execute.
- This allows java to be platform-independent, meaning that code written on one machine can execute\run on other machine that has a JVM installed.
- It manages systems memory and provides security and performance optimization features.

![JVM](https://media.geeksforgeeks.org/wp-content/uploads/20240401182730/JVM-768.png)

### How JVM works?
- The Java virtual machine is a sophisticated component that allows java program to run on any devices with JVM installed. It abstracts the underlying hardware and operating system details, providing a consistent runtime environment.
    - Start up: When a Java application starts, the JVM invoked and it initializes the necessary runtime environment.
    - Loading: The class loader loads the required file from the file system or network and prepare them for execution.
    - Verification: The JVM verifies the bytecode to ensure it adheres to the Java language specifications and doesn't violets any security constraints.
    - Execution:
        - The execution engine execute the bytecode. The interpreter processes bytecode instructions one at a time, while Just in time compiler (JIT) optimizes the performance by compiling the frequently executed code into native machine code.
        - The JVM uses the stack and heap for method invocation and memory allocation. Each method call creates a new stack frame on the call stack, and objects are allocated in the heap.
    - Garbage Collector: The garbage collector automatically deallocates the memory used by unreachable objects, optimizing memory usages and  preventing memory leaks.
    - Shutdown: When the program terminates, the JVM performs the necessary clean up and shuts down.

### How we can optimize it?
Optimizing the Java Virtual Machine involves tuning various parameters and employing best practices to enhance performance, reduce memory usage, and improve the overall efficiency of java applications.
1. Optimize Memory Allocation:
    - Heap size: Adjust the initial (`-Xms`) and maximum (`-Xmx`) heap sizes to balance between memory usage and garbage collection performance. Avoid frequent resizing by setting these parameters appropriately based on application needs.
    - Garbage Collection: Choose the right garbage collector for you application:
        - G1 Garbage Collector: Suitable for applications with large heaps that requires predictable pause times.
        - ZGC (Z Garbage Collector): Designed for low latency and large heaps.
        - Shenandoah GC: Similar to ZGC, focuses on reducing pause times in large heaps.
        - Parallel GC: Good for throughput-focused applications with short pauses.
        - CMS (Concurrent Mark-Sweep) GC: Suitable for applications with many short-lived objects but can cause fragmentation issues (deprecated in recent Java versions).
    - Eden Space Size: Adjust the size of the Eden space in Young Generation (`XX:NewSize`, `XX:MaxNewSize`) to optimize object allocation and reduce minor garbage collection pauses.
2. Optimize Garbage Collection
    - GC Tuning: Use JVM flags to tune the garbage collector according to your applications needs.
      for example:
        - `-XX:+UseG1GC` to enable the G1 garbage collector.
        - `XX:MaxGPauseMillis=<time>` to set a target for maximum GC pause time.
        - `-XX:+UseStringDeduplication` to reduce memory usage for duplicate strings.
    - Reduce Object Creation: Minimize unnecessary object creation, especially in loops and frequently called methods. Consider using object pools or reuse existing garbage collection overhead.
3. Optimize Code Execution:
    - JIT Compiler: Enable or fine-tune the Just-In-Time compiler settings for better performance:
        - `-XX:CompileThreshold=<invocation count>` : Adjust the number of method invocations before compilation by JIT.
        - `-XX:+AggressiveOpts)`: Enable aggressive optimizations that might improve performance.
    - Avoid Reflection: Reflection can be slow and can lead to security issues. Use direct method call whenever possible.
    - profit and Benchmark: Use profiling tools like JProfiler, VisualVM, or YourKit to identify performance bottlenecks. Measure performance using benchmarking frameworks like JMH to understand the impact of optimizations.
4. Optimize Class Loading:
    - Class Loading Caching: Use class loader caching mechanisms to avoid redundant class loading and reduce startup time.
    - Remove Unused Classes: Remove unused classes and dependencies to reduce memory footprint and improve startup time.

### Garbage Collection in JAVA [Garbage collection](https://newrelic.com/blog/best-practices/java-garbage-collection)
Garbage collection is a key feature for developers who build and compile Java programs on a Java Virtual Machine, or JVM. Java objects are created on the heap, which is a section of memory dedicated to a program. When objects are no longer needed, the garbage collector finds and tracks these unused objects and deletes them to free up the space. Without garbage collection, the heap would eventually run out of memory, leading to a runtime OutOfMemoryError.

Java garbage collection helps your Java environments and applications perform more efficiently. However, you can still potentially run into issues with automatic garbage collection, including poor application performance. While you can't manually override automatic garbage collection, these are things you can do to optimize garbage collection in your application environment, such as changing the garbage collector you use, removing all references to unused Java objects, and using an application monitoring tool to optimize performance and detects issues as soon as they arise.

#### The basics of Java garbage collection
Garbage collection in java is the automated process of deleting code that's no longer needed or used. This automatically frees up memory space and ideally makes coding Java apps easier for developers.

Java applications are complied into bytecode that may be executed by a JVM. Objects are produced on the heap ( the memory space used for dynamic allocation), which are then monitored and tracked by garbage collection operations. Most objects used in Java code are short-lived and can be reclaimed shortly after they are created. The garbage collector uses a mark-and-sweep algorithm to mark all unreachable objects as garbage collection, then scans through live objects to find objects that are still reachable.

Automatic garbage collection means you don't have control over whether and when objects are deleted. This is in contrast to languages C and C++, where garbage collection is handled manually. However, automatic garbage collection is popular for good reason - manual memory management is cumbersome and slows down the pace of application development.

#### How does garbage collection works in Java?
During the garbage collection process, the collector scans different parts of the heap, looking for objects that are no longer in use. If an object no longer has any references to it from elsewhere in the application, the collector removes the object freeing up memory in the heap. This process continues until all unused objects successfully reclaimed.

Sometimes, a developer will inadvertently write code that continues to be referenced even through it's no longer being used. The garbage collector will remove objects that are being referenced in this way, leading to memory leaks. After memory leaks are created, it can be hard to detects the cause, so it's important to prevent memory leaks by ensuring that there are no references to unused objects.

To ensure that garbage collectors work efficiently, the JVM separates the heap into separate spaces, and then garbage collectors use a mark-and-sweep algorithm to traverse these spaces and clear out unused objects. 

## How to write code so that performance of JVM should be at peak?
1. Avoid Writing Long Methods:
   In Java, a long method is a method that contains a large number of lines of code, making it more difficult to read, maintain, and test. Long methods can be a performance bottleneck, as they can be difficult to optimize and can lead to poor application performance.<br>
   To avoid writing long methods in Java, developers should follow the Single Responsibility principal, which states that each method should have a single responsibility and focus on a specific task or functionality. Additionally, developers can user refactoring techniques to break down long methods into smaller, more manageable chunks, such as by extracting methods or creating new classes. <br><br>

2. Use Caching:
   Caching is a technique that can be used to improve performance by storing frequently accessed data in memory. This can help to reduce the number of times that the data needs to be read from disk or database, which can significantly improve performance. In Java, caching can be implemented using various frameworks such as Ehcache, Hazelcast or Caffeine. <br><br>

3. Leverage StringBuilder:
   StringBuilder is a class in Java that allows developers to manipulate strings easily. It is used to create mutable string objects, which can be modified without creating new string objects. Java developers can use StringBuilder to make string concatenation easier by appending new strings to existing StringBuilder object instead of creating new string objects each time a concatenation 
   operation is performed. This can improve performance and reduce memory usage. <br><br>

4. Optimize If-Else Statements
   If-else statements can affect Java performance because they require the JVM to evaluate each condition sequentially, which can slow down the execution of the code. To optimize the use of if-else statements, developers should try to use simpler conditions first and use short-circuit evaluation when possible. <br>
   Additionally, we can leverage switch statements instead of long chains of if-else statements to improve performance. Switch statements allows the JVM to jump directly to the relevant code block, rather than evaluating each condition sequentially, which can be faster for certain use cases. <br><br>

5. Don't Over-optimize
   Over-optimization of Java performance can lead to code that is difficult to maintain and modify, which can hinder future development efforts. To avoid over-optimization, developers should focus on optimizing critical sections of the code and avoiding premature optimization. By optimizing only as needed, developers can keep code clean and maintainable while still achieving good performance. <br>
   It's also important to avoid over-engineering solutions to performance problems, which ca lead to unnecessary complexity. Developers should start by profiling the application to identify bottlenecks, and then make incremental improvements to address those bottlenecks.<br><br>

6. Use Java Profilers
   Java profilers are tools that can be used to measure the performance of Java code. They can help to identify performance bottlenecks and provide insights into how to optimize performance. <br>
   For example, Granulate's continuous profiler is a free and open source Java profiler with an always-on approach. It samples the CPU, allowing you to investigate performance at any given time to see the impact of version releases, understand the performance impact of new features, compare deployments and isolate performance issues. <br>
   By Continuously analyzing code performance across your entire environment, you can optimize the most resource-consuming parts of your code, improve application performance and reduce costs. <br><br>

### What is JIT?
The Just-In-Time complier is a component of the runtime environment that improves the performance of Java applications by compiling bytecodes to native machine code at runtime.

Java programs consists of classes, which contain platform-neutral bytecodes that can be interpreted by a JVM on many different computer architectures. At run time, the JVM loads the class files, determines the semantics of each individual bytecode, and performs the appropriate computation. The additional processor and memory usage during interpretation means that a Java application performs more slowly than a native application. The JIT compiler helps improve the performance of Java program by compiling bytecodes into native machine code at run time.

The JIT compiler is enabled by default. When a method has been compiled, the JMV calls the compiled code of that method directly instead of interpreting it. Theoretically, if compilation did not require processor time and memory usage, compiling every method could allow the speed of the Java program to match that of a native application.

JIT compilation does require processor time and memory usage. When the JVM first starts up, thousands of methods are called. Compiling all of these methods can significantly affect startup time, even if the program eventually achieves very good peak performance.

In practice, methods are not compiled the first time they are called. For each method, the JVM maintains an invocation count, which starts at a predefined compilation threshold value and is decremented every time the method is called. When the invocation count reaches zero, a just-in-time compilation for the method is triggered. Therefore, often-used methods are compiled much later, or not at all. The JIT compilation threshold helps the JVM start quickly and still have improved performance. The threshold helps the JVM start quickly and still have improved performance. The threshold value was selected to obtain an optimal balance between startup times and long-term performance. 

## Frequently asked questions about the JIT compiler.
1. Can I disable the JIT compiler?
   Yes. The JIT compiler is turned on by default, but you can turn it off with the appropriate command-line parameter. [Disabling JIT](https://www.ibm.com/docs/en/SSYKE2_8.0.0/com.ibm.java.vm.80.doc/docs/jit_pd_disable.html#jit_pd_disable)
2. Can I use another vendor's JIT compiler?
   No.
3. Can I use any version of the JIT compiler with the JVM?
   No. The two are tightly coupled. You must use the version of the JIT compiler that comes with the JVM package that you use.
4. Can the JIT compiler decompile methods?
   Typically, The JIT compiler does not decompile methods. However, in rare instances the JIT compiler is forced to decompile a method. Such instances arise when the JIT compiler applies speculative optimizations based on compile-time assumptions, the assumptions are later violated, and JIT is then unable to recompile the method. Due to implementation restrictions, such methods remain interpreted until the end of the application.
5. Can I dynamically control the JIT compiler?
   No. You can pass options to the JIT compiler to modify the behavior, but only at JVM startup time, because the JIT compiler is started up at the same time as the JVM. However, a Java program can use the `java.lang.Compiler` API to enable and disable the JIT compiler at run time.
