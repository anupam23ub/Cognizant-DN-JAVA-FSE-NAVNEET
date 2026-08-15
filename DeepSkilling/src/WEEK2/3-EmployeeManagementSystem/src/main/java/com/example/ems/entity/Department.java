package com.example.ems.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Department entity.
 *
 * Exercise 2: fields id, name + one-to-many relationship to Employee.
 * Exercise 7: extends Auditable so creation/modification are tracked.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
@ToString(exclude = "employees")
@Entity
@Table(name = "department")
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Exercise 2: one Department has many Employees.
     * cascade + orphanRemoval keep the children consistent with the parent.
     */
    @OneToMany(mappedBy = "department",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @Builder.Default
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    /** Convenience helper to keep both sides of the relationship in sync. */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }
}
