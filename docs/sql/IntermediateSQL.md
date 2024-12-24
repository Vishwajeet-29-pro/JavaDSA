# Intermediate of SQL:

## JOINS

1. INNER JOIN
   An INNER JOIN retrieves records that have matching values in both tables. Only rows where the condition is satisfied in both tables are returned. 
    ```
        SELECT columns FROM table1
        INNER JOIN table2
        ON table1.column = table2.column; 
    ```
   Example:
   Let's say we have two tables: Employees and Departments:
    Employees Table:
 
    | EmployeeID | FirstName | DepartmentID |
    |------------|-----------|--------------|
    | 1          | Alice     | 101          |
    | 2          | Bob       | 102          |
    | 3          | Carol     | 103          |
    
    Departments Table:
   
    | DepartmentID | DepartmentName |
    |--------------|----------------|
    | 101          | HR             |
    | 102          | IT             |
    | 104          | Sales          |

    If we want to fetch the employee names along with their department names, where there is a match between DepartmentID in both tables:
    ```
     SELECT Employees.FirstName, Departments.DepartmentName
     FROM Employees 
     INNER JOIN Departments
     ON Employees.DepartmentID = Departments.DeparmentID; 
    ```
   **Result:**

    | FirstName | DepartmentName |
    |-----------|----------------|
    | Alice     | HR             |
    | Bob       | IT             |
    Here, only the rows with matching DepartmentID are returned (i.e. 101, and 102).

2. LEFT JOIN (or LEFT OUTER JOIN) 
    A LEFT JOIN returns all records from the left table and the matched records from the right table. If there is no match, the result is NULL on the side of the right table.
    Syntax:
   ```
    SELECT columns
    FROM table1
    LEFT JOIN table2
    ON table1.column = table2.column; 
   ```
   Example:
   ```
   SELECT Employees.FirstName, Departments.DepartmentName
   FROM Employees
   LEFT JOIN Departments
   ON Employees.DepartmentID = Departments.DepartmentID; 
   ```
   
    | FirstName | DepartmentName |
    |-----------|----------------|
    | Alice     | HR             | 
    | Bob       | IT             |
    | Carol     | NULL           |
    In this case, even through Carol does not belong to any existing department in the Departments table, her data is still returned with NULL in the DepartmentName field.

3. RIGHT JOIN (or RIGHT OUTER JOIN)
    A RIGHT JOIN is the opposite of a LEFT JOIN. It returns all records from the right table and the matched records from the left table. If there is no match, the result is NULL on the left side.
    Syntax:
    ``` 
        SELECT columns FROM table1 
        RIGHT JOIN table2
        ON table1.column = table2.column;
    ```
   Example:
    ```
    SELECT Employees.FirstName, Departments.DepartmentName
    FROM Employees
    RIGHT JOIN Departments
    ON Employees.DepartmentID = Departments.DepartmentID;
    ```
   
    Result:

   | FirstName | DepartmentName |
   |-----------|----------------|
   | Alice     | HR             | 
   | Bob       | IT             |
   | NULL      | Sales          |

    In this case, the department Sales (which does not have any employees in the Employees table) is still included, but with NULL in the FirstName field.

4. FULL OUTER JOIN:
    A FULL OUTER JOIN returns all records when there is a match in either left or right table. If there is no match, NULL values are returned for non-matching rows from either table.
    Syntax:
    ```
    SELECT columns FROM table1
    FULL OUTER JOIN table2
    ON table1.column = table2.column; 
    ```
   Example:
   ```
    SELECT Employees.FirstName, Departments.DepartmentName
    FROM Employees 
    FULL OUTER JOIN Departments
    ON Employees.DepartmentID = Departments.DepartmentID;
   ```
   Result:
   
   | FirstName | DepartmentName |
   |-----------|----------------|
   | Alice     | HR             |
   | Bob       | IT             |
   | Carol     | NULL           |
   | NULL      | Sales          |
    This query combines all data from both tables, returning NULL for non-matching rows from either table.

