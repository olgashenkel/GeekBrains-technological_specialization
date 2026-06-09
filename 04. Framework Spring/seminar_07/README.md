# Spring JWT Auth Full Example

This project demonstrates authentication and authorization using Spring Security and JWT.

## Features
- JWT token generation and validation.
- User authentication with Spring Security.
- Secure endpoints with role-based access.

## Requirements
- Java 17 or higher
- Maven

## Running the Project
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.

## Endpoints
- **POST** `/api/auth/login` - Authenticate and retrieve a JWT token.
- **Secure Endpoint** `/api/secure/data` - Accessible only with a valid JWT.
