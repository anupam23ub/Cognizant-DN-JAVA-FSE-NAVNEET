package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeDto;
import com.example.ems.projection.EmployeeNameEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * EmployeeRepository.
 *
 * Exercise 3: extends JpaRepository (CRUD) + derived query methods.
 * Exercise 5: @Query (JPQL) methods + a @NamedQuery-backed method.
 * Exercise 6: pagination & sorting with Pageable / Page.
 * Exercise 8: projection-returning queries (interface + class based).
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ---- Exercise 3: derived query methods ----
    List<Employee> findByName(String name);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String fragment);

    List<Employee> findByDepartmentId(Long departmentId);

    // ---- Exercise 5: @Query (JPQL) ----
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.email) LIKE LOWER(CONCAT('%', :domain))")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // ---- Exercise 5: @NamedQuery declared on the Employee entity ----
    // Spring resolves this to the entity's @NamedQuery "Employee.findByExactName"
    List<Employee> findByExactName(@Param("name") String name);

    // ---- Exercise 6: pagination + sorting ----
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    Page<Employee> findByNameContainingIgnoreCase(String fragment, Pageable pageable);

    // ---- Exercise 8: interface-based projection ----
    List<EmployeeNameEmail> findByDepartment_Name(String departmentName);

    // ---- Exercise 8: class-based (DTO) projection via constructor expression ----
    @Query("SELECT new com.example.ems.projection.EmployeeDto(e.name, e.email, d.name) "
            + "FROM Employee e JOIN e.department d")
    List<EmployeeDto> fetchAllAsDto();
}