5. CROSS JOIN
    A CROSS JOIN returns the Cartesian product of the two tables, meaning that each row from the first table is combined with every row from the second table.
    Syntax:
   ```
    SELECT columns
    FROM table1
    CROSS JOIN table2;
   ```
   Example:
    ```
    SELECT Employees.FirstName, Departments.DepartmentName
    FROM Employees 
    CROSS JOIN Departments;
    ```
   Result:
    
    | FirstName | DepartmentName |
    |-----------|----------------|
    | Alice     | IT             |
    | Alice     | Sales          |
    | Alice     | HR             |
    | Bob       | IT             |
    | Bob       | Sales          |
    | Bob       | HR             |
    | Carol     | IT             |
    | Carol     | Sales          |
    | Carol     | HR             |

    This will return all possible combinations of Employees and Departments.

6. SELF JOIN:
    A SELF JOIN is when a table is joined with itself. This is typically used when you want to compare rows within the same table.
    Syntax:
   ```
    SELECT A.column1, B.column2
    FROM table_name A, table_name B 
    WHERE condition;
   ```
   Example: Lets say we have a table Employees with column ManagerID that refers to another employees (who is the manager). We want to fetch names of employees and their managers. 

   | EmployeeID | FirstName | ManagerID |
   |------------|-----------|-----------|
   | 1          | Alice     | NULL      |
   | 2          | Bob       | 1         |
   | 3          | Carol     | 2         |
     
    The query to find employees name along with their managers' names would be:
    ```
    SELECT E1.FirstName AS Employee, E2.FirstName AS Manager
    FROM Employees E1
    LEFT JOIN Employees E2
    ON E1.ManagerID = E2.EmployeeID;
    ```
    Result:
   
   | FirstName | DepartmentName |
   |-----------|----------------|
   | Alice     | NULL           |
   | Bob       | ALICE          |
   | Carol     | Bob            |

Here we're joining the Employees table with itself to match each employee with their manager based on ManagerID.

### Summary:
- INNER JOIN: Returns rows where there is a match in both tables.
- LEFT JOIN: Returns all rows from the left table, with matching rows from the right table or NULL if no match.
- RIGHT JOIN: Returns all rows from the right table, with matching rows from the left table or NULL if no match.
- FULL OUTER JOIN: Returns all rows from both tables, with NULL where there is no match.
- CROSS JOIN: Returns the Cartesian product of the two tables.
- SELF JOIN: Joins a table to itself to compare or relate rows within the same table.

## Aggregate Functions in SQL:
1. **Aggregate Functions:** Aggregate functions perform a calculation on a set of values and returns a single value. The common aggregate functions are `COUNT`, `SUM`, `AVG`, `MIN` and `MAX`.
    1. **COUNT:** The `COUNT` function returns the number of rows that match a specified condition.
        Syntax:
        ```
            SELECT COUNT(column)
            FROM table WHERE condition; 
        ```
       Example: If we want to count the number of employees in the Employees table:
       ``` 
          SELECT COUNT(Employees) FROM Employees;
       ```
       Result: `COUNT(EmployeesID)  3`

   2. **SUM**: The `SUM` function calculates the total sum of a numeric column. 
        Syntax:
        ``` 
            SELECT SUM(column)
            FROM table WHERE condition;
        ```
        Example: If we want to calculate the total salary of all employees:
        ```
            SELECT SUM(Salary) FROM Employees;
        ```
        Result:
        SUM(Salary)
        150000
   
   3. **AVG**: The AVG function returns the value of a numeric column.
        Syntax:
        ```  
            SELECT AVG(column) 
            FROM table WHERE condition;
        ```
        Example: To calculate the average salary of employees:
        ```
            SELECT AVG(Salary) FROM Employees;
        ```
        Result:
        AVG(Salary)
        50000

   4. **MIN**: The `MIN` function returns the smallest value from a specified column.
        Syntax:
        ``` 
            SELECT MIN(column)
            FROM table WHERE condition;
        ```
        Example: To find the lowest salary:
        ```
            SELECT MIN(Salary) FROM Employees;
        ```
        Result:
        MIN(Salary)
        30000
   
   5. **MAX**: The `MAX` function returns the largest value from a specified column.
        Syntax:
        ``` 
            SELECT MAX(column)
            FROM table
            WHERE condition;
        ```
        Example: To find the highest salary:
        ```
            SELECT MAX(Salary) FROM Employees;
        ```
        Result:
        MAX(Salary)
        70000

