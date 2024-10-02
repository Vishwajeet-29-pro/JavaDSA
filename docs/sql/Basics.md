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
Understanding the differences between SQL and NoSQL is crucial for modern applications development:

| Feature           | SQL (Relational DB)                                                                | NoSQL (Non-relational DB)                                     |
|-------------------|------------------------------------------------------------------------------------|---------------------------------------------------------------|
| Data Structure    | Tables (rows and columns)                                                          | Documents, key-value pairs, wide-columns, etc                 |
| Schema            | Predefined schemas; data must follow a specific fomat                              | Dynamic Schema; data can be unstructured                      |
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
