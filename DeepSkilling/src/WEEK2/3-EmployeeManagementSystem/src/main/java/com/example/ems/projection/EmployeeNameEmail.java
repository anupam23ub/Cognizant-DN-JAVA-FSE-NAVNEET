package com.example.ems.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 * Exercise 8: Interface-based projection.
 *
 * Spring Data generates a proxy that exposes only these accessors, so only the
 * required columns are fetched. The @Value example builds a derived property
 * using a SpEL expression over the backing entity.
 */
public interface EmployeeNameEmail {

    String getName();

    String getEmail();

    /** Derived/closed projection value built from other properties. */
    @Value("#{target.name + ' <' + target.email + '>'}")
    String getDisplayLabel();
}
