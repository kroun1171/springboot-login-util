# Step 1: Use a Maven image to build the application
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Package the Spring Boot application
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight image to run the application
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port (default Spring Boot port is 8080)
EXPOSE 8084

# Run the application
CMD ["java", "-jar", "app.jar"]