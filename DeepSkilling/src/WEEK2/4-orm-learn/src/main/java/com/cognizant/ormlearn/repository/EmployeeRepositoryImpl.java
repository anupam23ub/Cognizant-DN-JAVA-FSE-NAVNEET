package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Criteria Query implementation (Doc 3 / Hands-on 6).
 *
 * Spring Data wires this in automatically because the class name is the
 * repository interface name + "Impl". It uses CriteriaBuilder, CriteriaQuery,
 * Root and TypedQuery exactly as described in the assignment's reference link,
 * adding a predicate only for the filters that were supplied.
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> searchEmployees(String name, Integer departmentId,
                                          Boolean permanent, Double minSalary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(employee.get("name"), "%" + name + "%"));
        }
        if (departmentId != null) {
            predicates.add(cb.equal(employee.get("department").get("id"), departmentId));
        }
        if (permanent != null) {
            predicates.add(cb.equal(employee.get("permanent"), permanent));
        }
        if (minSalary != null) {
            predicates.add(cb.greaterThanOrEqualTo(employee.get("salary"), minSalary));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
