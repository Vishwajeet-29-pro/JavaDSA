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