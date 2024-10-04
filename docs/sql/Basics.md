# SQL Revision in short

## Basics of SQL:
### Introduction to Database and SQL
What is a Database?
A database is an organized collection of data, structured in a way that allows for easy access, management, and updating. It's essentially a digital repository that stores information in tables, which are made up of rows and columns (similar to spreadsheets).
#### **Key Terms in Databases:**
- Table: A set of data organized in rows and columns. Each table in a database typically represents an entity. (e.g., `Customers`, `Orders`).
- Row (Record): A single entry in a table. For example, in a `Customer` table, each row might represent a different customer.
- Column (Field): A vertical set of data in a table. Each column represents a specific attribute. (e.g., `Name`, `Age`, `Email`)
- Schema: The structure of the database, including tables, columns, and the relationships between them.
#### **Database Management System (DBMS):**
A DBMS is software that interacts with the database, enabling users to create, read, update, and delete data. There are two main types of DBMS:
1. **Relational DBMS (RDBMS):** Databases where data is stored in tables with predefined schemas and relationships between them. Popular examples are MySQL, PostgreSQL, and SQLite.
2. **NoSQL:** Databases designed for unstructured or semi-structured data, focusing on performance and scalability. Examples include MonogoDB and Cassandra.
#### **SQL (Structured Query Language):**
SQL is a domain-specific language used to communicate with relational databases. It allows you to perform tasks like:
- Querying data (reading data from the database)
- Inserting new data
- Updating existing data
- Deleting data
- Creating and modifying tables or structures
  SQL is essential for interacting with databases like MySQL and PostgreSQL which follows the relational model.
### SQL vs. NoSQL
Understanding the differences between SQL and NoSQL is crucial for modern applications' development:

| Feature           | SQL (Relational DB)                                                                | NoSQL (Non-relational DB)                                     |
|-------------------|------------------------------------------------------------------------------------|---------------------------------------------------------------|
| Data Structure    | Tables (rows and columns)                                                          | Documents, key-value pairs, wide-columns, etc                 |
| Schema            | Predefined schemas; data must follow a specific format                             | Dynamic Schema; data can be unstructured                      |
| ACID Transactions | Strong support for ACID properties (atomicity, consistency, isolation, durability) | May support ACID, but not always enforced                     |
| Examples          | MySQL, PostgreSQL, Oracle                                                          | MongoDB, CouchDB, Cassandra                                   |
| Best Suited For   | Complex queries, relationships, structured data                                    | Flexible schemas, handling large volumes of unstructured data |
#### Differences Between PostgreSQL and MySQL
While both PostgreSQL and MySQL are popular open-source relational databases, they have key differences:


| Feature         | PostgreSQL                                                                         | MySQL                                                  |
|-----------------|------------------------------------------------------------------------------------|--------------------------------------------------------|
| Type            | Object-Relational database (supports both relational and object-oriented features) | Purely Relational Database                             |
| ACID Compliance | Fully ACID compliant (support complex transactions)                                | ACID compliant for InnoDB storage engine               |
| JSON support    | Advanced support for JSON data types and queries                                   | Support JSON data types (but less advanced)            |
| Extensibility   | Highly extensible, supports custom data types and functions                        | Limited extensibility                                  |
| Use Case        | Suitable for complex applications requiring advanced queries and data integrity.   | Suitable for simple to medium complexity applications. |
| Community       | Strong, but smaller community compared to MySQL                                    | One of the most widely used and supported database     |

## Basic SQL Queries:
#### SELECT Query: 
The `SELECT` statement is used to retrieve data from a database. It's one of the most frequently used SQL commands, forming the foundation for querying databases.
1. SELECT Statements Basics
    A `SELECT` statement retrieves data from one or more columns of a table:
    ```
    SELECT column1, column2, ... FROM table_name;
    ```
    - column1, column2, ... : The columns you want to fetch from the table.
      - table_name: The name of the table from which you want to retrieve data.
      **Example:** If we have a table called `Employees`:
    
    | EmpId | FirstName | LastName | Age | Department |
    |-------|-----------|----------|-----|------------|
    | 1     | John      | Doe      | 30  | HR         |
    | 2     | Jane      | Smith    | 25  | IT         |
    | 3     | Bob       | Brown    | 40  | Marketing  |
  
    ```
    SELECT FirstName, LastName FROM Employees;
    ```
    This query will return:
  
    | FirstName | LastName |
    |-----------|----------|
    | John      | Doe      |
    | Jane      | Smith    |
    | Bob       | Brown    |

