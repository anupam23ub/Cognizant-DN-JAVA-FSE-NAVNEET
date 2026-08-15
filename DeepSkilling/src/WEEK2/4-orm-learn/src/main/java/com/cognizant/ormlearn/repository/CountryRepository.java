package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CountryRepository (Doc 1 / Hands-on 1, Doc 2 / Hands-on 1).
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Doc 2 / Hands-on 1, query 1: search-box "contains" match
    List<Country> findByNameContaining(String name);

    // Doc 2 / Hands-on 1, query 2: same, but sorted ascending by name
    List<Country> findByNameContainingOrderByNameAsc(String name);

    // Doc 2 / Hands-on 1, query 3: alphabet index - names starting with a letter
    List<Country> findByNameStartingWith(String prefix);
}