2. **Grouping Data Using `GROUP BY`**
    The `GROUP BY` clause is used to group rows that have the same values in specified columns into summary rows, like grouping by department or age, then applying aggregate functions.
    Syntax:
   ``` 
        SELECT column, AGGREGATE_FUNCTION(column) 
        FROM table
        WHERE condition
        GROUP BY column;
   ```
   Example: If we want to calculate the total salary for each department:
   ``` 
        SELECT DepartmentID, SUM(Salary) AS TotalSalary 
        FROM Employees GROUP BY DepartmentID;
   ```
   Result:
   
     | DepartmentID | TotalSalary   |
     |--------------|---------------|
     | 101          | 90000         |
     | 102          | 60000         |
    
   This query groups employees by their DepartmentID and calculates the total salary for each department.

3. **Filtering Grouped Data Using `HAVING`**:
    The `HAVING` clause is used to filter data after the GROUP BY operation, similar to the WHERE clause but for aggregated data.
    Syntax:
   ``` 
    SELECT column, AGGREGATE_FUNCTION(column)
    FROM table
    WHERE condition
    GROUP BY column
    HAVING AGGREGATE_FUNCTION(column) condition;
   ```
    Example:
    ``` 
        SELECT DepartmentID, SUM(Salary) AS TotalSalary 
        FROM Employees
        GROUP BY DepartmentID
        HAVING SUM(Salary) > 50000;
   ```
    Result: 

   | DepartmentID | TotalSalary |
   |--------------|-------------|
   | 101          | 90000       |
    The `HAVING` clause filters out the groups with total salaries less than or equal to 50000.

    ### Summary:
    - COUNT, SUM, AVG, MIN, MAX: Aggregate functions that performs calculation on a set of values.
    - GROUP BY: Used to group rows that have the same values in specified columns and then aggregate the data.
    - HAVING: Filters the result of the GROUP BY base on the aggregate results.

## Subqueries
A subquery (also known as an inner query) is a query nested inside antoher query (outer query). They are used to return data that will be used in the outer query.

**Type of Subqueries:**
1. **Inline (Correlated) Subqueries:** Subqueries that depend on the outer query for their values.
2. **Independent (Non-correlated) Subqueries:** Subqueries that can be executed independently and are not dependent on the outer query.
    
   1. **Inline (Correlated) Subqueries:** 
        A correlated subquery is evaluated once for each row processed by the outer query. It refers to columns from the outer query, making it "correlated" or dependent on the outer query.
        Syntax:
        ``` 
            SELECT column 
            FROM table_outer t1
            WHERE t1.column > (SELECT AVG(column) FROM table_inner t2 WHERE t2.related_column = t1.related_column);
        ```
        Example: Let's assume we have two tables: Employees and Departments. If you want to find employees whose salary is higher than the average salary in their department:
        ``` 
            SELECT EmployeeID, Name, Salary
            FROM Employee e
            WHERE Salary > (SELECT AVG(Salary) FROM Employees WHERE DepartmentID = e.DepartmentID);
        ```
        In this example, the subquery calculates the average salary for each department, and the outer query compares each employee's salary to the department's average.

   2. **Independent (Non-Correlated) Subqueries:** 
        An independent subquery (non-correlated) can run on its own and does not rely on the outer query. It is executed first, and its result is passed to the outer query.
        Syntax:
        ``` 
            SELECT column
            FROM table
            WHERE column = (SELECT single_column FROM table WHERE condition);
        ```
        Example: To find all employees working in the same department as employees with `EmployeeID = 1`:
        ``` 
            SELECT NAME
            FROM Employees
            WHERE DepartmentID = (SELECT DepartmentID FROM Employees WHERE DepartmentID = 1);
        ```
        In this example, the subquery retrieves the DepartmentID of employee 1 and the outer query fetches the name of all employees in that department.

