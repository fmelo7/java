# Use java 8
FROM openjdk:8-jdk

# Set the working directory to /app
WORKDIR /jpa-data-rest-example

# Copy the current directory contents into the container at /app
ADD jpa-data-rest-example-0.0.1-SNAPSHOT.jar /jpa-data-rest-example

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME jpa-data-rest-example

# Run app.py when the container launches
CMD ["java","-jar","jpa-data-rest-example-0.0.1-SNAPSHOT.jar"]

