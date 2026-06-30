package com.example.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

/**
 * Employee entity.
 *
 * Exercise 2:  fields id, name, email, department + @ManyToOne to Department.
 * Exercise 5:  @NamedQuery / @NamedQueries declared here.
 * Exercise 7:  extends Auditable.
 * Exercise 10: Hibernate-specific annotations (@DynamicUpdate, @NaturalId).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
@ToString(exclude = "department")
@Entity
@Table(name = "employee")
@DynamicUpdate // Exercise 10: Hibernate only updates changed columns
@NamedQueries({
        // Exercise 5: Named queries
        @NamedQuery(name = "Employee.findByExactName",
                    query = "SELECT e FROM Employee e WHERE e.name = :name"),
        @NamedQuery(name = "Employee.countByDepartment",
                    query = "SELECT COUNT(e) FROM Employee e WHERE e.department.id = :deptId")
})
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NaturalId // Exercise 10: Hibernate natural id (business key)
    @Column(unique = true)
    private String email;

    /** Exercise 2: many Employees belong to one Department. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