## IN, EXISTS, ANY, and ALL Operators:
These operators are used to perform comparisons between a column and a set of values from a subquery.

1. **IN Operator:** The `IN` operator is used to check if a value exists in a list of values returned by the subquery.
    Syntax:
   ``` 
    SELECT column
    FROM table
    WHERE column IN (SELECT column FROM another_table WHERE condition);
   ```
   Example:
   Find all employees who work in the department located in New York:
    ``` 
        SELECT Name
        FROM Employees
        WHERE DepartmentID IN (SELECT DepartmentID FROM Departments WHERE Location = `New York`);
    ```
   Here, the subquery returns the DepartmentID of departments in New York, and the outer query fetches employees in those departments.

2. **EXISTS Operator**
    The EXISTS operator returns `TRUE` if the subquery returns any rows. It's used to test for the existence of rows in a subquery.
    Syntax:   
    ```
        SELECT column
        FROM table
        WHERE EXISTS (SELECT 1 FROM another_table WHERE condition);
    ```
    Example:
    ```
        SELECT Name
        FROM Employees e
        WHERE EXISTS (SELECT 1 FROM Departments d WHERE e.DepartmentID = d.DepartmentID AND d.Budget > 1000000);
    ```
    In this case, the subquery checks if there is a department with a budget over 1 million, and the outer query retrieves the employees in those departments.

3. **ANY Operator:** 
    The `ANY` operator compares a value to any value in a set of values returned by the subquery. It means "if the condition is true for any of the values."
    Syntax:
   ``` 
    SELECT column FROM table
    WHERE column > ANY (SELECT column FROM another_table WHERE condition);
   ```

    Example:
    Find all the employees who earn more than any employee in department 2:
    ```
        SELECT name
        FROM Employees
        WHERE Salary > ANY (SELECT Salary FROM Employees WHERE DepartmentID = 2);
    ```
    This query compares each employee's salary to the salary of any employee in department 2. It returns employees who earn more than 
    at least one employee in that department.

4. **ALL Operator:**
    The ALL Operator compares a value to all values in the result set returned by the subquery. It means "if the condition is true for all values."
    Syntax: 
    ``` 
        SELECT column
        FROM table
        WHERE column > ALL (SELECT column FROM another_side WHERE condition);
    ```
    Example:
    Find employees who earn more than all employees in department 2:
    ```
        SELECT Name
        FROM Employees
        WHERE Salary > ALL (SELECT Salary FROM Employees WHERE DepartmentID = 2);
    ```
    Here, the query returns employees whose salary is greater than every employee in department 2.

    ### Summary of Concepts:
   - Inline (Correlated) Subquery: Subquery depends on the outer query.
   - Independent Subquery: Subquery can run independently of the outer query.
   - IN: Checks if a value matches any value in a list or subquery result.
   - EXISTS: Return TRUE if the subquery returns any rows.
   - ANY: Compares a value to any value returned by the subquery.
   - ALL: Compares a value to all values returned by the subquery.

