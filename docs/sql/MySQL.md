# MySQL 
MySQL is an open source relational database management system (RDBMS) this is widely used for managing structured data in 
web Applications, data warehousing and other use cases. It is known for its speed, scalability and reliability. MySQL uses
Structural Query Language (SQL) for database management and supports multi-user access. It is commonly used in conjunction with
web technologies like PHP and frameworks such as Spring Boot for backend development. 
**Key features includes:**
- Support ACID transactions.
- Scalability for large scale applications.
- Extensive support for SQL functions and commands.
- Compatibility with various programming languages, like java.

### Common MySQL Commands/Queries:
1. Basic Commands:
    - log into MySQL: `mysql -u username -p`
    - switch database: `USE database_name;`
    - List all databases: `SHOW DATABASES;`
    - List all tables in Current database: `SHOW TABLES;`
    - Describe a Table (schema) : `DESCRIBE table_name;`
    - Exit MySQL: `EXIT;`

2. Database Operations:
    - Create database: `CREATE DATABASE database_name;`
    - Drop a database: `DROP DATABASE database_name;`

3. User and Role Management:
    - List all users: `SELECT User, Host FROM mysql.user;`
    - Create user: `CREATE USER 'username'@'host' IDENTIFED BY 'password';`
    - Grant Privileges: `GRANT ALL PRIVILEGES ON database_name TO 'username'@'host';`
    - Revoke Privileges: `REVOKE ALL PRIVIKEGES ON database_name FROM 'username'@'host';`
    - Flush Privileges (apply changes): `FLUSH PRIVILEGES;`

4. Table Operations:
   - Create Table:
      ```sql
         CREATE TABLE users(
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(40),
            email VARCHAR(40) UNIQUE
         );
     ```
   - Drop Table:
      ```DROP TABLE users;```
   - Rename a Table:
      ```RENAME TABLE old_table TO new_table;```
   - Add a Column:
      ```ALTER TABLE users ADD COLUMN age INT;```
   - Drop a Column:
      ```ALTER TABLE DROP COLUMN age;```

5. Query Operations:
   - Insert the Data:
      ```INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');```
   - Select Data:
      ``` SELECT * FROM users;```
   - Update a Data:
      ```UPDATE users SET name = 'Jane Doe' WHERE id = 1;```
   - Delete a Data:
      ```DELETE FROM users WHERE id = 1;```

6. Filtering and Sorting: 
   - Filter rows:
      ```SELECT * FROM users WHERE age > 25;```
   - Sort Rows:
      ```SELECT * FROM users ORDER BY names ASC;```
   - Limit Rows:
      ```SELECT * FROM users LIMIT 10 OFFSET 5;```

7. Aggregation and Grouping:
   - Count Rows: 
      ```SELECT COUNT(*) FROM users;```
   - Group Data:
      ```SELECT age, COUNT(*) FROM uses GROUP BY age;```
   - Find Maximum and Minimum:
     ```SELECT MAX(age), MIN(age) FROM users;```

8. Index Management:
   - Create an Index:
      ```CREATE INDEX idx_name ON users(name);```
   - Drop an Index:
      ```DROP INDEX idx_name ON users;```

9. Transaction Management:
   - Begin Transaction:
      ```START TRANSACTION;```
   - Commit Transaction:
      ```COMMIT;```
   - Rollback Transaction:
     ```ROLLBACK;```

10. Miscellaneous Commands
    - Show Current user:
       ``` SELECT USER();```
    - Show Current Database:
       ``` SELECT DATABASE();```
    - Show Server Version:
       ```SELECT VERSION();```
    - Show Running process:
       ```SHOW PROCESSLIST;```
    - Kill a Process:
       ```KILL PROCESS_ID;```

11. Import and Export Data
   - Import Data:
      ``` mysql -u username -p database_name < dumpfile.sql ```
   - Export Data:
      ``` mysqldump -u username -p database_name > dumpfile.sql ```