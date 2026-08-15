package com.example.ems.projection;

/**
 * Exercise 8: Class-based (DTO) projection.
 *
 * A constructor expression in the repository (`new EmployeeDto(...)`) tells JPA
 * to fetch exactly these fields and instantiate this immutable DTO.
 */
public class EmployeeDto {

    private final String name;
    private final String email;
    private final String departmentName;

    public EmployeeDto(String name, String email, String departmentName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