## String Functions:
1. **CONCAT Function:**
    The CONCAT function is used to combine two or more strings into a single string.
    Syntax:
    ```
        CONCAT(string1, string2, ...);
    ```
    Example:
    ``` SELECT CONCAT('Hello', 'World') AS Greeting; ```
    Output:
    ```
        Greeting 
        ---------
        Hello World
    ```
    You can also concatenate values from columns:
   ``` SELECT CONCAT(FirstName, ' ',LastName) AS FullName FROM Employees; ```
    This query combines the first name and last name of employees into a single FullName.

2. **UPPER Function:**
    The UPPER function converts all characters in a String to uppercase.
    Syntax:
    ``` UPPPER(string) ```
    Example:
    ``` SELECT UPPER('hello world') AS UpperCase; ```
    Output:
    ``` 
        UpperCase
        ---------
        HELLO WORLD
    ```
    You can use it to convert column values:
    ``` SELECT UPPER(FirstName) AS UppperCaseName FROM Employees; ```

3. **LOWER Function**
    The LOWER function converts all characters in a String to lowercase. 
    Syntax: 
    ``` LOWER(string) ```
    Example:
    ``` SELECT LOWER('HELLO WORLD')  AS LowerCase; ```
    Output:
    ```
        LowerCase
        ---------
        hello world
    ```
   You can use this function in real scenarios where data might not follow proper casing conventions.

4. **SUBSTRING Function**
    The SUBSTRING function extracts a portion of a string starting from a specific position, optionally taking a length of characters to extract.
    Syntax:
    ``` SUBSTRING(string, start_position, length) ```
    - start_position: The position from where to start (1-based index).
    - length: The number of characters to extract.
    
    Example:
    ``` SELECT SUBSTRING('Hello World', 1, 5) AS SubString; ```
    
    Output:
    ``` 
        SubString
        ---------
        Hello
    ```
    You can use it to extract part of a column value:
    ``` SELECT SUBSTRING(FirstName, 1, 3) AS ShortName FROM Employees; ```
    This Query extracts the first three characters of the FirstName.

5. **TRIM Function:** 
    The TRIM Function removes leading and trailing spaces from a string.
    Syntax:
    ``` TRIM([LEADING | TRAILING | BOTH] FROM string); ```

    - LEADING: Removes leading (left-side) spaces.
    - TRAILING: Removes trailing (right-side) spaces.
    - BOTH: Removes both leading and trailing spaces (default behavior).
    
    Example:
    ``` SELECT TRIM(  'Hello World  ') AS TrimmedString; ```
    Output:
    ```
    TrimmedString
    -------------
    Hello World
    ```
    You can also removes spaces from column values:
    ``` SELECT TRIM(FirstName) AS TrimmedName FROM Employees; ```

6. **LIKE Operator:** 
    The LIKE operator is used to search for a specified pattern in a string. It's commonly used with % (to match zero or more charters) and _ (to match exactly one character).
    
    Syntax:
    ```
    SELECT column
    FROM table
    WHERE column LIKE pattern;
    ```
    **Example 1: Matching pattern:** Find all employees whose name start with the letter 'A':
    ```
    SELECT Name
    FROM Employees
    WHERE Name LIKE 'A%';
    ```
    This query returns names that start with the letter "A".

    **Example 2: Using an underscore to match one character:**
    ```
    SELECT Name 
    FROM Employees
    WHERE Name LIKE 'J_n%';
    ```
    This will match names like "Jon", "Jen", etc., where the second letter is "n".
    
    **Example 3: Combining with NOT LIKE**
    Find employees whose names don't start with 'S':
    ``` 
        SELECT Name
        FROM Employees
        WHERE Name NOT LIKE 's%';
    ```

