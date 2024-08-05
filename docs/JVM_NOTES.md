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