2. **Filtering Data Using the WHERE Clause:**
    The `WHERE` clause is used to filter records. It retrieves only the rows that satisfy a given condition.
    ```
    SELECT column1, column2, ... FROM table_name WHERE condition;
    ```
   Example: To get employees who are older than 30:
   ```
   SELECT FirstName, LastName FROM Employee WHERE Age > 30;
   ```
    This will return:
    
    | FirstName | LastName |
    |-----------|----------| 
    | Bob       | Brown    |

3. **Sorting Results using ORDER BY:**
    The `ORDER BY` clause is used to sort the result set in ascending or descending order based on one or more columns.
    ```
   SELECT column1, column2, ... FROM table_name ORDER BY column1 [ASC|DESC];
    ```
   - ASC: Ascending order (default)
   - DESC: Descending order.
    
   **Example:** To get all employees sorted by LastName in ascending order:
    ```
    SELECT FirstName, LastName FROM Employee ORDER BY LastName ASCE;
    ```
   This will return:

    | FirstName | LastName |
    |-----------|----------|
    | Bob       | Brown    |
    | John	     | Doe      |
    | Jane	     | Smith    |
    
    To sort by Age in descending order:
    ```
   SELECT FirstName, LastName, Age FROM Employees ORDER BY Age DESC;
    ```
   This will Return:

   | FirstName | LastName | Age |
   |-----------|----------|:---:|
   | Bob       | Brown    | 	40 |
   | John	     | Doe      | 	30 |
   | Jane	     | Smith    | 	25 |

4. **Limiting Results:**
    Often, you want to limit the number of rows returned by a query. The methods for limiting rows vary between MySQL and PostgreSQL.
    - In MySQL. you use the LIMIT clause.
    - In PostgreSQL, you use FETCH or LIMIT.

   MySQL - Using Limit
   ```
   SELECT column1, column2, ... FROM table_name LIMIT number_of_rows;
   ```
   **Example:** To get the first 2 employees from the Employees table:
    ```
    SELECT FirstName, LastName FROM Employees LIMIT 2;
    ```
   This will return:

    | FirstName | LastName   |
    |-----------|------------| 
    | John      | 	Doe       |
    | ane       | Smith      |   

    PostgreSQL - Using FETCH
    In PostgreSQL, FETCH is used to limit the number of rows returned:
    ```
    SELECT column1, column2, ... FROM table_name FETCH FIRST number_of_rows ROWS ONLY;
    ```
   Example: To fetch the first 2 rows:
    ```
    SELECT FirstName, LastName FROM Employees FETCH FIRST 2 ROWS ONLY;
    ```
    The result will be same as in MySQL:

   | FirstName | LastName   |
   |-----------|------------| 
   | John      | 	Doe       |
   | Jane      | Smith      |   
    
    Alternatively, in both MySQL and PostgreSQL, you can use the OFFSET clause with LIMIT or FETCH to skip a certain number of rows before retrieving the results.
    **Using OFFSET:**
   ``` 
   SELECT column1, column2, ... FROM table_name LIMIT number_of_rows OFFSET number_of_rows_to_skip;
   ```
   or in PostgreSQL:
   ```
   SELECT column1, column2, ... FROM table_name OFFSET number_of_rows_to_skip FETCH FIRST number_of_rows ROWS ONLY;
   ```
   **Example:** To skip the first row and fetch the next two:
    ```
    SELECT FirstName, LastName FROM Employees LIMIT 2 OFFSET 1;
    ```
    This will return:

   | FirstName | LastName |
   |-----------|----------| 
   | John      | 	Doe     |
   | Bob       | Brown    |   

##### Recap
- SELECT: Retrieve data from a table.
- WHERE: Filter rows based on conditions.
- ORDER BY: Sort rows by a column in ascending or descending order.
- LIMIT (MySQL) / FETCH (PostgreSQL): Limit the number of rows returned.
- OFFSET: Skip a certain number of rows before starting to retrieve rows.

## Data Manipulation Language (DML)
DML is a subset of SQL used to manage and manipulate data within the database. It includes command like `INSERT`,`UPDATE`, `DELETE` and `TRUNCATE`, which are essential for
alerting the actual data stored in tables.

