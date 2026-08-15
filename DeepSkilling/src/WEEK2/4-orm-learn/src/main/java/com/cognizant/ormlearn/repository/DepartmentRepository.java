package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** DepartmentRepository (Doc 2 / Hands-on 3). */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
