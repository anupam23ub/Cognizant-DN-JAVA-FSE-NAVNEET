package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * AttemptRepository (Doc 3 / Hands-on 3).
 *
 * getAttempt walks user -> attempt -> attempt_question -> question ->
 * attempt_option -> options, using "join fetch" on every one-to-many so the
 * whole graph is loaded in a single query (as the assignment requires). The
 * WHERE clause filters by user id and attempt id.
 */
@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query(value = "SELECT DISTINCT a FROM Attempt a "
            + "JOIN FETCH a.user u "
            + "JOIN FETCH a.attemptQuestions aq "
            + "JOIN FETCH aq.question q "
            + "JOIN FETCH aq.attemptOptions ao "
            + "JOIN FETCH ao.option o "
            + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
