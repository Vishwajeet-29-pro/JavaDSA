### What Is map?
- The map function is an intermediate operation in the Stream API. 
- It is used to transform each element of a stream into another form.

Input: A stream of elements (e.g., Stream<T>).
Output: A stream of transformed elements (e.g., Stream<R>).

### When to Use map?
Use map when you need to:
- Transform data: Convert elements of one type to another.
- Extract specific fields: Work with a specific attribute of an object.
- Perform computations: Apply a transformation or computation to each element.
- Prepare data for downstream operations: Create data for further processing.

### How to Identify Problems That Need map?
Ask these questions:
- Do I need to change the type of data in the collection? 
  - Example: Convert a list of Strings to a list of their lengths.
- Do I need to modify or extract a property from objects? 
  - Example: Extract names from a list of Person objects.
- Do I need to create derived data from the original elements? 
  - Example: Square each number in a list.