## DATE and Time Functions
1. Working with DATE, TIME and TIMESTAMP
    - DATE: Represents only the date in `YYYY-MM-DD` format.
    - TIME: Represents in the time in `HH:MI:SS` format.
    - TIMESTAMP: Represents both date and time (`YYYY-MM-DD HH:MI:SS`)

    Example:
    Creating a table with DATE, TIME and TIMESTAMP fields:
    ```
    CREATE TABLE EventDetails(
        EventName VARCHAR(50),
        EventDate DATE,
        EventTime TIME,
        EventTimeStamp TIMESTAMP
    );
    ```
    Inserting Data:
    ```
    INSERT INTO EventDetails (EventName, EventDate, EventTime, EventTimestamp)
    VALUES ('Conference', '2024-10-03', '14:30:00', '2024-10-03 14:30:00');
    ```
    Querying Data:
    ``` 
     SELECT EventName, EventDate, EventTime, EventTimestamp FROM EventDetails;
    ```
    This query will return:
    ```
    EventTime   EventDate   EventTime EventTimeStamp
    ------------------------------------------------
    Conference  2024-10-03  14:30:00    2024-10-03 14:30:00
    ```
   
2. `NOW()` Function: The `NOW()` function returns the current date and time as a TIMESTAMP.
    Example:
    ``` SELECT NOW() AS CurrentDateTime; ```
    Output:
    ```
    CurrentDateTime
    ---------------
    2024-10-03 10:45:23
    ```
3. `CURRENT_DATE` Function
    The `CURRENT_DATE` function returns the current date.
    Example:
    ``` SELECT CURRENT_DATE AS TodayDate; ```
    Output:
   ```
     TodayDate
    -----------
      2024-10-03
   ```
   
4. `DATEADD()` Function
    The `DATEADD()` function is used to add a specific interval (like days, months, years) to a date. It's available in MySQL as `DATE_ADD()`
    and in PostgreSQL as `+ INTERVAL`.

    MySQL Syntax:
    ``` SELECT DATE_ADD('2024-10-03', INTERVAL 10 DAY) AS NewDate; ```

    PostgreSQL Syntax:
    ``` SELECT '2024-10-03' ::DATE + INTERVAL '10 days' AS NewDate; ```

    Output:
    ``` 
    NewDate
    -------
    2024-10-13
    ```
    You can also add months, years, etc., by changing the INTERVAL type:
    ``` SELECT DATE_ADD('2024-10-03', INTERVAL 2 MONTH) AS NewDate; ```
    or
    ``` SELECT '2024-10-03'::DATE + INTERVAL '2 months' AS NewDate; ```

5. `DATEDIFF()` Function:
    The `DATEDIFF()` function calculates the difference between two dates, returning the number of days between them.
    MySQL Syntax:
    ``` SELECT DATEDIFF('2024-12-25', '2024-10-03') AS DaysDifference; ```

    PostgreSQL Alternative:
    ``` SELECT EXTRACT(DAY FROM '2024-12-25'::DATE - '2024-10-03'::DATE) AS DaysDifference; ```

    Output:
    ```
    DaysDiffernce
    -------------
        83
    ```
    This function is useful when you want to calculate age, duration of events, or time differences between dates.

### Summary of Key Date and Time Functions:
- `NOW()`: Returns the current timestamp (date and time).
- `CURRENT_DATE`: Returns today's date.
- `DATEADD()` (MySQL) / `+ INTERVAL` (PostgreSQL): Adds a specified time interval to a date.
- `DATEDIFF()`: Calculates the difference between two dates in days.





## Indexing
### 1. Basics of Creating and Using Indexes
An index in SQL is a database object that speeds up the retrieval of rows by creating a quick lookup mechanism for specific columns in a table.
Indexes are created based on one or more columns of a table, and they function like an index in book, helping to locate data faster.

**Creating an Index:**
To crate an index on a column, you use the `CREATE INDEX` statement. You can create different types of indexes, such as single-column, multi-column, or unique indexes.

Syntax:
``` CREATE INDEX index_name ON table_name (column1, column2, ...);```

Example 1: Single-column Index
``` CREATE INDEX idx_employee_name ON Employees (LastName); ```

This creates an index on the LastName column of the Employees table. The database will use this index to quickly find rows where LastName
is queried, e.g., in SELECT statement.

