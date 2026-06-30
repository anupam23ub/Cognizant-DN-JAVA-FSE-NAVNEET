package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * BookRepository - data access layer for the library.
 *
 * Exercise 1: defined as a bean (also wired via XML in applicationContext.xml).
 * Exercise 6: annotated with @Repository so it can be picked up by component
 *             scanning instead of being declared manually in XML.
 */
@Repository
public class BookRepository {

    /** Simulated data store (in a real app this would talk to a database). */
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Effective Java - Joshua Bloch");
        books.add("Clean Code - Robert C. Martin");
        books.add("Spring in Action - Craig Walls");
    }

    public List<String> findAll() {
        return books;
    }

    public void save(String title) {
        books.add(title);
    }

    public String findByIndex(int index) {
        if (index < 0 || index >= books.size()) {
            return null;
        }
        return books.get(index);
    }
}
