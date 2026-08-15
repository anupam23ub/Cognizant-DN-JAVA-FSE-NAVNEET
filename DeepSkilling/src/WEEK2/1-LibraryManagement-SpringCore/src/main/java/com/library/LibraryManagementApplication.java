package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * LibraryManagementApplication - main class that loads the Spring context and
 * exercises the configuration.
 *
 * Covers the "Run the Application" / "Test the Configuration" steps of
 * Exercises 1, 2, 3, 5, 6, 7 and 8.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println(" PART A: XML configuration");
        System.out.println(" (Exercises 1, 2, 3, 5, 7, 8)");
        System.out.println("==================================================");
        runWithXmlConfiguration();

        System.out.println();
        System.out.println("==================================================");
        System.out.println(" PART B: Annotation configuration");
        System.out.println(" (Exercise 6 - component scanning)");
        System.out.println("==================================================");
        runWithAnnotationConfiguration();
    }

    /** Exercises 1/2/3/5/7/8 - plain XML context with explicit beans + AOP. */
    private static void runWithXmlConfiguration() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        // Verify dependency injection (Exercise 2/5/7): the repository must be wired.
        System.out.println("Dependency injected? "
                + (bookService.getBookRepository() != null));

        // Calling the service triggers the LoggingAspect (Exercise 3/8).
        List<String> books = bookService.getAllBooks();
        System.out.println("Books in library:");
        books.forEach(b -> System.out.println("  - " + b));

        bookService.addBook("Domain-Driven Design - Eric Evans");
        System.out.println("After adding a book, total = "
                + bookService.getAllBooks().size());

        ((ClassPathXmlApplicationContext) context).close();
    }

    /** Exercise 6 - annotation-driven context using component scanning. */
    private static void runWithAnnotationConfiguration() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-annotation.xml");

        BookService bookService = context.getBean(BookService.class);
        System.out.println("Bean discovered by component scan? "
                + (bookService != null));

        List<String> books = bookService.getAllBooks();
        System.out.println("Books in library (annotation config):");
        books.forEach(b -> System.out.println("  - " + b));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