Example 2: Multi-column Index:
``` CREATE INDEX idx_employee_fullname ON Employees (FirstName, LastName); ```

A multi-column index helps optimize queries that search on both FirstName and LastName. It improves performance in queries where both columns are used in the 
WHERE clause or ORDER BY.

**Using an Index:**
Once an index is created, the database automatically decides when to use it during queries, like:
``` SELCT * FROM Employees WHERE LastName = 'Smith'; ```

If LastName is indexed, the database will refer to the index instead of scanning the entire table, leading to faster retrieval.

### 2. Performance Impact of Indexes:
While indexes can significantly improve query performance, they come with trade-offs. Let's break down both the positive and negative impacts:
**Positive Impact of Indexes:**
- Fast Query Performance: Indexes allow the database to find rows faster, especially for large datasets. Queries that filter or sort by the index 
    column(s) are much quicker because the database doesn't have to perform a full table scan.
    For example, without an index:
    ``` SELECT * FROM Orders WHERE CustomerID = 12345; ```
  If there's no index on CustomerID, the database will scan the entire Orders table. With an index on CustomerID, it directly jumps to the relevant rows, improving performance.
- Optimizing JOIN Queries: Indexes are beneficial in queries that involve joins between multiple tables. For instance, if you have two tables Orders and Customers, having an index on the
    CustomerID column in both tables speeds up join operations:
    ``` 
        SELECT * FROM Orders O
        JOIN Customers C ON O.CustomerID = C.CustomerID; 
    ```
- Better Sorting: Indexes help in sorting data efficiently when using ORDER BY in queries. For example:
    ``` SELCT *  FROM Employees ORDER BY LastName; ```

**Negative Impact of Indexes:**
- Slower Data Modification (INSERT, UPDATE, DELETE): While indexes make reading data faster, they slow down data modification operations (like INSERT, UPDATE, DELETE) because the index needs to be updated every time the data in the table is modified.

    For example:
    ``` INSERT INTO Orders (CustomerID, OrderDate) VALEUES (12345, '2024-10-03'); ```

    If there is an index on CustomerID, this INSERT will also update the index, adding extra overhead.

- Storage Overhead: Indexes consumes disk space, especially for large tables with multiple columns indexed. The more indexes a table has, the more space is needed to store them.
- Choosing the Right Indexes: Creating too many indexes can hurt performance due to the overhead of maintaining them. It's important to strategically index columns based on usage pattern in queries.

#### When to Use Indexes:
Indexes should be used:
- On columns that are frequently queried (e.g., in WHERE or JOIN clauses).
- On columns involved in sorting (ORDER BY) or grouping (GROUP BY).
- For large tables where performance gains from indexing outweigh the maintenance cost.

#### When Not to Use Indexes:
- On Small tables (full table scans may be fast enough).
- On columns with a small range of values (e.g., boolean columns).
- If the table undergoes frequently inserts/updates, as it can slow down these operations.

#### Best Practices for Indexing:
1. Index Selective Columns: Choose columns with a wide range of distinct values (e.g., CustomerID or Email)
2. Avoid Over-Indexing: More indexes don't necessarily mean better performance. Each index requires maintenance during write operations.
3. Use Composite Indexes Wisely: Composite (multi-column) indexes can be beneficial, but they should be designed based on query patterns. For example, an index on (LastName, FirstName)
    is useful only if queries involve both columns.
4. Monitor Index Usage: Use tool like EXPLAIN (in MySQL) or EXPLAIN ANALYZE (in PostgreSQL) to understand how indexes are used in your queries.

#### Example: Monitoring Index Usage with EXPLAIN
You can use the EXPLAIN command to see if the database is using an index in your query:
``` EXPLAIN SELECT * Employees WHERE LastName = 'Smith'; ```

The output will show if the query is using an index or performing a full table scan.


