# Mockito - Quick Notes
Mockito is a popular Java framework for creating mock objects, primarily used in unit testing.

### Key Features:
1. **Mock Dependencies:** Simulates the behavior of classes without relying on real implementations.
2. **Verifies Interactions:** Checks if specific methods are called with correct arguments.
3. **Simplifies Testing:** Isolates the system under test by mocking external components.

### Annotations:
`@Mock`- Creates a mock object.
`@InjectMocks`- Injects mocks into the class under test.
`@Spy`- Partial mocking (real methods called unless stubbed)
`@Captor`- Captures arguments passed to methods.

### Common Methods:
1. Mocking:
    ```java 
        MyService service = Mockito.mock(MyService.class);
    ```
2. Stubbing:
    ```
        when(service.method()).thenReturn(value);
    ```
3. Verification:
    ```
        verify(service).method();
    ```
4. Exception Handling:
    ```
        when(service.method()).thenThrow(new RuntimeException());
    ```
5. Argument Matching:
   ``` 
        when(service.method(anyString())).thenReturn(value);
   ```