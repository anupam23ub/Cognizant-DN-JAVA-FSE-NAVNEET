package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeRepository (Doc 2 / Hands-on 3-6 and Doc 3 / Hands-on 2, 4, 5, 6).
 *
 * Extends EmployeeRepositoryCustom so the dynamic Criteria Query
 * (Doc 3 / Hands-on 6) is available alongside the derived and @Query methods.
 */
@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

    // Doc 3 / Hands-on 2: all permanent employees, fetching department and
    // skills in a single query using "left join fetch". This is the optimised
    // final form from the assignment (the EAGER mappings stay in place too,
    // which is harmless - the fetch join short-circuits the extra selects).
    @Query(value = "SELECT DISTINCT e FROM Employee e "
            + "LEFT JOIN FETCH e.department d "
            + "LEFT JOIN FETCH e.skillList "
            + "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Doc 3 / Hands-on 4: average salary across all employees
    @Query(value = "SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    // Doc 3 / Hands-on 4: average salary filtered by department id
    @Query(value = "SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Doc 3 / Hands-on 5: native SQL query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
