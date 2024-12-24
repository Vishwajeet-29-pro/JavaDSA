Create a custom exception
for that create a class with name that you want to throw as an exception and extend that class with RunTimeException
Create constructor for the same class and pass the message parameter and call the parent class constructor with super keyword.

here is example:
```java
public ProductNotFoundException extends RunTimeException {
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
```
and when we call this custom exception create new object of this class and pass message whatever you decided.
e.g.
```java
public String returnException(int i) {
	if(i > 0) {
		i = i+1;
	} else {
		throw new ProductNotFoundException("Value must be positive");
	}
}
```

Create a global exception handler to return the response to client from the controller layer
for need to create a new class and in that add @ControllerAdvice annotation and create a necessary method which returns ResponseEntity class type
also on the method that we created add annotation called @ExceptionHandler(value=YourCustomException.class)
this annotation is called the method whenever such kind of exception occur in our class. this exception will be called in Response of that controller method and return back to client.

Also create one data class i.e a class that stores the status code, response message and other required fields.

Call this class based on requirement and assign values to it, such product not found and status code for same is 404 etc.

here is example

```java
public class ApiError{
	int statusCode;
	int message;
	// other fields as per requirement
	// create constructor and getter and setter. if using lombok 
	// add necessary annotations.
}
```
Create a global exception class
```java
@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(value = NoProductFoundException.class)
	public ResponseEntity<ApiError> handleNoProductFoundException() {
		ApiError error = new ApiError(400, "No Product Found");

		return new ResponseEntity<ApiError>(error, HttpStatus.Not_Found);
	}
}
```

We have two annotation
@RestControllerAdvice : this is used for the REST apis and return the response bodies
@ControllerAdvice: This works for both web views and rest apis

