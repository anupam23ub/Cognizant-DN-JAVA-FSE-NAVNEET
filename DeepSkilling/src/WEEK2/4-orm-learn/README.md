# orm-learn

Cumulative Spring Data JPA / Hibernate project covering all three
`spring-data-jpa-handson` documents. Single Spring Boot project, base package
`com.cognizant.ormlearn`.

> **Modernisation note.** The original course materials target Spring Boot 2 /
> `javax.persistence` / MySQL with Hibernate 5 `select ... as col1_2_` style
> logging. This project uses **Spring Boot 3.2.5 / Java 17 / `jakarta.persistence`**.
> The mappings, relationships, HQL, native and criteria queries are identical in
> behaviour; only the import namespace and Hibernate version differ.

## Running it

**Option A - MySQL (as written in the documents)**

```sql
create schema if not exists ormlearn;
use ormlearn;
source sql/01-schema.sql;
source sql/02-country-data.sql;
source sql/03-stock-data.sql;
source sql/04-payroll-data.sql;
source sql/05-quiz-data.sql;
```

Then `mvn spring-boot:run` (credentials root/root in `application.properties`).

**Option B - H2, no install required**

```
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

The H2 profile loads the same SQL scripts from the classpath automatically.

`OrmLearnApplication.main()` follows the documents' "uncomment one test method,
comment the rest" convention. `testGetAllCountries()` is enabled by default;
uncomment any other `testXxx()` to exercise that hands-on.

## Hands-on -> code map

### Document 1 (Country CRUD, hands-on 1-9)
| Topic | Where |
|-------|-------|
| `Country` entity (`co_code` / `co_name`) | `model/Country.java` |
| `CountryRepository` | `repository/CountryRepository.java` |
| CRUD service + `@Transactional` | `service/CountryService.java` |
| `CountryNotFoundException` (Optional handling) | `service/exception/CountryNotFoundException.java` |
| get all / get one / add / update / delete tests | `OrmLearnApplication` `testGetAllCountries`, `testGetCountry`, `testAddCountry`, `testUpdateCountry`, `testDeleteCountry` |
| schema + 249-country data | `sql/01-schema.sql`, `sql/02-country-data.sql` |

### Document 2 (Query methods + relationships, hands-on 1-6)
| Topic | Where |
|-------|-------|
| H1 country query methods (contains / sorted / starts-with) | `CountryRepository` + `testSearchCountries*`, `testCountriesStartingWith` |
| H2 stock query methods (between dates, > price, top-3 volume, lowest-3 close) | `repository/StockRepository.java`, `service/StockService.java`, `testFacebookSeptember2019` / `testGoogleAbove1250` / `testTop3ByVolume` / `testNetflixLowest3` |
| H3 payroll entities | `model/Employee.java`, `Department.java`, `Skill.java` |
| H4 `@ManyToOne` Employee->Department | `Employee.department`, `testGetEmployee` / `testAddEmployee` / `testUpdateEmployee` |
| H5 `@OneToMany` Department->Employee (EAGER) | `Department.employeeList`, `testGetDepartment` |
| H6 `@ManyToMany` Employee<->Skill (`employee_skill`) | `Employee.skillList`, `testAddSkillToEmployee` |
| stock + payroll data | `sql/03-stock-data.sql`, `sql/04-payroll-data.sql` |

### Document 3 (HQL, JPQL, native, criteria, hands-on 1-6)
| Topic | Where |
|-------|-------|
| H2 permanent employees via HQL `left join fetch` | `EmployeeRepository.getAllPermanentEmployees`, `testGetAllPermanentEmployees` |
| H3 quiz attempt graph via HQL `join fetch` | `repository/AttemptRepository.java`, `service/AttemptService.java`, quiz entities (`QuizUser`, `Question`, `Options`, `Attempt`, `AttemptQuestion`, `AttemptOption`), `testQuizAttempt`, `sql/05-quiz-data.sql` |
| H4 average salary (overall + by department) | `EmployeeRepository.getAverageSalary[(id)]`, `testAverageSalary` |
| H5 native query | `EmployeeRepository.getAllEmployeesNative`, `testNativeQuery` |
| H6 dynamic Criteria Query | `repository/EmployeeRepositoryCustom.java` + `EmployeeRepositoryImpl.java`, `testCriteriaQuery` |

## Notes on data choices
- The original `payroll.sql`, `stock-data.csv` and `quiz.mwb` files ship on the
  course platform and were not provided. The `sql/` scripts here reconstruct
  them: stock rows are the exact rows from each query's expected output table;
  the quiz data reproduces the assignment's printed attempt detail exactly.
- Employee 1 and skill 4 (SQL) are intentionally left unlinked so
  `testAddSkillToEmployee` has a pair with no existing relationship, as H6 asks.
- `Country` is mapped to `co_code` / `co_name` (not the `code` / `name` shown in
  the Doc 1 snippet) so it matches the populate script and passes
  `ddl-auto=validate`.
