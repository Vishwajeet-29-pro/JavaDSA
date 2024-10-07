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

