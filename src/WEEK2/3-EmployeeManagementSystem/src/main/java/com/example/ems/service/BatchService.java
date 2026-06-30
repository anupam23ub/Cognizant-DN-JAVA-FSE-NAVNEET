package com.example.ems.service;

import com.example.ems.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Exercise 10: Batch Processing with Hibernate.
 *
 * Inserts are flushed and the persistence context cleared every `batchSize`
 * rows so the first-level cache does not grow unbounded. The JDBC batch size
 * itself is configured in application.properties
 * (spring.jpa.properties.hibernate.jdbc.batch_size).
 */
@Service
public class BatchService {

    private static final int BATCH_SIZE = 25;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void batchInsert(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i > 0 && i % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }
}
