# Spring REST API Example

This project is a simple RESTful API built with Spring Boot. It demonstrates CRUD operations for managing users.

## Features
- Create, read, update, and delete users.
- Uses an in-memory H2 database for simplicity.
- Configured using `application.yml`.

## Requirements
- Java 17 or higher
- Maven

## Running the Project
1. Clone the repository.
2. Navigate to the project folder.
3. Run `mvn spring-boot:run` to start the application.

## Endpoints
- **GET** `/api/users` - Retrieve all users.
- **GET** `/api/users/{id}` - Retrieve a user by ID.
- **POST** `/api/users` - Create a new user.
- **PUT** `/api/users/{id}` - Update an existing user.
- **DELETE** `/api/users/{id}` - Delete a user.
