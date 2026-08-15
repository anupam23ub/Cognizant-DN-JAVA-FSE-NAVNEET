# EmployeeManagementSystem — Spring Data JPA & Hibernate

Source document: **Spring_Data_JPA_and_Hibernate.docx** — Exercises 1–10.

A Spring Boot application managing employees and departments, covering the full
Spring Data JPA + Hibernate feature set requested by the assignment.

## How to run

```bash
cd 3-EmployeeManagementSystem
mvn spring-boot:run
```

* App: `http://localhost:8080`
* H2 console: `http://localhost:8080/h2-console` (URL `jdbc:h2:mem:testdb`, user `sa`, password `password`)
* Multiple-data-source demo (Exercise 9):
  `mvn spring-boot:run -Dspring-boot.run.profiles=multi-ds`

On startup a `CommandLineRunner` seeds two departments and three employees and
prints the pagination (Ex 6) and projection (Ex 8) demos to the console.

## REST endpoints

| Method | URL | Exercise |
|--------|-----|----------|
| GET/POST/PUT/DELETE | `/api/employees`, `/api/employees/{id}` | 4 |
| GET | `/api/employees/search?name=as` | 5 |
| GET | `/api/employees/paged?page=0&size=5&sortBy=name&direction=asc` | 6 |
| GET | `/api/employees/dto` | 8 |
| GET/POST/PUT/DELETE | `/api/departments`, `/api/departments/{id}` | 4 |

## Exercise → file map

| Exercise | Requirement | Where |
|----------|-------------|-------|
| 1 | Spring Boot project + deps (JPA, H2, Web, Lombok) + `application.properties` | `pom.xml`, `application.properties`, `EmployeeManagementSystemApplication` |
| 2 | `Employee`/`Department` entities; `@Entity/@Table/@Id/@GeneratedValue`; one-to-many | `entity/Employee.java`, `entity/Department.java` |
| 3 | Repositories extending `JpaRepository` + derived queries | `repository/EmployeeRepository.java`, `repository/DepartmentRepository.java` |
| 4 | CRUD + REST controllers | `service/*Service.java`, `controller/*Controller.java` |
| 5 | Query methods, `@Query`, `@NamedQuery`/`@NamedQueries` | `EmployeeRepository` (`@Query` + `findByExactName`), `Employee` (`@NamedQueries`) |
| 6 | Pagination (`Page`/`Pageable`) + sorting | `EmployeeService#findPaged`, `EmployeeController#paged`, paged repo methods |
| 7 | Entity auditing (`@CreatedBy/@LastModifiedBy/@CreatedDate/@LastModifiedDate`) | `entity/Auditable.java`, `config/AuditingConfig.java` |
| 8 | Interface-based + class-based projections (`@Value`, constructor expr.) | `projection/EmployeeNameEmail.java`, `projection/EmployeeDto.java`, `EmployeeRepository#fetchAllAsDto` |
| 9 | Auto-config + externalized config + multiple data sources | `application.properties`, `application-multi-ds.properties`, `config/SecondaryDataSourceConfig.java` |
| 10 | Hibernate annotations, dialect/properties, batch processing | `Employee` (`@DynamicUpdate`, `@NaturalId`), `application.properties` (dialect + batch), `service/BatchService.java` |

## Notes

* Lombok generates the getters/setters/builders on the entities; if your IDE
  shows errors, enable annotation processing / install the Lombok plugin.
* The secondary data source (Ex 9) is profile-gated so the default run keeps a
  single database; activating `multi-ds` wires a second Hikari `DataSource`
  from the externalized `app.secondary.datasource.*` keys.
