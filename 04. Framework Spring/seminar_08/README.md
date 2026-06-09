# Spring AOP and Transaction Management Example

This project demonstrates:
1. Logging method execution using Spring AOP.
2. Transaction management using Spring @Transactional.

## Features
- AOP logging for service methods.
- Transaction-safe fund transfer between accounts.

## Requirements
- Java 17 or higher
- Maven

## Running the Project
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.

## Endpoints
- **POST** `/api/accounts/transfer` - Transfer funds between accounts.
