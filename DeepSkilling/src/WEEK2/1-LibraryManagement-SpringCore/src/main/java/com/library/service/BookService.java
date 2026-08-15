package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BookService - business layer.
 *
 * Exercise 2 & 5: Setter injection of BookRepository.
 * Exercise 6: annotated with @Service for annotation-based configuration.
 * Exercise 7: also supports constructor injection (both styles demonstrated).
 *
 * NOTE on the annotations:
 *   - When running with the annotation-driven context
 *     (applicationContext-annotation.xml, Exercise 6) Spring uses @Service /
 *     @Autowired below to create and wire the bean automatically.
 *   - When running with the plain XML context (applicationContext.xml,
 *     Exercises 1/2/5/7) the bean and its dependency are declared in XML.
 *     The annotations are simply ignored in that case, so the same class works
 *     for both styles.
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    /** No-arg constructor required for setter-injection style (Exercise 2/5). */
    public BookService() {
    }

    /** Constructor injection (Exercise 7). @Autowired makes it work under
     *  component scanning too. */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** Setter injection (Exercise 2/5/7). */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    /**
     * Returns all the books in the library. A small artificial delay is added
     * so the LoggingAspect (Exercises 3 & 8) prints a meaningful execution time.
     */
    public List<String> getAllBooks() {
        try {
            Thread.sleep(15);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
        return bookRepository.findAll();
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }
}
