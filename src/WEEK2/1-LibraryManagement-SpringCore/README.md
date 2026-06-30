# LibraryManagement — Spring Core, DI, AOP & Maven

Source document: **Spring_Core_Maven.docx** — Exercises 1–8.
(Exercise 9, the Spring Boot version, lives in the sibling folder
`2-LibraryManagement-SpringBoot`.)

This is a plain Maven + Spring Core project (no Spring Boot). It demonstrates
bean configuration, IoC/DI, and AOP using **both** XML and annotation styles.

## How to run

```bash
cd 1-LibraryManagement-SpringCore
mvn clean package
mvn exec:java -Dexec.mainClass=com.library.LibraryManagementApplication
# or run LibraryManagementApplication from your IDE
```

(The `.docx` shows a Cognizant-internal proxy build command. On a normal
machine the plain `mvn clean package` above is enough.)

## Exercise → file map

| Exercise | Requirement | Where it is solved |
|----------|-------------|--------------------|
| 1 | Maven project + Spring Core deps; `applicationContext.xml`; beans for `BookService`/`BookRepository`; service/repository packages; main class | `pom.xml`, `applicationContext.xml`, `com.library.service.BookService`, `com.library.repository.BookRepository`, `LibraryManagementApplication` |
| 2 | Wire `BookRepository` into `BookService` (setter injection) | `applicationContext.xml` (`<property>`), `BookService.setBookRepository(...)` |
| 3 | Spring AOP dependency; `LoggingAspect` logging execution time; enable AspectJ | `pom.xml` (spring-aop + aspectjweaver), `com.library.aspect.LoggingAspect#logExecutionTime`, `applicationContext.xml` (`<aop:aspectj-autoproxy/>`) |
| 4 | Maven project; deps for Spring Context, AOP, WebMVC; compiler plugin for Java 1.8 | `pom.xml` (dependencies + `maven-compiler-plugin`) |
| 5 | Spring IoC container central config; setter injection; main class | `applicationContext.xml`, `BookService`, `LibraryManagementApplication` |
| 6 | Component scanning + `@Service` / `@Repository` annotations | `applicationContext-annotation.xml`, annotations on `BookService`/`BookRepository`, `runWithAnnotationConfiguration()` |
| 7 | Constructor **and** setter injection | `BookService` (constructor + setter), `applicationContext.xml` (`<constructor-arg>` + `<property>`) |
| 8 | Aspect with before/after advice; register aspect + enable auto-proxy | `LoggingAspect#logBefore` / `#logAfter`, `applicationContext.xml` |

## Notes

* The same `BookService` / `BookRepository` classes are reused for the XML
  config (Ex 1/2/5/7) and the annotation config (Ex 6). The Spring annotations
  are simply ignored when beans are declared explicitly in XML, so one set of
  classes satisfies every exercise.
* Running the main class prints the AOP before/after/timing log lines so you can
  see the aspect firing.
