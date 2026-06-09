# Spring CRUD Project

This project demonstrates CRUD operations for a `Person` entity using Spring Boot, Spring Data JPA, and H2 database.

## Steps to Run

1. Clone or download the project.
2. Run the application using your IDE or Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access the application:
   - API: `http://localhost:8080/api/persons`
   - H2 Console: `http://localhost:8080/h2-console`

## Endpoints

- `GET /api/persons` - Fetch all persons.
- `GET /api/persons/{id}` - Fetch a person by ID.
- `POST /api/persons` - Create a new person.
- `PUT /api/persons/{id}` - Update an existing person.
- `DELETE /api/persons/{id}` - Delete a person by ID.
