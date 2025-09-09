# Hotel Management System - Simple Spring Boot Project

This is a simple **Hotel Management System** built with Spring Boot, Thymeleaf, Spring Data JPA and H2 (in-memory) database.

## Features
- Add and list rooms
- Create simple bookings (marks room unavailable)
- List bookings
- H2 console enabled (http://localhost:8080/h2-console)

## Run
1. Ensure you have Java 17+ and Maven installed.
2. From project folder:
   ```
   mvn spring-boot:run
   ```
   Or build jar:
   ```
   mvn package
   java -jar target/hotel-management-system-1.0.0.jar
   ```
3. Open `http://localhost:8080/` in browser.

