package com.library.lms.repository;

import com.library.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookRepository (Exercise 9). Extending JpaRepository gives full CRUD support
 * with no implementation code.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
