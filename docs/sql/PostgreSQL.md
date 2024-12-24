# PostgreSQL Database: Important commands and Notes
### Install PostgreSQL on Docker
On the docker hub you will get various images for postgres. From the hub we will get most recent updated image of postgres
container.
[Postgres Image](https://hub.docker.com/_/postgres)

To get this image use the following command in your terminal
    `docker pull postgres`
Also, we can add tags for the image like latest this will pull the latest image from the docker

### Running the PostgreSQL image:
To run the postgres image for PostgreSQL, you can use the following command:
```
docker run -name postgres-container -e POSTGRES_PASSWORD=password -p 5432:5432 Postgres
```
In the above command, we call the run command to create a container from the postgres image that is present in our local repository
We provide some parameters here as you see:
- -name: This parameter give the name to that container. 
- -e: This tag stands for the environment variables to that image.
- In the above command we provide the POSTGRES_PASSWORD 
- -p: We need to define on which port is the database going to run in the container and which port on the host can be used to access it. As you can see, there are two ports mentioned in the command which are in the form HOST_PORT:DOCKER_PORT.

By running this command you have successfully created a postgres container

Once you run the command, you can see that the container starts up and is ready to accept database connections. An important point to note here is that we have not executed the command in detached mode, which means the database or the container will be running as long as the terminal is open.
Now to connect to the database, let us open a new terminal window and type the following command.

`docker exec -it postgres-container bash`

This command will start an interactive terminal inside the container. Next, you can start the PostgreSQL by running the following command on the same terminal.

`psql -h localhost -U postgres`

if with above command it not worked then use following command:
`psql -h localhost -U <username> -d <database-name> -p 5432`

## Common PostgreSQL Commands:
### 1. Basic commands:
1. Switch Database: ``` \c database_name```
2. List All databases: ``` \l ```
3. List all tables in the current database: ``` \dt ```
4. Describe table: ``` \d table_name ```
5. Exist PostgreSQL: ``` \q ```

### 2. Database Operations:
1. Create a database: ``` CREATE DATABASE database_name; ```
2. Drop database: ``` DROP DATABASE database_name; ```

### 3. User Management:
1. List all Users/Roles:
    ``` \du ```
2. Create User:
    ```sql
        CREATE USER username AND PASSWORD 'password';
    ```
3. Grant Privileges: 
    ```sql
        GRANT ALL PRIVILEGES ON DATABASE <database-name> TO <username>;
    ```
4. Revoke Privileges:
    ```sql
        REVOKE ALL PRIVILEGES ON DATABASE <database-name> TO <username>;
    ```

### 4. Table Operations:
1. Create Table:
    ```sql
        CREATE TABLE users (
            id SERIAL PRIMARY KEY,
            name VARCHAR(50),
            email VARCHAR(150)
        );
    ```
2. Drop a Table:
    ```sql 
        DROP TABLE table-name;
    ```
3. Rename table:
    ``` ALTER TABLE old_table RENAME TO new_table;```
4. Add column:
    ``` ALTER TABLE table-name ADD COLUMN column-name type;```
5. Remove column:
    ``` ALTER TABLE table-name DROP COLUMN column-name;```

### 5. Query Operations:
1. Insert Data:
    ``` INSERT INTO users (name, email) VALUES ('Vishwajeet', 'vishwajeet@example.com');```
2. Select Data (all data):
    ``` SELECT * FROM users;```
3. Select specific field from all data:
    ```SELECT name FROM users;```
4. Update data:
    ```UPDATE users SET name ='Vishwajeet Kotkar' WHERE id = 1;```
5. Delete data:
    ```DELETE FROM users WHERE id = 1;```

### 6. Filtering and Sorting:
1. Filter Rows:
    ``` SELECT * FROM users WHERE age > 25;```
2. Sort Rows:
    ``` SELECT * FROM users ORDER BY name ASC;```
3. Limit Rows:
    ``` SELECT * FROM users LIMIT 10 OFFSET 20;```

### 7. Aggregation and Grouping:
1. Count rows:
    ```SELECT COUNT(*) FROM users;```
2. Group Data:
    ```SELECT age, COUNT(*) FROM users GROUP BY age;```
3. Find Maximum and Minimum:
    ``` SELECT MAX(age), MIN(age) FROM users;```

### 8. Index Management:
1. Create an Index:
    ``` CREATE INDEX idx_name ON users(name);```
2. Delete an Index:
    ```DROP INDEX idx_name;```

### 9. Transaction Management:
1. Begin a Transaction: ``` BEGIN;```
2. Commit a Transaction: ```COMMIT;```
3. Rollback a Transaction: ```ROLLBACK;```

### 10. Miscellaneous Commands:
1. Show current user:   ``` SELECT current_user; ```
2. Show Current Database: ``` SELECT current_database(); ```
3. Show all Running Queries: ``` SELECT * FROM pg_stat_activity; ```
4. Cancel a Query: ``` SELECT pg_cancel_backend(pid); ```

### 11. Import and Export:
1. Import Data: 
    ``` psql -U username -d database_name -f dumpfile.sql ```
2. Export Data:
    ``` pg_dump -U username -d database_name > dumpfile.sql ```