1. **INSERT: Inserting Data into Tables:** The `INSERT` statement is used to add new records (rows) to a table.
    Basic Syntax:
    ```
    INSERT INTO table_name (column1, column2, column3, ... ) 
    VALUES (value1, value2, value3, ...);
    ```
   - table_name: The name of the table where you want to insert the data.
   - column1, column2, ... : The columns that correspond to the values you are inserting.
   - value1, value2, ... : The actual data you want to insert.
    
    Example:
    We have table `Employees` above, we will insert values in it. 
    ```
    INSERT INTO Employees (EmployeeID, FirstName, LastName, Age)
    VALUES (1, 'Tommy', 'Shelby', 30);
    ```
   
    This inserts a new row into the Employees table:
   
    | EmployeeID | FirstName | LastName | Age |
    |------------|-----------|----------|-----|
    | 1          | Tommy     | Shelby   | 30  |
   
    **Inserting Multiple Rows:** We can insert multiple rows in a single `INSERT` statement by separating each set of values with a comma.
    ```
    INSERT INTO Employees (EmployeeID, FirstName, LastName, Age)
    VALUES
    (2, 'Ada', 'Shelby', 30),
    (3, 'Arthur', 'Shelby', 40);
    ```
   This will insert two rows into the table:
    
    | EmployeeID | FirstName | LastName | Age |
    |------------|-----------|----------|-----|
    | 2          | Ada       | Shelby   | 30  |
    | 3          | Arthur    | Shelby   | 40  |

2. **UPDATE: Modifying Existing Records:** The `UPDATE` statement is used to modify existing data in one or more rows of a table. You can
    use the `WHERE` clause to specify which records to update.
    Basic Syntax:
   ```
   UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
   ```
   - table_name: Name of the table in which you want to update the records.
   - column1 = value1: Specifies the columns and their new values.
   - condition: Filters which rows to update (without `WHERE`, all rows will be updated)

    Example: Update the age of the employee with EmployeeID = 1:
    ```
    UPDATE Employees SET Age = 31, WHERE EmployeeID = 1;
    ```
   This will modify the Age of Tommy from 30 to 31

   | EmployeeID | FirstName | LastName | Age |
   |------------|-----------|----------|-----|
   | 1          | Tommy     | Shelby   | 31  |
   
    Updating Multiple Columns: You can update more than one column in the same statement:
    ```
    UPDATE Employees SET FirstName = 'Robert', Age = 41 WHERE EmployeeID = 3;
    ```
   This will update the Arthur first name and age:

    | EmployeeID | FirstName | LastName | Age |
    |------------|-----------|----------|-----|
    | 3          | Robert    | Shelby   | 41  |

3. **DELETE: Removing Data from Tables:**
    The `DELETE` statement is used to remove records from a table. As with `UPDATE`, you should use the `WHERE` clause to specify which 
    records to delete. If you don't include a `WHERE` clause, all records in the table will be deleted.
    
    Basic Syntax:
    ```
    DELETE FROM table_name WHERE condition; 
    ```
   - table_name: The table from which to delete records.
   - condition: Specifies which rows to delete.
    Example:
    ```
    DELETE FROM Employees WHERE EmployeeID = 2;
    ```
   After this. the table will no longer contain Ada Shelby:
   
   | EmployeeID | FirstName | LastName | Age |
   |------------|-----------|----------|-----|
   | 1          | Tommy     | Shelby   | 31  |
   | 3          | Arthur    | Shelby   | 41  |
    
    Deleting All Rows: 
    If you want to delete all rows from a table (but keep the table structure intact), omit the `WHERE` clause:
    ```
    DELETE FROM Employees;
    ```
   This removes all rows from the Employees table but leaves the table itself in place.

4. **TRUNCATE: Efficiently Removing All Records from a Table:**
    The `TRUNCATE` command is similar to `DELETE`, but it removes all rows from a table much more efficiently by resetting the table. It's faster than DELETE because it doesn't log individual row deletions and
    usually resets any auto-incrementing keys.
    Basic Syntax: 
    ``` 
    TRUCATE TABLE table_name;
    ```
    table_name: The table from which to remove all records.

    Example: Truncate the Employees table:
    ```
    TRUNCATE TABLE Employees;
    ```
    This will remove all rows from the table, and the next INSERT will start the EmployeeID from 1 again (if it's auto-incremented).

   | EmployeeID | FirstName | LastName | Age     |
   |------------|-----------|----------|---------|
   | (empty)    | (empty)   | (empty)  | (empty) |

    **Key Difference between DELETE and TRUNCATE:**
    - **DELETE:**
      - Deletes rows one by one.
      - Can be rolled back (transactions supported).
      - You can specify which rows to delete using the WHERE Clause.
    - **TRUNCATE:**
      - Removes all rows at once without logging individual row deletions.
      - Cannot be rolled back in most database systems.
      - Cannot use `WHERE` with `TRUNCATE` (it's an all-or-nothing command).

##### Recap:
- INSERT: Adds new records to the table.
- UPDATE: Modifies existing records based on a condition.
- DELETE: Removes records based on a condition (or all records if no condition is specified).
- TRUNCATE: Efficiently removes all records from a table, resetting auto-increment counters