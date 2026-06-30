# LibraryManagement — Spring Boot

Source document: **Spring_Core_Maven.docx** — Exercise 9
("Creating a Spring Boot Application").

A Spring Boot rewrite of the library system with Spring Web + Spring Data JPA +
H2, exposing REST CRUD endpoints.

## How to run

```bash
cd 2-LibraryManagement-SpringBoot
mvn spring-boot:run
```

App starts on `http://localhost:8080`. H2 console: `http://localhost:8080/h2-console`
(JDBC URL `jdbc:h2:mem:librarydb`, user `sa`, no password).

## REST endpoints (BookController)

| Method | URL | Purpose |
|--------|-----|---------|
| GET    | `/api/books`      | List all books |
| GET    | `/api/books/{id}` | Get one book |
| POST   | `/api/books`      | Create a book (JSON body) |
| PUT    | `/api/books/{id}` | Update a book |
| DELETE | `/api/books/{id}` | Delete a book |

Example:

```bash
curl http://localhost:8080/api/books
curl -X POST http://localhost:8080/api/books \
     -H "Content-Type: application/json" \
     -d '{"title":"DDD","author":"Eric Evans","isbn":"978-0321125217"}'
```

## Exercise 9 step → file map

| Step | Where |
|------|-------|
| Create Spring Boot project | whole module + `LibraryManagementApplication` |
| Add Spring Web, Spring Data JPA, H2 | `pom.xml` |
| Configure `application.properties` | `src/main/resources/application.properties` |
| Define `Book` entity + `BookRepository` | `entity/Book.java`, `repository/BookRepository.java` |
| Create `BookController` for CRUD | `controller/BookController.java` |
| Run and test endpoints | `mvn spring-boot:run` + curl commands above |
