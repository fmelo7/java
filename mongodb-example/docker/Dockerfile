# Use java 8
FROM openjdk:8-jdk

# Set the working directory to /app
WORKDIR /mongodb-example

# Copy the current directory contents into the container at /app
ADD mongodb-example-0.0.1-SNAPSHOT.jar /mongodb-example

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME mongodb-example

# Run app.py when the container launches
CMD ["java","-jar","mongodb-example-0.0.1-SNAPSHOT.jar"]

