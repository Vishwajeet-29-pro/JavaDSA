# FILTER
- What is filter?
  - Filter is a Stream API method used to select elements from a stream that match a given predicate.
  - It reduces the number of elements in a stream based on a condition.

## Key Points:
1. Returns a Stream:
   - The output is a filtered stream containing elements that satisfy the condition.
2. Uses Predicate: 
    - Accept a `Predicate<T>` (a functional interface with a single `test` method that returns `true` or `false`).
3. Does Not Modify the Original Collection: 
    - Work on a stream; the original data remains unchanged.
4. Intermediate Operation:
    - Can be chained with other operations like `map`, `collect`, etc.

### Syntax: 
```java
    Stream<T> filter(Predicate<? super T> predicate);
```

### Use Cases:
1. Filter elements based on a condition:
    - Example: Find all adults in a list of people.
2. Remove unwanted data:
    - Example: Exclude null or empty strings.
3. Search for matching elements:
    - Example: Filter products with prices greater than a threshold.

### Common Errors:
1. Using `filter` with `null` predicates:
   - Ensure the predicate is not null.
2. Confusion with `map`:
    - Use `filter` for selection and `map` for transformation.
3. Not collecting the filtered stream:
   - Streams are lazy;apply a terminal operation like collect.

### Best Practices
- Use meaningful predicates:
  - Write clear and concise lambda expressions.
- Combine with other Stream methods:
  - Example: Use `filter` with `map` or `reduce` for more complex processing.
- Avoid side effects:
  - Keep the lambda expression pure(no modifying external variables).

### When to Use `filter`
1. When you need to reduce data by applying conditions.
2. When you want to find elements that match specific criteria.

