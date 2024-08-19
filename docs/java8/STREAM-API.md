**Stream API**:  Stream API is used to process collection of objects. A stream in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result.

Use of Stream in Java:
```
The uses of Stream in Java are mentioned below:
1. Stream API is a way to express and process collections of objects.
2. Enable us to perform operations like filtering, mapping, reducing and sorting.
```

##### How to Create Java Stream?
Java Stream Creation is one of the most basic steps before considering the functionalities of the Java Stream. Below is the syntax given for declaring Java Stream.
Syntax:
`Stream<T> stream`;
Here T is either a class, object, or data type depending upon the declaration.

### Java Stream Features
The features of Java stream are mentioned below:
- A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
- Streams don't change the original data structure, they only provide the result as per the pipelined methods.
- Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined.
  Terminal operations mark the end of the stream and return the result.

### Different Operations On Streams:
There are two types of Operations in Streams:
1. Intermediate Operations
2. Terminate Operations
### Intermediate Operations
Intermediate Operations are the types of operations in which multiple methods are chained in a row.
**Characteristics of Intermediate Operations*
- Methods are chained together.
- Intermediate operations transform a stream into another stream.
- It enables the concept of filtering where one method filters data and passes it to another method after processing.

**Benefits of Java Stream**
There are some benefits because of which we use Stream in Java as mentioned below:
- No Storage
- Pipeline of Functions
- Laziness
- Can be infinite
- Can be parallelized
- Can be created from collections, arrays, Files Lines, Methods in Stream, IntStream etc.

#### Important Intermediate Operations:
There are a few Intermediate Operations mentioned below:
1. `map()` : The map method us used to return a stream consisting of the results of applying the given function to the elements of this stream.
   Syntax:
   `<R> Stream<R> map(Function<? super T, ? extends R> mapper)`

2. `filter()` The filter method is used to select elements as per the Predicate passed as an argument.
   Syntax:
   `Stream<T> filter(Predicate<? super T> predicate)`
3. `sorted()` The sorted method is used to sort the stream.

    ```
        Stream<T> sorted()
        Stream<T> sorted(Comparator<? super T> comparator)
    ```
4. `flatMap()` The flatMap operation in Java Streams is used to flatten a stream of collections into a single stream of elements.
    ```
    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
    ```
5. `distinct()` : Removes duplicate elements. It returns a stream consisting of the distinct elements (according to `Object.equals(Object)`).
   `Stream<T> distinct()`
6. `peek()`: perform an action on each element without modifying the stream. It returns a stream consisting of the elements of this stream, additionally performing the provided action on each elements as elements are consumed from the resulting stream.
   `Stream<T> peek(Consumer<? super T> action)`