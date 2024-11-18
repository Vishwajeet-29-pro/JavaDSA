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
-name: This parameter give the name to that container. 
-e: This tag stands for the environment variables to that image.
In the above command we provide the POSTGRES_PASSWORD 
-p: We need to define on which port is the database going to run in the container and which port on the host can be used to access it. As you can see, there are two ports mentioned in the command which are in the form HOST_PORT:DOCKER_PORT.
By running this command you have successfully created a postgres container

Once you run the command, you can see that the container starts up and is ready to accept database connections. An important point to note here is that we have not executed the command in detached mode, which means the database or the container will be running as long as the terminal is open.
Now to connect to the database, let us open a new terminal window and type the following command.
`docker exec -it postgres-container bash`
This command will start an interactive terminal inside the container. Next, you can start the PostgreSQL by running the following command on the same terminal.
`psql -h localhost -U postgres`
