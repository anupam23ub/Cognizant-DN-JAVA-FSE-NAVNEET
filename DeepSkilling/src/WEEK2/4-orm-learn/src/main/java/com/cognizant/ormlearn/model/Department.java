package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

/**
 * Department persistence class (Doc 2 / Hands-on 3).
 *
 * Doc 2 / Hands-on 5: one-to-many to Employee. The doc starts with default
 * (LAZY) fetch -> LazyInitializationException, then switches to EAGER. We keep
 * EAGER here so testGetDepartment() works as the doc expects.
 *
 * NOTE (Doc 3 / Hands-on 2 optimisation): the doc later asks to REMOVE this
 * eager fetch and rely on a `join fetch` HQL instead. To follow that step,
 * change `fetch = FetchType.EAGER` back to the default by deleting it.
 */
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private Set<Employee> employeeList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(Set<Employee> employeeList) { this.employeeList = employeeList; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
