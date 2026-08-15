package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;

import java.util.List;

/**
 * Custom repository fragment for the Criteria Query hands-on
 * (Doc 3 / Hands-on 6).
 *
 * The Amazon-style scenario in the assignment is about building a WHERE clause
 * dynamically from whichever filters the user actually supplied. searchEmployees
 * mirrors that: every parameter is optional (pass null to skip it) and the
 * predicates are assembled programmatically with the JPA CriteriaBuilder.
 */
public interface EmployeeRepositoryCustom {

    List<Employee> searchEmployees(String name, Integer departmentId,
                                   Boolean permanent, Double minSalary);
}
