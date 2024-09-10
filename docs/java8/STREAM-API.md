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

### Terminal Operations:
Terminal Operations are the type of Operations that return the result. These Operations are not processed further just return a final result value.
###### Important Terminal Operations
There are a few Terminal Operations mentioned below:
1. `collect()` : The collect method is used to return the result of the intermediate operations performed on the stream.
   Syntax:
   ```
   <R, A> R collect(Collector<? super T, A, R> collector) 	
   ```
2. `forEach()`: The forEach method is used to iterate through every element of the stream.
   ```
   void forEach(Consumer<? super T> action)
	```
3. `reduce()`: The reduce method is used to reduce the elements of a stream to a single value. The reduce method takes a `BinaryOperator` as a parameter.
   ```
   T reduce(T identity, BinaryOperator<T> accumulator)
   Optional<T> reduce(BinaryOperator<T> accumulator)
	```
4. `count()`: Returns the count of element in the stream.
   `long count()`
5. `findFirst()`: Returns the first element of the stream, if present.
   `Optional<T> findFirst()`
6. `allMatch()`: Checks if all elements of the stream match a given predicate.
   `boolean allMatch(Predicate<? super T> predicate)`
7. `anyMatch()`: Checks if any element of the stream matches a given predicate.
   ```
   boolean anyMatch(Predicate<? super T> predicate)
   ```

### Important Points/Observation of Java Stream
1. A stream consists of a source followed by zero or more intermediate methods combined together (pipelined) and a terminal method to process the objects obtained from the source as per the methods described.
2. Stream is used to compute elements as per the pipelined methods without altering the original value of the object.

## Difference between `flatMap()` and `map()` in Java 8
In Java 8 streams, both map and flatmap are used to transform elements of a stream, but they differ in the way they handle transformations and deal with nested data structures.
1. `map()`: The `map()` function is used to transform each element of the stream individually. It applies a function to each element and returns a stream of transformed elements.
   It doesn't flatten or merge the structure of streams; it simply transforms one element to another.
   - Input: A stream of elements.
   - Output: A stream where each element is transformed based on the applied function.

   ###### Example:
   ```
   List<Integer> numbers = Arrays.asList(1,2 3,4,5);
   List<Integer> squares = numbers.stream()
                              .map(n -> n * n)
                              .collect(Collectors.toList());
   System.out.println(squares);
   ```
2. `flatMap()`: The `flatMap()` function is used when you have a stream of streams or a collection of conditions, and you want to "flatten" or merge the nested structure into a single stream.
   It first applies the transformation and then flatten the result into a single stream.
   - Input: A stream of streams or collections.
   - Output: A flattened stream of elements after applying the transformation.
   
   ###### Example:
   ```
   List<List<String>> nestedList = Arrays.asList(
      Arrays.asList("Java", "Python"),
      Arrays.asList("C++", "Go"),
      Arrays.asList("Kotlin", "Scala")
   );
   List<String> flatList = nestedList.stream()
                              .flatMap(List::stream)
                              .collect(Collectors.toList());
   System.out.println(flatList);
   ```
   
#### Key Differences:
| Feature        | map()                                            | flatMap()                                      |
|----------------|--------------------------------------------------|------------------------------------------------|
| Input          | A stream of elements                             | A stream of streams (or nested collections)    |
| Output         | A stream where each element is transformed       | A single flattened stream transformed elements |
| Transformation | Transform each element one by one                | Transform and flattens the result              |
| Use Case       | When you need to transform elements individually | When you need to flatten nested structures.    |

#### Why flatMap?
- `flatMap()` is useful when dealing with nested collections or Optional Objects. Instead of getting a stream of streams ( or Optionals of Optionals)
   it helps flatten them into a single, usable structure.
- It simplifies handling cases where the transformation results in a stream or collection and merging all the elements into a flat structure.

